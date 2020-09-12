package com.example.alhproject.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.example.alhproject.form.ScheduleForm;

@Service
public class ScheduleService {

	public LocalDate createNowLocalDate() {
		return LocalDate.now();
	}

	public String formatLocalDate(LocalDate ld) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        return df.format(ld);
	}

	public void setLocalDate(ScheduleForm sf) {
		sf.setNowLocalDate(createNowLocalDate());
	}
}
