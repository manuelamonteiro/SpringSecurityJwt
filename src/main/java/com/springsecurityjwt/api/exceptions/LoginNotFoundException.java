package com.springsecurityjwt.api.exceptions;

public class LoginNotFoundException extends RuntimeException {
	public LoginNotFoundException(String message) {
		super(message);
	}
}