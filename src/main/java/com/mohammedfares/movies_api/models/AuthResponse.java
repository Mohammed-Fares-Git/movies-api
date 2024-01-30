package com.mohammedfares.movies_api.models;

public class AuthResponse {
	
	private String jwt_token;

	public String getJwtToken() {
		return jwt_token;
	}

	public void setJwtToken(String jwt_token) {
		this.jwt_token = jwt_token;
	}

}
