package com.mohammedfares.movies_api.controllers;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohammedfares.movies_api.models.AuthRequest;
import com.mohammedfares.movies_api.models.AuthResponse;
import com.mohammedfares.movies_api.models.RegisterRequest;
import com.mohammedfares.movies_api.servises.MovieServiceImpl;
import com.mohammedfares.movies_api.servises.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final UserServiceImpl userServiceImpl;
	public AuthController(@Lazy UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@PostMapping("/register") 
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
		return ResponseEntity.ok(this.userServiceImpl.register(registerRequest));
	}
	
	@PostMapping("/authenticate") 
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest){
		return ResponseEntity.ok(this.userServiceImpl.authenticate(authRequest));
	}
}
