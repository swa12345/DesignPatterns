package com.citiustech.auth.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.citiustech.auth.exception.UserNotFoundException;
import com.citiustech.auth.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtGeneratorImpl jwtTokenUtil;

	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;
		try {
			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				jwtToken = requestTokenHeader.substring(7);
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} else {
				logger.warn("JWT Token does not begin with Bearer String");
				SecurityContextHolder.clearContext();
			}
		} catch (ExpiredJwtException | IllegalArgumentException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
//			log.error("Invalid Token");
		}

		// Once we get the token validate it.
		if (username != null) {

			try {
				UserDetails userDetails = this.userService.loadUserByUsername(username);
				if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					response.setHeader("Authorization", "Bearer " + jwtToken);
					if (SecurityContextHolder.getContext().getAuthentication() == null) {
						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					}
				}
			} catch (UserNotFoundException usr) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_CONFLICT, usr.getMessage());
//				log.error("User Not Found");
			}
		}
		chain.doFilter(request, response);
	}

}
