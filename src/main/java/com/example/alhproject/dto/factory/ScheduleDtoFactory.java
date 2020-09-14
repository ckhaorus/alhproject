package com.example.alhproject.dto.factory;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.example.alhproject.dto.ScheduleDto;
import com.example.alhproject.form.ScheduleForm;
@Component
public class ScheduleDtoFactory {
	/** create dto from form */
	public ScheduleDto create(ScheduleForm form, Integer userId) {
		return new ScheduleDto(
				form.getTitle(),
				form.getContext(),
				userId,
				new Date(System.currentTimeMillis()),
				form.getScheduleStartTime(),
				form.getScheduleEndTime()
		);
	}
}