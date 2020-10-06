package com.example.alhproject.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriUtils;

import com.example.alhproject.form.LoginForm;
import com.example.alhproject.service.TopService;

@Controller
public class TopController {

	@Autowired
	private TopService topService;

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String login(@ModelAttribute LoginForm loginForm, Model model, BindingResult result) {
		model.addAttribute("loginForm", loginForm);
		return "/top";
	}

	@RequestMapping(value = "/top/csv", method = RequestMethod.GET)
	public String csvDownload(HttpServletResponse response) throws IOException {
		String header = String.format("attachment; filename=\"%s\";", UriUtils.encode("result.csv", StandardCharsets.UTF_8.name()));
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, header);
		topService.csvDownload(response);
		return "/top";
	}

}