package com.example.api.basic.auth;

public class AuthenticationBean {
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AuthenticationBean(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	@Override
	public String toString() {
		return "AuthenticationBean [message=" + message + "]";
	}
}
