package com.citiustech.auth.jwt;

import com.citiustech.auth.entity.User;

public interface JwtGeneratorInterface {

     // Map<String, String> generateToken(User user);	
	
	String generateToken(User user);
}
