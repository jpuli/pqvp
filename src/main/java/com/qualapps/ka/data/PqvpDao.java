package com.qualapps.ka.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

@Component
public class PqvpDao {

    @Autowired
    JdbcTemplate pqvpDb;

    public UserProfileData addUser(UserProfileData usr) {
        pqvpDb.update(PqvpSql.addUser, usr.getUsrProfileId(), usr.getUsrName(), usr.getUsrPwd(), usr.getUsrRole(), usr.getEmailAddress(), usr.getChngDate(), usr.getChngType(), usr.getChngUser());
        return usr;
    }

    public UserProfileData getUser(String usrName) {
        UserProfileData usr = pqvpDb.queryForObject(PqvpSql.getUserByUserName, new Object[]{usrName}, new UserprofileDataMapper());
        return usr;
    }

    public UserProfileData getUser(long usrId) {
        UserProfileData usr = pqvpDb.queryForObject(PqvpSql.getUserByUserId, new Object[]{usrId}, new UserprofileDataMapper());
        return usr;
    }
    public UserProfileData getUser(String usrName, String usrPwd) {
        UserProfileData usr = pqvpDb.queryForObject(PqvpSql.getUser, new Object[]{usrName, usrPwd}, new UserprofileDataMapper());
        return usr;
    }

    public List<UserProfileData> getUser() {
        List<UserProfileData> usrs = pqvpDb.query(PqvpSql.getAllUsers, new UserprofileDataMapper());
        return usrs;
    }

