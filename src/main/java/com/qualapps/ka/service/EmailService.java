package com.qualapps.ka.service;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.qualapps.ka.common.PqvpException;

@Component
public class EmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;
	
	private static final Logger logger = LogManager.getLogger(EmailService.class);

	private static final String EMAIL_EXCEPTION = "EmailServiceException";
	 
    
 
    public void sendTextEmail(String to, String cc,String bcc,String subject, String text) throws PqvpException{
    	sendEmail(to,cc,bcc, subject, text, false);
    }
 
    public void sendHtml(String to,String cc,String bcc, String subject, String htmlBody) throws PqvpException{
        sendEmail(to,cc,bcc, subject, htmlBody, true);
    }
 
    private void sendEmail(String to,String cc,String bcc, String subject, String text, Boolean isHtml) throws PqvpException{
        try {
        	logger.info("Starting send email");
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            if(cc!=null)
            {
            	helper.setCc(cc);
            }
            if(bcc!=null)
            {
            	helper.setBcc(bcc);
            }
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            javaMailSender.send(mail);
            logger.info(String.format("Email sent to '{}' with subject: {}", to,subject));
            
        } catch (Exception e) {
        	logger.error(String.format("Error sending email to: {}, error message: {}", to, e.getMessage()));
            String[] params = new String[]{};
            throw new PqvpException(EMAIL_EXCEPTION, params);
        }
    }
   
    public void sendTemplateEmail(String to,String cc,String bcc, String subject, String templateName, Context context)  throws PqvpException{
        String htmlbody = templateEngine.process(templateName, context);
        this.sendHtml(to,cc,bcc, subject, htmlbody);
    }

}
