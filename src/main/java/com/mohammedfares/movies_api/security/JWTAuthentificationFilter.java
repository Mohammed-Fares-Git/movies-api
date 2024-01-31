package com.mohammedfares.movies_api.security;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mohammedfares.movies_api.servises.JWTService;
import com.mohammedfares.movies_api.servises.UserServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;



@Component
public class JWTAuthentificationFilter extends OncePerRequestFilter {
	public static final String ATHENTIFICATION_HEADER = "Authorization";
	private final JWTService jwtService;
	private final UserDetailsService userDetailsService;
	
	public JWTAuthentificationFilter(JWTService jwtService,@Lazy UserDetailsService userDetailsService) {
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String header = request.getHeader(ATHENTIFICATION_HEADER);
		final String jwt;
		final String userName;
		System.out.println("- token : " + header);
		System.out.println("- Validation ...");
		
		
		if (header == null || !header.startsWith("Bearer ")) {
			System.out.println("- null Header ....");
			filterChain.doFilter(request, response);
			return;
		}
		
		jwt = header.substring(7);
		userName =this.jwtService.extractUserName(jwt);
		//userName = "faresAA";
		System.out.println("- userName ... " + userName);
		
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			System.out.println("- userName exists ... ");
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
			if (jwtService.isTokenValid(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		
		}
		filterChain.doFilter(request, response);
		
		
		
		
	}

}
