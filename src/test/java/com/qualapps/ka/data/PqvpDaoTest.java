package com.qualapps.ka.data;


import com.qualapps.ka.DaasApplication;
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
        article.setArtStatus("Initial");
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
        ArticleData art = dao.addArticle(article);
        assertThat(art.getArtId() != article.getArtId());
    }

    @Test
    public void testGetRecentArticles() throws Exception {
        dao.addArticle(article);
        article.setArtId(245);
        article.setArtViews(110);
        dao.addArticle(article);
        List<ArticleData> arts = dao.getRecentArticles();
        assertThat(arts.get(0).getArtId() == 245);
    }

    @Test
    public void testGetArticlesByViews() throws Exception {
        dao.addArticle(article);
        article.setArtId(245);
        article.setArtViews(110);
        dao.addArticle(article);
        List<ArticleData> arts = dao.getArticlesByViews();
        assertThat(arts.get(0).getArtId() == 245);
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
}
