package com.qualapps.ka.data;


import com.qualapps.ka.DaasApplication;
import com.qualapps.ka.common.PqvpConstants;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@Transactional
@Rollback()
@SpringBootTest(classes = JunitDaoConfig.class)
@TestPropertySource(locations = "classpath:application.properties")
@ContextConfiguration(classes = {DaasApplication.class})
public class PqvpDaoTest {
    @Autowired
    JdbcTemplate pqvpDB;

    @Autowired
    private PqvpDao dao;

    private UserProfileData user;
    private ArticleData article;

    @Before
    public void setupMock() {
        // add temp user
        user = new UserProfileData();
        user.setUsrName("testUser");
        user.setUsrProfileId(9999);
        user.setUsrPwd("pwd1");
        user.setUsrRole("Admin");
        user.setChngDate(Calendar.getInstance().getTime());
        user.setChngType("I");
        user.setChngUser("testUser");
        user.setEmailAddress("email@example.com");

        // new article
        article = new ArticleData();
        article.setArtId(9999);
        article.setArtTile("New Test Article");
        article.setArtContent("this is a new article to test the ....");
        article.setArtStatus(PqvpConstants.STATUS_APPROVED);
        article.setArtCreator("JohnQPublic");
        article.setCatId(1);
        article.setArtViews(1);
        article.setArtRating(1);
        article.setChngDate(Calendar.getInstance().getTime());
        article.setChngType("I");
        article.setChngUser("testUser");
    }

    @Test
    public void testGetUserByUsrName() throws Exception {
        dao.addUser(user);
        UserProfileData newUsr = dao.getUser("testUser");
        assertThat(user.getUsrRole().equals(newUsr.getUsrRole()));
    }

    @Test
    public void testGetUser() throws Exception {
        dao.addUser(user);
        UserProfileData newUsr = dao.getUser("testUser", "pwd1");
        assertThat(user.getUsrRole().equals(newUsr.getUsrRole()));
    }

    @Test
    public void testGetUserById() throws Exception {
        dao.addUser(user);
        UserProfileData newUsr = dao.getUser(9999);
        assertThat(user.getUsrRole().equals(newUsr.getUsrRole()));
    }

    @Test
    public void testGetAllUsers() throws Exception {
        dao.addUser(user);
        List<UserProfileData> usrs = dao.getUser();
        assertThat(usrs.size() == 1);
        assertThat(usrs.get(0).getUsrRole().equals(user.getUsrRole()));
    }

    @Test
    public void testCreateArticle() throws Exception {
        int articleCount = dao.getArticles().size();
        ArticleData art = dao.addArticle(article);
        assertThat(articleCount + 1 == dao.getArticles().size());
    }

    @Test
    public void testUpdateArticle() throws Exception {
        int articleCount = dao.getArticles().size();
        ArticleData art = dao.addArticle(article);
        assertThat(articleCount + 1 == dao.getArticles().size());
        art.setArtStatus(PqvpConstants.STATUS_REJECTED);
        int rows = dao.updateArticle(art);
        assertThat(rows == 1);
        assertThat(dao.getArticles(art.getArtId()).getArtStatus().equals(PqvpConstants.STATUS_REJECTED));
    }

    @Test
    public void testGetRecentArticles() throws Exception {
        dao.addArticle(article);
        article.setArtViews(110);
        article.setArtStatus(PqvpConstants.STATUS_APPROVED);
        dao.addArticle(article);
        List<ArticleData> arts = dao.getRecentArticles();
        assertTrue(arts.get(0).getArtStatus().equalsIgnoreCase(PqvpConstants.STATUS_APPROVED));
    }

    @Test
    public void testGetArticlesByViews() throws Exception {
        article.setArtStatus(PqvpConstants.STATUS_SUBMITTED);
        dao.addArticle(article);
        article.setArtViews(110);
        article.setArtStatus(PqvpConstants.STATUS_APPROVED);
        dao.addArticle(article);
        List<ArticleData> arts = dao.getArticlesByViews();
        assertTrue(arts.get(0).getArtStatus().equalsIgnoreCase(PqvpConstants.STATUS_APPROVED));
    }

    @Test
    public void testGetArticlesByRating() throws Exception {
        dao.addArticle(article);
        article.setArtId(533);
        article.setArtRating(10);
        dao.addArticle(article);
        List<ArticleData> arts = dao.getArticlesByRating();
        assertThat(arts.get(0).getArtId() == 533);
    }

    @Test
    public void testGetArticlesByStatusAndUserId() throws Exception {
        article.setArtStatus(PqvpConstants.STATUS_APPROVED);
        article.setArtCreator("1");
        dao.addArticle(article);
        List<ArticleData> arts = dao.getArticlesByStatusAndUser(PqvpConstants.STATUS_APPROVED, 1);
        assertTrue(arts.get(0).getArtStatus().equalsIgnoreCase(PqvpConstants.STATUS_APPROVED));
    }
}
