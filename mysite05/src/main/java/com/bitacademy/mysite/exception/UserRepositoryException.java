package com.bitacademy.mysite.exception;

public class UserRepositoryException extends RuntimeException {
	public UserRepositoryException() {
		super("User Repository Exception");
	}
	
	public UserRepositoryException(String message) {
		super("User Repository Exception");
	}
	
}
