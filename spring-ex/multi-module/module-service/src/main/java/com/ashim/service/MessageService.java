package com.ashim.service;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

	private final String message;

	public MessageService(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
