package com.example.alhproject.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alhproject.dto.ScheduleDto;
import com.example.alhproject.entity.factory.ScheduleFactory;
import com.example.alhproject.form.ScheduleForm;
import com.example.alhproject.mapper.ScheduleMapper;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleMapper scheduleMapper;
	@Autowired
	private ScheduleFactory scheduleFactory;

	public LocalDate createNowLocalDate() {
		return LocalDate.now();
	}

	public String formatLocalDate(LocalDate ld) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        return df.format(ld);
	}

	public void setLocalDate(ScheduleForm sf) {
		sf.setCreatedDate(createNowLocalDate());
	}

	public void regist(ScheduleDto dto) {
		scheduleMapper.regist(scheduleFactory.create(dto));
	}
}
