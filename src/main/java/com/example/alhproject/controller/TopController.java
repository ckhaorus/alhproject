package com.example.alhproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.alhproject.form.LoginForm;

@Controller
public class TopController {
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String login(@ModelAttribute LoginForm loginForm, Model model, BindingResult result) {
		model.addAttribute("loginForm", loginForm);
		return "/top";
	}

}