package com.example.api.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class BasicAuthenticationController {
	@GetMapping(path="/basicauth")
	public AuthenticationBean authenticate() {
		return new AuthenticationBean("You are connected");
	}
} 
