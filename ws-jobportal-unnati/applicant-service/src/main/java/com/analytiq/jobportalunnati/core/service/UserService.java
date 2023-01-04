package com.analytiq.jobportalunnati.core.service;

import org.springframework.http.ResponseEntity;

import com.analytiq.jobportalunnati.core.dto.JwtResponse;
import com.analytiq.jobportalunnati.core.dto.LoginRequest;
import com.analytiq.jobportalunnati.core.dto.MessageResponse;
import com.analytiq.jobportalunnati.core.dto.SignUpRequest;



public interface UserService {
	
	ResponseEntity<MessageResponse> signUp(SignUpRequest signUpDto);
	ResponseEntity<JwtResponse>  login(LoginRequest loginRequest);
	String generateTokenOnRefreshToken(String username);

}
