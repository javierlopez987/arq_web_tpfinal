package edu.isistan.tudai.controllers;

public class User {
	private String username;
	private String token;
	
	public void setUser(String username) {
		this.username = username;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", token=" + token + "]";
	}

	
}
