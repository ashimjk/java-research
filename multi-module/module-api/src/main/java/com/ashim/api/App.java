package com.ashim.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashim.service.MessageService;
import com.ashim.service.ServiceConfiguration;

@RestController
@Import(ServiceConfiguration.class)
@SpringBootApplication
public class App {

	@Autowired
	private MessageService service;

	@GetMapping("/")
	public String getMessage() {
		return this.service.getMessage();
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
