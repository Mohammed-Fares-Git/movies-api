package com.mohammedfares.movies_api.servises;

import com.mohammedfares.movies_api.models.AppUser;
import com.mohammedfares.movies_api.models.AuthRequest;
import com.mohammedfares.movies_api.models.AuthResponse;
import com.mohammedfares.movies_api.models.RegisterRequest;

public interface IUserService {
	
	public AuthResponse register(RegisterRequest user);
	public AuthResponse authenticate(AuthRequest user);

}
