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
import com.mohammedfares.movies_api.models.Role;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Service
public class UserServiceImpl implements IUserService {
	
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
	public AuthResponse authenticate(AuthRequest authRequest) {
		this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authRequest.getUserName(),
						authRequest.getPassword()
						)
				);
		AppUser user = userRepository.findByUserName(authRequest.getUserName()).orElseThrow();
		var authResponse = new AuthResponse();
		authResponse.setFirstName(user.getFirstName());
		authResponse.setLastName(user.getLastName());
		authResponse.setUserName(user.getUsername());
		authResponse.setImage(user.getImage());
		authResponse.setJwtToken(
				this.jwtService.generateJWTToken(user)
				);
		return authResponse;
	}



	@Override
	public AuthResponse register(RegisterRequest registerRequest) {
		var user = new AppUser();
		user.setFirstName(registerRequest.getFirstName());
		user.setLastName(registerRequest.getLastName());
		user.setUserName(registerRequest.getUserName());
		user.setImage(registerRequest.getImage());
		user.setRole(Role.USER);
		user.setPassword(this.passwordEncoder.encode(registerRequest.getPassword()));
		var res = userRepository.save(user);
		var token = this.jwtService.generateJWTToken(user);
		var authResponse = new AuthResponse();
		authResponse.setJwtToken(token);
		authResponse.setFirstName(res.getFirstName());
		authResponse.setLastName(res.getLastName());
		authResponse.setUserName(res.getUsername());
		authResponse.setImage(res.getImage());
		return authResponse;
	}



	
	
}
