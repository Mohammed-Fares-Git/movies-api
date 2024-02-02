package com.mohammedfares.movies_api.models;


public class AuthResponse {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String image;
	private String jwt_token;
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public String getJwtToken() {
		return jwt_token;
	}

	public void setJwtToken(String jwt_token) {
		this.jwt_token = jwt_token;
	}

}
