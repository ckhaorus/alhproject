package com.example.alhproject.form;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleForm {
	private Integer id;
	private String title;
	private String context;
	private String userId;
	private Date scheduleStartTime;
	private Date scheduleEndTime;
	private String memo;
	private LocalDate nowLocalDate;
}