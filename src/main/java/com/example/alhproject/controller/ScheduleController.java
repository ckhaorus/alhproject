package com.example.alhproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.alhproject.form.ScheduleForm;
import com.example.alhproject.service.ScheduleService;

@Controller
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;

	@RequestMapping(value = "/top/schedule", method = RequestMethod.GET)
	public String schedule(@ModelAttribute ScheduleForm ScheduleForm, Model model, BindingResult result) {
		scheduleService.setLocalDate(ScheduleForm);
		model.addAttribute("scheduleForm", ScheduleForm);
		return "/schedule";
	}
}