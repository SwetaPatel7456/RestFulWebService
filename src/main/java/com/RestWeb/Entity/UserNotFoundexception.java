package com.RestWeb.Entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundexception extends RuntimeException {

	public UserNotFoundexception(String message) {
		super(message);
		
	}

	
}
