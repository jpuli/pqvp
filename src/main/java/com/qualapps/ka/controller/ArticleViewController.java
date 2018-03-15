package com.qualapps.ka.controller;

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
      @RequestParam("title") String title,
      @RequestParam("category") String category,
      @RequestParam("content") String content,
      @RequestParam("tags") String tags,
      @RequestParam("visibility") String visibility
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
    try {
      List<CategoryData> categories = articleService.getCategories();
      modelMap.put("categories", categories);
    } catch (PqvpException e) {
      modelMap.put("categories", new ArrayList<CategoryData>());
    }
    try {
      modelMap.put("article", new Article(articleService.getArticle(id), userService));
    } catch (PqvpException e) {
      e.printStackTrace();
      return "redirect:/home";
    }
    return "articles";
  }
}
