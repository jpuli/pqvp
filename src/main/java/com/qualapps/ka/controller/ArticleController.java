package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.PqvpResponse;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
