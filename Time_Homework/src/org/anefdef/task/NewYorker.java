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

    public String showTimeIntersectionsWith(String workBegin1, String workEnd1, String zoneID1,String workBegin2, String workEnd2, String zoneID2) {

        LocalTime beginTime1 = LocalTime.parse(workBegin1, DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime endTime1 = LocalTime.parse(workEnd1,DateTimeFormatter.ISO_LOCAL_TIME);

        ZonedDateTime givenBegin = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(),beginTime1),ZoneId.of(zoneID1));
        ZonedDateTime givenEnd = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(),endTime1), ZoneId.of(zoneID1));

        LocalTime beginTime2 = LocalTime.parse(workBegin2, DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime endTime2 = LocalTime.parse(workEnd2,DateTimeFormatter.ISO_LOCAL_TIME);

        ZonedDateTime nyBegin = ZonedDateTime.of((LocalDateTime.of(LocalDate.now(),beginTime2)), ZoneId.of(zoneID2));
        ZonedDateTime nyEnd = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(),endTime2), ZoneId.of(zoneID2));

        Duration begin = Duration.between(givenBegin,nyBegin);
        Duration end = Duration.between(givenEnd,nyEnd);

        LocalTime resultBegin = givenBegin.toLocalTime().plus(begin);
        LocalTime resultEnd = givenEnd.toLocalTime().plus(end);

        return "You can connect "+ zoneID2 + " office\nfrom " + zoneID1 + " office\nduring following hours:\n" +
                resultBegin.toString() + " to " + resultEnd.toString();
    }
}
