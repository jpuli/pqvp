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
    UserProfileData user = (UserProfileData) session.getAttribute("user");
    modelMap.put("user", user);

    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
      List<Article> recentArticles = articleService.getRecentArticles();
      modelMap.put("recentArticles", recentArticles);
      return "home";
    } catch (PqvpException e) {
      return "index";
    }
  }
}
