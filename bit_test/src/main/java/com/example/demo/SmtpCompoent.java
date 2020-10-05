package com.example.demo;


import java.util.Properties;

import org.apache.tomcat.jni.SSL;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SmtpCompoent {
	
	@Bean
	public JavaMailSenderImpl javaMailSender()
	{
		JavaMailSenderImpl r = new JavaMailSenderImpl();
		r.setHost("smtp.naver.com");
		r.setPort(465);
		r.setUsername("tazomi");
		r.setPassword("Aldus1103ss");
		r.setDefaultEncoding("UTF-8");
		r.setProtocol("smtp");
		
		Properties prop = new Properties();
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.checkserveridentity", true);
		prop.put("mail.smtp.ssl.trust","*");
		
		//prop.put("mail.debug", true);
		//prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		r.setJavaMailProperties(prop);
		
		

		return r;
	}
	
	

	
}








