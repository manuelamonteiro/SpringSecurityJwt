package com.springsecurityjwt.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurityjwt.api.dtos.AuthenticationDTO;
import com.springsecurityjwt.api.dtos.LoginResponseDTO;
import com.springsecurityjwt.api.dtos.RegisterDTO;
import com.springsecurityjwt.api.models.UserModel;
import com.springsecurityjwt.api.services.AuthenticationService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	private final AuthenticationService authenticationService;

	AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody @Valid AuthenticationDTO body) {
		String token = authenticationService.loginService(body);
		return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(token));
	}

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody @Valid RegisterDTO body) {
		UserModel user = authenticationService.registerService(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

}
