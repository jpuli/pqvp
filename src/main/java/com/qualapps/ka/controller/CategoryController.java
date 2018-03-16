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
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
  private final ArticleService articleService;
  private final UserProfileService userService;
  private Utils utils = new Utils();

  @Autowired
  public CategoryController(ArticleService articleService, UserProfileService userService) {
    this.articleService = articleService;
    this.userService = userService;
  }

  @GetMapping("/categories")
  public String allCategories(HttpSession session, ModelMap modelMap) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:/logout";
    }
    modelMap.put("user", user);
    modelMap.put("adminQueueCount", utils.countAdminQueue(articleService, userService));
    modelMap.put("categoryDescription", "All");
    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }

    try {
      List<ArticleData> recentArticles = articleService.getArticlesByStatus(PqvpConstants.STATUS_APPROVED);
      List<Article> articles = new ArrayList<>();
      for (ArticleData articleData : recentArticles) {
        articles.add(new Article(articleData, articleService, userService));
      }
      modelMap.put("articles", articles);
    } catch (PqvpException e) {
      modelMap.put("articles", new ArrayList<Article>());
    }

    return "categories";
  }

  @GetMapping("/categories/{categoryName}")
  public String allCategories(HttpSession session, ModelMap modelMap, @PathVariable(value="categoryName") String categoryName) {
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

    try {
      CategoryData category = articleService.getCategory(categoryName);
      modelMap.put("categoryDescription", category.getCatDescr());
      List<ArticleData> recentArticles = articleService.getArticlesByCategory(category.getCatId());
      List<Article> articles = new ArrayList<>();
      for (ArticleData articleData : recentArticles) {
        articles.add(new Article(articleData, articleService, userService));
      }
      modelMap.put("articles", articles);
    } catch (PqvpException e) {
      modelMap.put("articles", new ArrayList<Article>());
    }

    return "categories";
  }
}
