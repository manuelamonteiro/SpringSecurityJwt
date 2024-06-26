package com.springsecurityjwt.api.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurityjwt.api.dtos.AuthenticationDTO;
import com.springsecurityjwt.api.dtos.RegisterDTO;
import com.springsecurityjwt.api.exceptions.LoginNotFoundException;
import com.springsecurityjwt.api.infra.security.TokenService;
import com.springsecurityjwt.api.models.UserModel;
import com.springsecurityjwt.api.repositories.UserRepository;

@Service
public class AuthenticationService {

	private final AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private TokenService tokenService;

	AuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository,
			TokenService tokenService) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	public String loginService(AuthenticationDTO body) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(body.getLogin(), body.getPassword());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		return tokenService.generateToken((UserModel) auth.getPrincipal());
	}

	public UserModel registerService(RegisterDTO dto) {
		UserDetails user = userRepository.findByLogin(dto.getLogin());

		if (user != null) {
			throw new LoginNotFoundException("Login not found!");
		}

		String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
		UserModel newUser = new UserModel(dto.getLogin(), encryptedPassword, dto.getRole());

		return this.userRepository.save(newUser);
	}

}
