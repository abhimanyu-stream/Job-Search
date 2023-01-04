package com.analytiq.jobportalunnati.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "payment-service", description = "The payment Service")
@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	
	@Operation(summary = "Get", description = "Any  user can access /payment/ for welcome message in this application") 
	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome to payment Service";
	}

}
