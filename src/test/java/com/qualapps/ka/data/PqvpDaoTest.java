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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@Rollback(true)
@SpringBootTest(classes = JunitDaoConfig.class)
@TestPropertySource(locations = "classpath:application.properties")
@ContextConfiguration(classes = {DaasApplication.class})
public class PqvpDaoTest {
    @Autowired
    JdbcTemplate pqvpDB;

    @Autowired
    private PqvpDao dao;

    private UserProfileData user;

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
    }

    @Test
    public void testGetUserByUsrName() throws Exception {
        dao.addUser(user);
        UserProfileData newUsr = dao.getUserByUserName("testUser");
        assertThat(user.getUsrRole().equals(newUsr.getUsrRole()));
    }

    @Test
    public void testGetUser() throws Exception {
        dao.addUser(user);
        UserProfileData newUsr = dao.getUser("testUser", "pwd1");
        assertThat(user.getUsrRole().equals(newUsr.getUsrRole()));
    }

}
