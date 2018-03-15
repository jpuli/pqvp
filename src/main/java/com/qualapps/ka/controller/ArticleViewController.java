package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.display.Article;
import com.qualapps.ka.display.User;
import com.qualapps.ka.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleViewController {
  private final ArticleService articleService;
  private Utils utils = new Utils();

  @Autowired
  public ArticleViewController(ArticleService articleService) { this.articleService = articleService; }

  @RequestMapping("/articles/{id}")
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
      modelMap.put("article", new Article(articleService.getArticle(id)));
    } catch (PqvpException e) {
      e.printStackTrace();
      return "redirect:/home";
    }
    return "articles";
  }
}
