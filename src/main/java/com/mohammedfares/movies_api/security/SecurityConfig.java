package com.mohammedfares.movies_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mohammedfares.movies_api.servises.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final JWTAuthentificationFilter jwtAuthentificationFilter;
	private final AuthenticationProvider authenticationProvider;
	private final UserRepository userRepository;
	
	public SecurityConfig(@Lazy JWTAuthentificationFilter jwtAuthentificationFilter,@Lazy AuthenticationProvider authenticationProvider, UserRepository userRepository) {
		this.jwtAuthentificationFilter = jwtAuthentificationFilter;
		this.authenticationProvider = authenticationProvider;
		this.userRepository = userRepository;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests()
		.requestMatchers("/")
		.permitAll()
		.requestMatchers("/auth/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthentificationFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	@Bean public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return (userName) -> {
			return userRepository
					.findByUserName(userName)
					.orElseThrow(
							() -> new UsernameNotFoundException("user name not found")
					);
		};
	}

}
