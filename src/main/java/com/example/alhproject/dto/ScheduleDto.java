package com.example.alhproject.dto;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDto {
	private String title;
	private String context;
	private Integer userId;
	private Date createdDate;
	private String scheduleStartTime;
	private String scheduleEndTime;

	public ScheduleDto(String title, String context, Integer userId, Date createdDate,
			String scheduleStartTime, String scheduleEndTime) {
		super();
		this.title = title;
		this.context = context;
		this.userId = userId;
		this.createdDate = createdDate;
		this.scheduleStartTime = scheduleStartTime;
		this.scheduleEndTime = scheduleEndTime;
	}
}