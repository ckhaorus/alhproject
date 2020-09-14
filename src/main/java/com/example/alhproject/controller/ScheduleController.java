package com.example.alhproject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.alhproject.dto.UserDto;
import com.example.alhproject.dto.factory.ScheduleDtoFactory;
import com.example.alhproject.form.ScheduleForm;
import com.example.alhproject.service.ScheduleService;

@Controller
public class ScheduleController {
	@Autowired
	private HttpSession session;
	@Autowired
	private ScheduleDtoFactory scheduleDtoFactory;
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(value = "/top/schedule", method = RequestMethod.GET)
	public String schedule(@ModelAttribute ScheduleForm scheduleForm, Model model, BindingResult result) {
		scheduleService.setLocalDate(scheduleForm);
		model.addAttribute("scheduleForm", scheduleForm);
		return "/schedule";
	}

	@RequestMapping(value = "top/schedule", method = RequestMethod.POST)
	public String registSchedule(@ModelAttribute @Valid ScheduleForm scheduleForm, Model model, BindingResult result) {
		scheduleService.regist(scheduleDtoFactory.create(scheduleForm, ((UserDto)session.getAttribute("loginUser")).getId()));
		return "redirect:../top";
	}
}