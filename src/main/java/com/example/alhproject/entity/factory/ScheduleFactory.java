package com.example.alhproject.entity.factory;

import org.springframework.stereotype.Component;

import com.example.alhproject.dto.ScheduleDto;
import com.example.alhproject.entity.Schedule;
@Component
public class ScheduleFactory {
	/** create entity from dto */
	public Schedule create(ScheduleDto dto){
		return new Schedule(
				dto.getTitle(),
				dto.getContext(),
				dto.getUserId(),
				dto.getCreatedDate(),
				dto.getScheduleStartTime(),
				dto.getScheduleEndTime()
		);
	}
}