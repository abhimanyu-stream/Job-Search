package com.analytiq.jobportalunnati.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "chat-service", description = "The chat Service")
@RestController
@RequestMapping("/chat")
public class ChatController {
	
	
	@Operation(summary = "Get", description = "Any  user can access /chat/ for welcome message in this application") 
	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome to chat Service";
	}

}
