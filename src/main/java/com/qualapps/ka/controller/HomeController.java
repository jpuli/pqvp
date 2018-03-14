package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.data.ArticleData;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.data.UserProfileData;
import com.qualapps.ka.display.Article;
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

  @Autowired
  public HomeController(ArticleService articleService) { this.articleService = articleService; }

  @GetMapping("/home")
  public String home(HttpSession session, ModelMap modelMap) {
    UserProfileData user = loadCurrentUser(session);
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
      List<Article> recentArticles = prepareArticleDataForDisplay(articleService.getRecentArticles());
      modelMap.put("recentArticles", recentArticles);
    } catch (PqvpException e) {
      modelMap.put("recentArticles", new ArrayList<Article>());
    }

    try {
      List<Article> popularArticles = prepareArticleDataForDisplay(articleService.getArticlesByRating());
      modelMap.put("popularArticles", popularArticles);
    } catch (PqvpException e) {
      modelMap.put("popularArticles", new ArrayList<Article>());
    }
    return "home";
  }

  @GetMapping("/search")
  public String search(HttpSession session, ModelMap modelMap, @RequestParam(name = "query", required = false, defaultValue = "") String query) {
    UserProfileData user = loadCurrentUser(session);
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
      List<Article> recentArticles = prepareArticleDataForDisplay(articleService.searchArticles(query));
      modelMap.put("results", recentArticles);
    } catch (PqvpException e) {
      modelMap.put("results", new ArrayList<Article>());
    }
    return "search";
  }

  private UserProfileData loadCurrentUser(HttpSession session) {
    UserProfileData user = null;
    Object sessionData = session.getAttribute("user");
    if (sessionData != null && sessionData instanceof UserProfileData) {
      user = (UserProfileData)sessionData;
    }
    return user;
  }


  private List<Article> prepareArticleDataForDisplay(List<ArticleData> articleDataList) {
    List<Article> articles = new ArrayList<>();
    for (ArticleData articleData : articleDataList) {
      Article article = new Article();
      article.setId(articleData.getArtId());
      article.setTitle(articleData.getArtTile());
      article.setChanged(articleData.getChngDate());
      article.setChangeUser(articleData.getChngUser());
      article.setSummary(articleData.getArtContent().substring(0, 300) + "...");
      //article.setCategory(StringUtils.capitalize(pqvpdao.getCategory(articleData.getCatId()).getCatName()));
      articles.add(article);
    }
    return articles;
  }
}
