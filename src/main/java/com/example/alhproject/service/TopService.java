package com.example.alhproject.service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import com.example.alhproject.entity.Schedule;
import com.example.alhproject.mapper.ScheduleMapper;

@Service
public class TopService {
	@Autowired
	private ScheduleMapper scheduleMapper;

	private static final String OUTPUT_SCHEDULE_FORMAT = "%s,%s,%s,%s,%s,%s";
	private static final String SJIS = "SJIS";
	private static final String TITLE = "title";
	private static final String CONTEXT = "context";
	private static final String USER_ID= "user_id";
	private static final String CREATED_DATE = "created_date";
	private static final String SCHEDULE_START_TIME = "schedule_start_time";
	private static final String SCHEDULE_END_TIME = "schedule_end_time";

	public List<Schedule> getAllSchedule() {
		return scheduleMapper.selectAll();
	}

	public void csvDownload(HttpServletResponse response) throws IOException {

		try (OutputStreamWriter osw = new OutputStreamWriter(response.getOutputStream(), Charset.forName(SJIS));
				CsvMapWriter wr = new CsvMapWriter(osw, CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {

			wr.writeHeader(String.format(OUTPUT_SCHEDULE_FORMAT,
					TITLE,
					CONTEXT,
					USER_ID,
					CREATED_DATE,
					SCHEDULE_START_TIME,
					SCHEDULE_END_TIME
			));

			getAllSchedule().forEach(dbsc -> {
				String scheduleResult = String.format(OUTPUT_SCHEDULE_FORMAT,
						dbsc.getTitle(),
						dbsc.getContext(),
						dbsc.getUserId().toString(),
						dbsc.getCreatedDate().toString(),
						dbsc.getScheduleStartTime().toString(),
						dbsc.getScheduleEndTime().toString());
				try {
					wr.writeComment(scheduleResult);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
