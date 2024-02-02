package com.mohammedfares.movies_api.servises;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



@Service
public class JWTService {
	
	private static final String SECRET_KEY = "NUp36Amdvmldkelzuropue546regregtlkerlNzE2UY0Uu8CZL1577jNodkss9";
	
	public String extractUserName(String jwt) {
		return extractClaim(jwt, Claims::getSubject);
	}
	
	public String generateJWTToken(
			UserDetails userDetails
			) {
		
		return generateJWTToken(new HashMap<String,Object>(),userDetails);
		
	}
	
	public String generateJWTToken(
			Map<String,Object> extraClaims,
			UserDetails userDetails
			) {
		
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
				//.signWith(getSignInKey(),SignatureAlgorithm.RS256)
				.signWith(getSignInKey(),SignatureAlgorithm.HS256)
				.compact();
		
	}
	
	public Claims extractAllClaims(String jwt) {
		System.out.println("- token final : |" + jwt);
		return Jwts.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(jwt)
				.getBody();
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		System.out.println("- token 2 : " + token);
		final String userName = extractUserName(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	private boolean isTokenExpired(String token) {
		return extractExperation(token).before(new Date());
	}

	private Date extractExperation(String token) {
		return extractClaim(token, Claims::getExpiration);
		//return new Date(System.currentTimeMillis() + 1000 * 60 * 24);
	}

	private Key getSignInKey() {
		//byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public <T> T extractClaim(String jwtToken, Function<Claims,T> claimsresolver) {
		final Claims claims = extractAllClaims(jwtToken);
		return claimsresolver.apply(claims);
	}

}
