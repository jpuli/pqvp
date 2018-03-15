package com.qualapps.ka.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {
	
	@Autowired
	EmailService emailSvc;
	
	@Test
	public void sendEmailTest() throws Exception
	{
		String to="joepuli@gmail.com";
		String subject="Daas is Awesome!!";
		String body="Plase visit us at http://daas.qualapps.com";
		emailSvc.sendTextEmail(to,null,null,subject, body);
	}

}
