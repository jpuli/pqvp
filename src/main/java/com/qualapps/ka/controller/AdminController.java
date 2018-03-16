package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpConstants;
import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.ArticleData;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.display.Article;
import com.qualapps.ka.display.User;
import com.qualapps.ka.service.ArticleService;
import com.qualapps.ka.service.EmailService;
import com.qualapps.ka.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
  private final ArticleService articleService;
  private final UserProfileService userService;
  private final EmailService emailService;
  private Utils utils = new Utils();

  @Autowired
  public AdminController(ArticleService articleService, UserProfileService userService, EmailService emailService) {
    this.articleService = articleService;
    this.userService = userService;
    this.emailService = emailService;
  }

  @PostMapping("/admin/approve")
  public String approveArticle(HttpSession session, @RequestParam("id") long articleId) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    } else if (!user.isAdmin()) {
      return "redirect:/home";
    }

    try {
      ArticleData article = articleService.getArticle(articleId);
      article.setChngUser(Long.toString(user.getId()));
      article.setChngDate(new Date());
      article.setChngType("U");
      articleService.updateArticle(article, PqvpConstants.STATUS_APPROVED);
      StringBuilder body = new StringBuilder();
      body.append("Article #");
      body.append(article.getArtId());
      body.append(" [");
      body.append(article.getArtTile());
      body.append("] Approved By ");
      body.append(user.getName());
      body.append("\nhttp://daas.qualapps.com/");
      emailService.sendTextEmail("qualapps.jira.read@gmail.com","info@qualapps.com",null, "Daas Article ["+article.getArtTile()+"] Published", body.toString());
    } catch (PqvpException e) {
      e.printStackTrace();
    }

    return "redirect:/articles/" + articleId;
  }

  @PostMapping("/admin/reject")
  public String rejectArticle(HttpSession session, @RequestParam("id") long articleId) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    } else if (!user.isAdmin()) {
      return "redirect:/home";
    }

    try {
      ArticleData article = articleService.getArticle(articleId);
      article.setChngUser(Long.toString(user.getId()));
      article.setChngDate(new Date());
      article.setChngType("U");
      articleService.updateArticle(article, PqvpConstants.STATUS_REJECTED);
    } catch (PqvpException e) {
      e.printStackTrace();
    }

    return "redirect:/articles/" + articleId;
  }

  @GetMapping("/admin/queue")
  public String approvalQueue(HttpSession session, ModelMap modelMap) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    } else if (!user.isAdmin()) {
      return "redirect:/home";
    }
    modelMap.put("user", user);
    modelMap.put("version", utils.getVersion());
    modelMap.put("isAdminQueuePage", true);
    modelMap.put("pageTitle", "Approval Queue");
    modelMap.put("adminQueueCount", utils.countAdminQueue(articleService, userService));
    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }
    List<ArticleData> approvalRequiredArticles = new ArrayList<>();
    try {
      approvalRequiredArticles.addAll(articleService.getArticlesByStatus(PqvpConstants.STATUS_SUBMITTED));
    } catch (PqvpException e) {
      e.printStackTrace();
    }
    try {
      approvalRequiredArticles.addAll(articleService.getArticlesByStatus(PqvpConstants.STATUS_REJECTED));
    } catch (PqvpException e) {
      e.printStackTrace();
    }
    List<Article> articles = new ArrayList<>();
    for (ArticleData articleData : approvalRequiredArticles) {
      articles.add(new Article(articleData, articleService, userService));
    }
    modelMap.put("articles", articles);
    return "article_queue";
  }

  @GetMapping("/admin/approved")
  public String approvedByMe(HttpSession session, ModelMap modelMap) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    } else if (!user.isAdmin()) {
      return "redirect:/home";
    }
    modelMap.put("user", user);
    modelMap.put("version", utils.getVersion());
    modelMap.put("isApprovedByMePage", true);
    modelMap.put("pageTitle", "Approved By Me");
    modelMap.put("adminQueueCount", utils.countAdminQueue(articleService, userService));
    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }
    List<ArticleData> approvalRequiredArticles = new ArrayList<>();
    try {
      approvalRequiredArticles.addAll(articleService.getArticlesByStatusAndUser(PqvpConstants.STATUS_APPROVED, user.getId()));
    } catch (PqvpException e) {
      e.printStackTrace();
    }
    List<Article> articles = new ArrayList<>();
    for (ArticleData articleData : approvalRequiredArticles) {
      articles.add(new Article(articleData, articleService, userService));
    }
    modelMap.put("articles", articles);
    return "article_queue";
  }

  @GetMapping("/user/submissions")
  public String submissionQueue(HttpSession session, ModelMap modelMap) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    } else if (!user.canCreateArticles()) {
      return "redirect:/home";
    }
    modelMap.put("user", user);
    modelMap.put("version", utils.getVersion());
    modelMap.put("isUserSubmissionPage", true);
    modelMap.put("pageTitle", "My Submission Queue");
    modelMap.put("adminQueueCount", utils.countAdminQueue(articleService, userService));
    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }
    List<ArticleData> approvalRequiredArticles = new ArrayList<>();
    try {
      approvalRequiredArticles.addAll(articleService.getArticlesByUser(user.getId()));
    } catch (PqvpException e) {
      e.printStackTrace();
    }
    List<Article> articles = new ArrayList<>();
    for (ArticleData articleData : approvalRequiredArticles) {
      articles.add(new Article(articleData, articleService, userService));
    }
    modelMap.put("articles", articles);
    return "article_queue";
  }
}
