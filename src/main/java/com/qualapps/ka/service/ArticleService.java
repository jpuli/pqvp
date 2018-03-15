package com.qualapps.ka.service;

import com.qualapps.ka.common.PqvpConstants;
import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.data.ArticleData;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.data.PqvpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleService {
    private static final String CATEGORIES_NOT_FOUND_EXCEPTION = "CategoriesNotFoundException";
    private static final String ARTICLE_NOT_CREATED_EXCEPTION = "ArticleNotCreateException";
    private static final String ARTICLE_NOT_FOUND_EXCEPTION = "ArticleNotFoundException";

    @Autowired
    private PqvpDao pqvpdao;



    /**
     * Gets all categories
     *
     * @return List of categories
     * @throws PqvpException Categories not found exception
     */
    public List<CategoryData> getCategories() throws PqvpException {
        List<CategoryData> cats;
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

    /**
     * Servioe to create an article
     *
     * @param article of type ArticleData
     * @return ArticleData
     * @throws PqvpException - Article not created
     */
    public ArticleData createArticle(ArticleData article) throws PqvpException {
        ArticleData art;
        try {
            // set the status to submitted,views and ratings to 0
            article.setArtStatus(PqvpConstants.STATUS_SUBMITTED);
            article.setArtRating(0);
            article.setArtViews(0);
            art = pqvpdao.addArticle(article);
            if (art == null) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_CREATED_EXCEPTION, params);
            } else {
                // add art-category
                pqvpdao.addCatArt(art.getArtId(), art.getCatId());
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_CREATED_EXCEPTION, params);
        }
        return art;
    }


    /**
     * UPdates an article
     * @param article article to update
     * @return updated article
     * @throws PqvpException Article not created exception
     */
    public ArticleData updateArticle(ArticleData article) throws PqvpException {
        ArticleData art;
        try {
            // set the status to submitted
            article.setArtStatus(PqvpConstants.STATUS_SUBMITTED);
            art = pqvpdao.updateArticle(article);
            if (art == null) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_CREATED_EXCEPTION, params);
            } else {
                // update art-category
                pqvpdao.updateCatArt(art.getCatId(), art.getArtId());
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_CREATED_EXCEPTION, params);
        }
        return art;
    }




    /**
     * Gets most recent articles
     *
     * @return List of Articles
     * @throws PqvpException Article not found exception
     */
    public List<ArticleData> getRecentArticles() throws PqvpException {
        List<ArticleData> arts;
        try {
            arts = pqvpdao.getRecentArticles();
            if (arts == null || arts.isEmpty()) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
        }
        return arts;
    }

    /**
     * Gets articles by rating
     *
     * @return List of Articles
     * @throws PqvpException Article not found exception
     */
    public List<ArticleData> getArticlesByRating() throws PqvpException {
        List<ArticleData> arts;
        try {
            arts = pqvpdao.getArticlesByRating();
            if (arts == null || arts.isEmpty()) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
        }
        return arts;
    }

    /**
     * Gets articles by view
     * @return LIst of Articles
     * @throws PqvpException Article not found exception
     */
    public List<ArticleData> getArticlesByViews() throws PqvpException {
        List<ArticleData> arts;
        try {
            arts = pqvpdao.getArticlesByViews();
            if (arts == null || arts.isEmpty()) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
        }
        return arts;
    }

    /**
     * Gets articles based on query
     *
     * @return List of Articles
     * @throws PqvpException Article not found exception
     */
    public List<ArticleData> searchArticles(String query) throws PqvpException {
        List<ArticleData> arts;
        try {
            arts = pqvpdao.getArticlesByContent(query);
            if (arts == null || arts.isEmpty()) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
        }
        return arts;
    }

    /**
     * Gets Articles by User
     * @param query User Id
     * @return List of articles
     * @throws PqvpException Articel not found exception
     */
    public List<ArticleData> getArticlesByUser(long query) throws PqvpException {
        List<ArticleData> arts;
        try {
            arts = pqvpdao.getArticlesByUser(query);
            if (arts == null || arts.isEmpty()) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
        }
        return arts;
    }

    /**
     * Gets Articles by status
     * @param query Status criteria
     * @return LIst of Articles
     * @throws PqvpException  Article not found exception
     */
    public List<ArticleData> getArticlesByStatus(String query) throws PqvpException {
        List<ArticleData> arts;
        try {
            arts = pqvpdao.getArticlesByStatus(query);
            if (arts == null || arts.isEmpty()) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
        }
        return arts;
    }

    /**
     * Gets articles by category
     * @param query Category criteria
     * @return List of Articles
     * @throws PqvpException Article not found exception
     */
    public List<ArticleData> getArticlesByCategory(long query) throws PqvpException {
        List<ArticleData> arts;
        try {
            arts = pqvpdao.getArticlesByCategory(query);
            if (arts == null || arts.isEmpty()) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
        }
        return arts;
    }

    /**
     *
     * @param article the article to update
     * @param articleVersion the new version for this article
     * @throws PqvpException article not created exception
     */
    public void addArticleVersion(ArticleData article, String articleVersion) throws PqvpException {
        try {
            pqvpdao.addArticleVersion(article, articleVersion);
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_CREATED_EXCEPTION, params);
        }
        return;
    }

    /**
     * Gets article based on id
     *
     * @param id
     * @return Article
     * @throws PqvpException Article not found exception
     */
    public ArticleData getArticle(long id) throws PqvpException {
        ArticleData art;
        try {
            art = pqvpdao.getArticles(id);
            if (art == null) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_FOUND_EXCEPTION, params);
        }
        return art;
    }
}
