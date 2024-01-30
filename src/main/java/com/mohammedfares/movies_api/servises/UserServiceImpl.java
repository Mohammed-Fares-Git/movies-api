package com.mohammedfares.movies_api.servises;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mohammedfares.movies_api.models.AppUser;
import com.mohammedfares.movies_api.models.AuthRequest;
import com.mohammedfares.movies_api.models.AuthResponse;
import com.mohammedfares.movies_api.models.RegisterRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Service
public class UserServiceImpl implements UserDetailsService, IUserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JWTService jwtService;
	private final AuthenticationManager authenticationManager;

	public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JWTService jwtService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository
				.findByUserName(username)
				.orElseThrow(
						() -> new UsernameNotFoundException("user name not found")
				);
	}



	



	@Override
	public AuthResponse authenticate(AuthRequest authRequest) {
		this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authRequest.getUserName(),
						authRequest.getPassword()
						)
				);
		AppUser user = userRepository.findByUserName(authRequest.getUserName()).orElseThrow();
		var res = new AuthResponse();
		res.setJwtToken(
				this.jwtService.generateJWTToken(user)
				);
		return res;
	}



	@Override
	public AuthResponse register(RegisterRequest registerRequest) {
		var user = new AppUser();
		user.setFirstName(registerRequest.getFirstName());
		user.setLastName(registerRequest.getLastName());
		user.setUserName(registerRequest.getUserName());
		user.setPassword(this.passwordEncoder.encode(registerRequest.getPassword()));
		userRepository.save(user);
		var token = this.jwtService.generateJWTToken(user);
		var authResponse = new AuthResponse();
		authResponse.setJwtToken(token);
		return authResponse;
	}



	
	
}
