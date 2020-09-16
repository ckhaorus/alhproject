package com.example.alhproject.form;

import lombok.Getter;
import lombok.Setter;
/**
 * FullCalendar用Event Object
 * @see https://fullcalendar.io/docs/event_data/Event_Object/
 */
@Getter
@Setter
public class ScheduleManagementForm {
	private String title;
    private String start;
    private String end;
}
