package com.vshuok.es.personal.calendar.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.personal.calendar.entity.Calendar;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface CalendarRepository extends BaseRepository<Calendar, Long> {

    @Query("select count(id) from Calendar where userId=?1 and ((startDate=?2 and (startTime is null or startTime<?3)) or (startDate > ?2 and startDate<=(?2+?4)) or (startDate<?2 and (startDate+length)>?2) or ((startDate+length)=?2 and (endTime is null or endTime>?3)))")
    Long countRecentlyCalendar(Long userId, Date nowDate, Date nowTime, Integer interval);
}
