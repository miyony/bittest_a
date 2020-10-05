package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

import kr.co.youiwe.webservice.CEncrypt;
import kr.co.youiwe.webservice.ServiceSMSSoapProxy;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Component
// 일처리를 위해서 필요한 class라는 뜻
// 자동으로 스캔
public class BitSms {
	
	
	
	public String sendMsg(String from, String to, String msg) {
		
//		BufferedReader in;
//	    in = new BufferedReader(new InputStreamReader(System.in));
		// 키보드로 입력받을게 아니라서 필요없음~

		String smsID= "rola";	
		String smsPW="bit123400";
		String send = null;
	
		
		ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
		try{
		
		String senderPhone= from;
		
		String receivePhone= to;
		
		String smsContent= msg;
		
		String test1 = (smsID+smsPW+receivePhone);
		CEncrypt encrypt = new CEncrypt("MD5",test1);
		send=sendsms.sendSMS(smsID,encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
 		System.out.println("결과코드:"+send);
		}catch(Exception e){
		System.out.println("Exception in main:" +e);
		}
		
		return send;
	}
	

	
	

}
