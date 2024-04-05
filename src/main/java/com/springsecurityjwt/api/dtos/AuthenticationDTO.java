package com.springsecurityjwt.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationDTO {

	@NotBlank
	String login;

	@NotBlank
	String password;
	
}
