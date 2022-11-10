package com.citiustech.auth.controller;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.auth.entity.CustomUserDetails;
import com.citiustech.auth.exception.UserNotFoundException;
import com.citiustech.auth.jwt.JwtGeneratorImpl;
import com.citiustech.auth.service.UserService;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

	@Autowired
	private JwtGeneratorImpl jwtTokenUtil;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<CustomUserDetails> authenticate(HttpServletRequest request, HttpServletResponse response)
			throws IOException, AuthenticationException, UserNotFoundException {
//		final String requestTokenHeader = request.getHeader("Authorization");
//
//		String username = null;
//		String jwtToken = null;
//		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
//		try {
//			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//				jwtToken = requestTokenHeader.substring(7);
//				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//			} else {
//				//logger.warn("JWT Token does not begin with Bearer String");
//				//SecurityContextHolder.clearContext();
//				throw new AuthenticationException("Not Authenticated");
//			}
//		} catch (ExpiredJwtException | IllegalArgumentException e) {
//			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
//			//log.error("Invalid Token");
//		}
//
//		// Once we get the token validate it.
//		if (username != null) {
//
//			try {
//				UserDetails userDetails = this.userService.loadUserByUsername(username);
//				if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//					 usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//							userDetails, null, userDetails.getAuthorities());
//					usernamePasswordAuthenticationToken
//							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//					response.setHeader("Authorization", "Bearer " + jwtToken);
//					
//				}
//			} catch (UserNotFoundException usr) {
//				response.setStatus(HttpServletResponse.SC_CONFLICT);
//				((HttpServletResponse) response).sendError(HttpServletResponse.SC_CONFLICT, usr.getMessage());
//				
//			}
//		}
//		return new ResponseEntity<UsernamePasswordAuthenticationToken>(usernamePasswordAuthenticationToken, HttpStatus.OK);	

		String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = requestTokenHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		UserDetails userDetails = userService.loadUserByUsername(username);
		boolean isValid = jwtTokenUtil.validateToken(jwtToken, userDetails);
		String role = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
		CustomUserDetails customUserDetails = new CustomUserDetails(userDetails, null, role);
		if (isValid) {
			return new ResponseEntity<CustomUserDetails>(customUserDetails, HttpStatus.OK);
		}
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>("User logout successfully", HttpStatus.OK);
    }
}
