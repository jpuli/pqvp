package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.ArticleData;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.data.UserProfileData;
import com.qualapps.ka.display.Article;
import com.qualapps.ka.display.User;
import com.qualapps.ka.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
  private final ArticleService articleService;
  private Utils utils = new Utils();

  @Autowired
  public HomeController(ArticleService articleService) { this.articleService = articleService; }

  @GetMapping("/home")
  public String home(HttpSession session, ModelMap modelMap) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:logout";
    }

    modelMap.put("user", user);

    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }

    try {
      List<ArticleData> recentArticles = articleService.getRecentArticles();
      List<Article> articles = new ArrayList<>();
      for (ArticleData articleData : recentArticles) {
        articles.add(new Article(articleData));
      }
      modelMap.put("recentArticles", articles);
    } catch (PqvpException e) {
      modelMap.put("recentArticles", new ArrayList<Article>());
    }

    try {
      List<ArticleData> popularArticles = articleService.getArticlesByViews();
      List<Article> articles = new ArrayList<>();
      for (ArticleData articleData : popularArticles) {
        articles.add(new Article(articleData));
      }
      modelMap.put("popularArticles", articles);
    } catch (PqvpException e) {
      modelMap.put("popularArticles", new ArrayList<Article>());
    }
    return "home";
  }

  @GetMapping("/search")
  public String search(HttpSession session, ModelMap modelMap, @RequestParam(name = "query", required = false, defaultValue = "") String query) {
    User user = utils.loadCurrentUser(session);
    if (user == null) {
      return "redirect:logout";
    }

    modelMap.put("user", user);
    modelMap.put("query", query);

    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }

    try {
      List<ArticleData> recentArticleDataList = articleService.searchArticles(query);
      List<Article> articles = new ArrayList<>();
      for (ArticleData articleData : recentArticleDataList) {
        articles.add(new Article(articleData));
      }
      modelMap.put("results", articles);
    } catch (PqvpException e) {
      modelMap.put("results", new ArrayList<Article>());
    }
    return "search";
  }


}
