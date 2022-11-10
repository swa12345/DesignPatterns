package com.citiustech.auth.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citiustech.auth.dto.UserDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "sendEmailFallback")
	public void sendEmail(String notificationId, UserDTO userDto) {
		Map<String, Object> emailInfo = new HashMap<>();
//		{
//		    "recipient":[
//		        "eshanjindal9@gmail.com"
//		        ],
//		    "payload":{
//		        "login":"Anusha",
//		        "resetKey":"$C&F)J@N",
//		        "baseUrl": "http://localhost:8090"
//		    }
//		}
		emailInfo.put("recipient", Arrays.asList(userDto.getEmailId()));
		Map<String, String> payload = new HashMap<>();
		payload.put("login", userDto.getFirstName());
		payload.put("resetKey", "Password@123");
		payload.put("baseUrl", "http://localhost:8090");
		emailInfo.put("payload", payload);
		restTemplate.postForObject("http://EMAILSERVICE" + "/api/email/" + notificationId, emailInfo, ResponseEntity.class);
	}
	
	public void sendEmailFallback(String notificationId, UserDTO userDto) {
		System.out.println("Email Service is down");
	}
	
}
