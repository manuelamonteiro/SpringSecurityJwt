package com.springsecurityjwt.api.dtos;

import com.springsecurityjwt.api.enums.UserRoleEnum;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDTO {

	@NotBlank
	String login;

	@NotBlank
	String password;

	UserRoleEnum role;
}