    public List<ArticleData> getArticles() {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getAllArticles, new ArticleDataMapper());
        return artiLst;
    }

    public List<ArticleData> getArticlesByRating() {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getArticlesByRating, new ArticleDataMapper());
        return artiLst;
    }

    public List<ArticleData> getArticlesByViews() {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getArticlesByViews, new ArticleDataMapper());
        return artiLst;
    }

    public List<ArticleData> getRecentArticles() {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getRecentArticles, new ArticleDataMapper());
        return artiLst;
    }

    public List<ArticleData> getArticlesByTitle(String qry) {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getAllArticlesByTitle, new Object[]{qry}, new ArticleDataMapper());
        return artiLst;
    }

    public List<ArticleData> getArticlesByUser(long qry) {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getArticlesByUser, new Object[]{qry}, new ArticleDataMapper());
        return artiLst;
    }
    public List<ArticleData> getArticlesByContent(String qry) {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getAllArticlesByContent, new Object[]{qry}, new ArticleDataMapper());
        return artiLst;
    }

    public List<ArticleData> getArticlesByStatus(String qry) {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getArticlesByStatus, new Object[]{qry}, new ArticleDataMapper());
        return artiLst;
    }

    public List<ArticleData> getArticlesByStatusAndUser(String status, long userId) {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getArticlesByStatusAndUser, new Object[]{status, Long.toString(userId)}, new ArticleDataMapper());
        return artiLst;
    }

    public List<ArticleData> getArticlesByCategory(long qry) {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getArticlesByCategory, new Object[]{qry}, new ArticleDataMapper());
        return artiLst;
    }

    public ArticleData getArticles(long artiId) {
        List<ArticleData> artiLst = pqvpDb.query(PqvpSql.getArticleForId, new Object[]{artiId}, new ArticleDataMapper());
        return artiLst.get(0);
    }

    public ArticleData addArticle(ArticleData art) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        pqvpDb.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(PqvpSql.addArticle, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, art.getArtTile());
                statement.setString(2, art.getArtContent());
                statement.setLong(3, art.getArtViews());
                statement.setString(4, art.getArtStatus());
                statement.setLong(5, art.getArtRating());
                statement.setString(6, art.getArtCreator());
                statement.setDate(7, new java.sql.Date(new Date().getTime()));
                statement.setString(8, art.getArtTags());
                statement.setString(9, art.getArtAccess());
                statement.setDate(10, new java.sql.Date(new Date().getTime()));
                statement.setString(11, "I");
                statement.setString(12, art.getChngUser());
                return statement;
            }
        }, holder);

        long primaryKey = holder.getKey().longValue();
        art.setArtId(primaryKey);
        return art;
    }

    public ArticleData updateArticle(ArticleData art) {
        pqvpDb.update(PqvpSql.updateArticle, art.getArtTile(), art.getArtContent(), art.getArtViews(),
                art.getArtStatus(), art.getArtTags(), art.getArtAccess(), new Date(), "I", art.getChngUser(), art.getArtId());
        return art;
    }

    public void deleteArticle(long artId) {
        pqvpDb.update(PqvpSql.deleteArticle, artId);
    }

    public List<ArtifactData> getArtifacts() {
        List<ArtifactData> artiLst = pqvpDb.query(PqvpSql.getAllArtifacts, new ArtifactDataMapper());
        return artiLst;
    }


    public List<ArtifactData> getArtifacts(long artifId) {
        List<ArtifactData> artiLst = pqvpDb.query(PqvpSql.getArtifactsForId, new Object[]{artifId}, new ArtifactDataMapper());
        return artiLst;
    }

    public List<ArtifactData> getArtifactsForArtiicle(long articleId) {
        List<ArtifactData> artiLst = pqvpDb.query(PqvpSql.getArtifactsForArt, new Object[]{articleId}, new ArtifactDataMapper());
        return artiLst;
    }

    public ArtifactData addArtifact(ArtifactData arti) {
        pqvpDb.update(PqvpSql.addArtifact, arti.getArtifId(), arti.getArtifLoc(), arti.getArtifType(), new Date(), "I", arti.getChngUser(), arti.getArtifDesc(), arti.getArtId());
        return arti;
    }

    public ArtifactData updateArtifact(ArtifactData arti) {
        pqvpDb.update(PqvpSql.updateArtifact, arti.getArtifLoc(), arti.getArtifType(), new Date(), "U", arti.getChngUser(), arti.getArtifDesc(), arti.getArtId(), arti.getArtifId());
        return arti;
    }

    public void deleteArtifact(long artifId) {
        pqvpDb.update(PqvpSql.deleteArtifact, artifId);
    }

    public void deleteArtifactForArt(long artId) {
        pqvpDb.update(PqvpSql.deleteArtifactForArt, artId);
    }

    public List<CategoryData> getCategory() {
        List<CategoryData> catLst = pqvpDb.query(PqvpSql.getAllCategory, new CategoryDataMapper());
        return catLst;
    }

    public CategoryData getCategory(long catId) {
        CategoryData cat = pqvpDb.queryForObject(PqvpSql.getCategoryForCatId, new CategoryDataMapper());
        return cat;
    }

    public CategoryData getCategory(String catName) {
        CategoryData cat = pqvpDb.queryForObject(PqvpSql.getCategoryForCatName, new Object[]{catName}, new CategoryDataMapper());
        return cat;
    }
    public CategoryData addCategory(CategoryData cat) {
        pqvpDb.update(PqvpSql.addCategory, cat.getCatId(), cat.getCatName(), cat.getCatDescr(), new Date(), "I", cat.getChngUser());
        return cat;
    }

    public CategoryData updateCategory(CategoryData cat) {
        pqvpDb.update(PqvpSql.updateCategory, cat.getCatName(), cat.getCatDescr(), new Date(), "U", cat.getChngUser(), cat.getCatId());
        return cat;
    }

    public void deleteCategory(long catId) {
        pqvpDb.update(PqvpSql.deleteCategory, catId);
    }

    public void addCatArt(long artId, long catId) {
        pqvpDb.update(PqvpSql.addCatArt, artId, catId);
    }

    public void updateCatArt(long artId, long catId) {
        pqvpDb.update(PqvpSql.addCatArt, catId, artId);
    }

    public void deleteCatArtForArt(long artId) {
        pqvpDb.update(PqvpSql.deleteCatArtForArt, artId);
    }

    public void deleteCatArtForCat(long catId) {
        pqvpDb.update(PqvpSql.deleteCatForCat, catId);
    }

    public List<ArticleData> getArtForCat(long catId) {
        List<ArticleData> artLst = pqvpDb.query(PqvpSql.getArtCat, new Object[]{catId}, new ArticleDataMapper());
        return artLst;
    }

    public List<CategoryData> getCatArt(long artId) {
        List<CategoryData> catLst = pqvpDb.query(PqvpSql.getCatArt, new Object[]{artId}, new CategoryDataMapper());
        return catLst;
    }

    public void addArticleVersion(ArticleData art, String articleVersion) {
        pqvpDb.update(PqvpSql.addArticleVersion, articleVersion, new Date(), new Date(), "I", art.getChngUser(), art.getArtId(), art.getArtTile(), art.getArtContent());
        return;
    }

}
