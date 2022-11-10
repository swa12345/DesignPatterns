package com.citiustech.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.citiustech.auth.jwt.CorsFilter;
import com.citiustech.auth.jwt.JwtRequestFilter;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtRequestFilter jwtFilter;
	
	@Autowired
	private CorsFilter corsFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.addFilterBefore(corsFilter, ChannelProcessingFilter.class)
		.addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/user/login").permitAll()
		.antMatchers(HttpMethod.POST, "/user/register").permitAll()
		.anyRequest().authenticated();

	}
	

}
