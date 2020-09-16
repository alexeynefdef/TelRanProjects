package org.anefdef.task;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class NewYorker {
    public String showTimeIntersectionsWithBerlin() {

        ZonedDateTime givenBegin = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(),LocalTime.of(9,0)),ZoneId.of("Europe/Berlin"));
        ZonedDateTime givenEnd = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(),LocalTime.of(18,0)), ZoneId.of("Europe/Berlin"));
        ZonedDateTime nyBegin = ZonedDateTime.of((LocalDateTime.of(LocalDate.now(),LocalTime.of(8,0))), ZoneId.of("US/Eastern"));
        ZonedDateTime nyEnd = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(),LocalTime.of(17,0)), ZoneId.of("US/Eastern"));
        Duration begin = Duration.between(givenBegin,nyBegin);
        Duration end = Duration.between(givenEnd,nyEnd);
        LocalTime resultBegin = givenBegin.toLocalTime().plus(begin);
        LocalTime resultEnd = givenEnd.toLocalTime().plus(end).minus(Duration.ofHours(5));
        return "You can connect NY-Office during following hours: \n" +
                resultBegin.toString() + " to " + resultEnd.toString();
    }

    public String showTimeIntersectionsWith(String workBegin, String workEnd, String zoneID) {

        LocalTime beginTime = LocalTime.parse(workBegin, DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime endTime = LocalTime.parse(workEnd,DateTimeFormatter.ISO_LOCAL_TIME);
        ZonedDateTime givenBegin = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(),beginTime),ZoneId.of(zoneID));
        ZonedDateTime givenEnd = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(),endTime), ZoneId.of("Europe/Berlin"));
        ZonedDateTime nyBegin = ZonedDateTime.of((LocalDateTime.of(LocalDate.now(),LocalTime.of(8,0))), ZoneId.of("US/Eastern"));
        ZonedDateTime nyEnd = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(),LocalTime.of(17,0)), ZoneId.of("US/Eastern"));
        Duration begin = Duration.between(givenBegin,nyBegin);
        Duration end = Duration.between(givenEnd,nyEnd);
        LocalTime resultBegin = givenBegin.toLocalTime().plus(begin);
        LocalTime resultEnd = givenEnd.toLocalTime().plus(end).minus(Duration.ofHours(5));
        return "You can connect NY-Office during following hours: \n" +
                resultBegin.toString() + " to " + resultEnd.toString();
    }
}
