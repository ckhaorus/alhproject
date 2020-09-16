package com.example.alhproject.form;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleForm {
	private String title;
	private String context;
	private String userId;
	private LocalDate createdDate;
	private String scheduleStartTime;
	private String scheduleEndTime;
}