package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.PqvpResponse;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.ArticleData;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Article REST API
 */
@RestController
public class ArticleController {

    private final ArticleService artSvc;
    private Utils utils = new Utils();

    /**
     * GET categories API
     */
    @Autowired
    public ArticleController(ArticleService artSvc) {
        this.artSvc = artSvc;
    }

    @RequestMapping(method = GET, path = "/api/categories")
    public PqvpResponse getCategories( ) {
        PqvpResponse response = new PqvpResponse();
        try {
            List<CategoryData> res = artSvc.getCategories();
            response.setResult(res);
            response.setError(null);
        } catch (PqvpException e) {
            response.setResult(null);
            response.setError(utils.buildPqvpError(e));
        }
        return response;
    }

    /**
     * Gets articles by status
     * @param status the status of the article
     * @return List of articles
     */
//    @RequestMapping(method = GET, path = "/api/article")
//    public PqvpResponse getArticlesByStatus(@RequestParam String status)  {
//        PqvpResponse response = new PqvpResponse();
//        try {
//            List<ArticleData> res = artSvc.getArticlesByStatus(status);
//            response.setResult(res);
//            response.setError(null);
//        } catch (PqvpException e) {
//            response.setResult(null);
//            response.setError(utils.buildPqvpError(e));
//        }
//        return response;
//    }

    /**
     * Gets articles by category
     * @param category the category id
     * @return List of articles
     */
    @RequestMapping(method = GET, path = "/api/article")
    public PqvpResponse getArticlesByCategory(@RequestParam long category)  {
        PqvpResponse response = new PqvpResponse();
        try {
            List<ArticleData> res = artSvc.getArticlesByCategory(category);
            response.setResult(res);
            response.setError(null);
        } catch (PqvpException e) {
            response.setResult(null);
            response.setError(utils.buildPqvpError(e));
        }
        return response;
    }
}
