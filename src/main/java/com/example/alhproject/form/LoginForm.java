package com.example.alhproject.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
	@Pattern(regexp = "[a-zA-Z0-9]*")
	@Size(min = 6, max = 20)
	private String loginId;
	@Size(min = 6, max = 20)
	private String password;
}