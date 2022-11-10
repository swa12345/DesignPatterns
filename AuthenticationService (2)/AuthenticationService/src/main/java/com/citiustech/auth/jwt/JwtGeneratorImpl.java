package com.citiustech.auth.jwt;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.citiustech.auth.entity.User;
import com.citiustech.auth.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGeneratorImpl implements JwtGeneratorInterface {

	// @Override
//	public Map<String, String> generateToken(User user) {
//		String jwtToken = "";
//		Claims claims = Jwts.claims().setIssuer(String.valueOf(user.getUserId()));
//		claims.put("FirstName", user.getFirstName());
//		jwtToken = Jwts.builder()
//                .setClaims(claims)
//                .signWith(SignatureAlgorithm.HS256, "Secret")
//                .compact();
////		jwtToken = Jwts.builder().setSubject(user.getEmailId()).setIssuedAt(new Date())
////				.signWith(SignatureAlgorithm.HS256, "secret")
////				//.claim("role", user.getRole().getCode())
////				//.claim("user_details", new User(user.getUserId(), user.getRole()))
////
////				.compact();
//		Map<String, String> jwtTokenGen = new HashMap<>();
//		jwtTokenGen.put("token", jwtToken);
//		jwtTokenGen.put("message", "Token Generated");
//		return jwtTokenGen;
//	}

	private static String secret = "This_is_secret";
	private static long expiryDuration = 60 * 60;

	@Autowired
	UserService userService;

	public String generateToken(User user) {

		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + expiryDuration * 1000;

		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expiryTime);

		// claims
		Claims claims = Jwts.claims().setIssuer(String.valueOf(user.getUserId())).setIssuedAt(issuedAt)
				.setExpiration(expiryAt);

		// optional claims
		claims.put("firstName", user.getFirstName());
		claims.put("userId", user.getUserId());
		claims.put("role", user.getRole().getCode());
		claims.put("status", user.getStatus().getCode());
		claims.put("emailId", user.getEmailId());


		// generate jwt using claims
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public Claims verify(String authorization) throws Exception {

		try {
			Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
			return claims;
		} catch (Exception e) {
			throw new AccessDeniedException("Access Denied");
		}

	}

	// retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, (t)-> t.get("emailId").toString());
	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
