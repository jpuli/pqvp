package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpConstants;
import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.ArticleData;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.display.Article;
import com.qualapps.ka.display.User;
import com.qualapps.ka.service.ArticleService;
import com.qualapps.ka.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
  private final ArticleService articleService;
  private final UserProfileService userService;
  private Utils utils = new Utils();

  @Autowired
  public AdminController(ArticleService articleService, UserProfileService userService) {
    this.articleService = articleService;
    this.userService = userService;
  }

  @GetMapping("/admin/queue")
  public String approval_queue(HttpSession session, ModelMap modelMap) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    } else if (!user.isAdmin()) {
      return "redirect:/home";
    }
    modelMap.put("user", user);
    modelMap.put("isAdminQueuePage", true);
    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }
    try {
      List<ArticleData> popularArticles = articleService.getArticlesByStatus(PqvpConstants.STATUS_SUBMITTED);
      List<Article> articles = new ArrayList<>();
      for (ArticleData articleData : popularArticles) {
        articles.add(new Article(articleData, userService));
      }
      modelMap.put("articles", articles);
    } catch (PqvpException e) {
      modelMap.put("articles", new ArrayList<Article>());
    }
    return "admin_queue";
  }
}
