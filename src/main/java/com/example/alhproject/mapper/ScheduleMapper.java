package com.example.alhproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.alhproject.entity.Schedule;
import com.example.alhproject.entity.User;

@Mapper
public interface ScheduleMapper {
	User getUser(@Param("loginId") String loginId, @Param("password") String password);
	void regist(Schedule schedule);
	List<Schedule> selectAll();
}
