package com.example.alhproject.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alhproject.form.ScheduleManagementForm;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/event")
public class FullCalendarController {
	 /**
     * カレンダーに表示するScheduleManagementForm情報を取得
     * @return ScheduleManagementForm情報をjsonエンコードした文字列
     */
    @GetMapping(value = "/all")
    public String getScheduleManagementForms() {
        String jsonMsg = null;
        try {
            List<ScheduleManagementForm> events = new ArrayList<ScheduleManagementForm>();
            ScheduleManagementForm event = new ScheduleManagementForm();
            event.setTitle("たいとる");
            event.setStart("2020-09-16");
            events.add(event);

            event = new ScheduleManagementForm();
            event.setTitle("おはよう");
            event.setStart("2020-09-18");
            events.add(event);

            // FullCalendarにエンコード済み文字列を渡す
            ObjectMapper mapper = new ObjectMapper();
            jsonMsg =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(events);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        return jsonMsg;
    }
}
