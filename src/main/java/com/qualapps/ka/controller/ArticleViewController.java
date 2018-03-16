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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleViewController {
  private final ArticleService articleService;
  private final UserProfileService userService;
  private Utils utils = new Utils();

  @Autowired
  public ArticleViewController(ArticleService articleService, UserProfileService userService) {
    this.articleService = articleService;
    this.userService = userService;
  }

  @GetMapping("/articles/new")
  public String newArticle(HttpSession session, ModelMap modelMap) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    }
    modelMap.put("user", user);
    modelMap.put("isCreateNewPage", true);
    modelMap.put("adminQueueCount", utils.countAdminQueue(articleService, userService));
    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }

    return "create_article";
  }

  @PostMapping("/article_create")
  public String createArticle(
      HttpSession session,
      @RequestParam(name="title") String title,
      @RequestParam(name="category") String category,
      @RequestParam(name="content") String content,
      @RequestParam(name="tags",required = false, defaultValue = "") String tags,
      @RequestParam(name="visibility",required = false, defaultValue = "") String visibility
  ) throws PqvpException {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    }

    ArticleData article = new ArticleData();
    article.setArtContent(content);
    article.setArtTile(title);
    article.setArtTags(tags);
    article.setArtAccess(visibility);
    article.setChngUser(Long.toString(user.getId()));
    article.setArtCreator(Long.toString(user.getId()));
    // look up category
    if (!StringUtils.isEmptyOrWhitespace(category)) {
      try {
        CategoryData categoryData = articleService.getCategory(category);
        article.setCatId(categoryData.getCatId());
      } catch (PqvpException e) {
        try {
          CategoryData categoryData = articleService.getCategories().get(0);
          article.setCatId(categoryData.getCatId());
        } catch (PqvpException e2) {
          e.printStackTrace();
        }
      }
    }

    article = articleService.createArticle(article);
    return "redirect:/articles/" + article.getArtId();
  }

  @GetMapping("/articles/{id}")
  public String showArticle(HttpSession session, ModelMap modelMap, @PathVariable(value="id") long id) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    }
    modelMap.put("user", user);
    modelMap.put("adminQueueCount", utils.countAdminQueue(articleService, userService));
    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }
    ArticleData articleData = null;
    try {
      articleData = articleService.getArticle(id);
      Article article = new Article(articleData, articleService, userService);
      modelMap.put("isAdminReview", (!PqvpConstants.STATUS_APPROVED.equals(articleData.getArtStatus()) && user.isAdmin()));
      modelMap.put("article", article);
    } catch (PqvpException e) {
      e.printStackTrace();
      return "redirect:/home";
    } finally {
      if (articleData != null && PqvpConstants.STATUS_APPROVED.equals(articleData.getArtStatus())) {
        try {
          long currentViews = articleData.getArtViews();
          articleData.setArtViews(++currentViews);
          articleService.updateArticle(articleData, PqvpConstants.STATUS_APPROVED);
        } catch (PqvpException e) {
          // ignore error incrementing views to at least allow display
        }
      }
    }

    return "articles";
  }
}
