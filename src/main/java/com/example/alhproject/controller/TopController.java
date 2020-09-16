package com.example.alhproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.alhproject.form.LoginForm;

@Controller
public class TopController {
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String login(@ModelAttribute LoginForm loginForm, Model model, BindingResult result) {
		model.addAttribute("loginForm", loginForm);
		return "/top";
	}

}