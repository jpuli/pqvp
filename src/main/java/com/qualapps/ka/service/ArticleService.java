package com.qualapps.ka.service;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.data.PqvpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleService {
    private static final String CATEGORIES_NOT_FOUND_EXCEPTION = "CategoriesNotFoundException";

    @Autowired
    private PqvpDao pqvpdao;

    /**
     * Service to fetch a user
     * @param
     * @return user
     * @throws PqvpException - USer not found
     */
    public List<CategoryData> getCategories() throws PqvpException{
        List<CategoryData> cats = new ArrayList<CategoryData>();
        try {
            cats = pqvpdao.getCategory();
            if (cats.isEmpty()) {
                String[] params = new String[]{};
                throw new PqvpException(CATEGORIES_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(CATEGORIES_NOT_FOUND_EXCEPTION, params);
        }
        return cats;
    }
}