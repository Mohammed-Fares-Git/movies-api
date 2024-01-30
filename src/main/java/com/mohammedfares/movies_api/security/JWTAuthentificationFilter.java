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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;



@Component
public class JWTAuthentificationFilter extends OncePerRequestFilter {
	public static final String ATHENTIFICATION_HEADER = "Authorization";
	private final UserServiceImpl userServiceImpl;
	private final JWTService jwtService;
	
	private final UserDetailsService userDetailsService;
	
	public JWTAuthentificationFilter(UserServiceImpl userServiceImpl, JWTService jwtService, UserDetailsService userDetailsService) {
		this.userServiceImpl = userServiceImpl;
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String header = request.getHeader(ATHENTIFICATION_HEADER);
		final String jwt;
		final String userName;
		
		
		if (header == null || header.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		jwt = header.substring(7);
		userName =this.jwtService.extractUserName(jwt);
		
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
			if (jwtService.isTokenValid(userName, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		
		}
		filterChain.doFilter(request, response);
		
		
		
		
	}

}
