package org.anefdef;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.format(DateTimeFormatter.ISO_DATE));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(today.format(formatter));

        LocalDate now = LocalDate.now();
        //DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yy");
        LocalDate dr = LocalDate.of(LocalDate.now().getYear(), Month.JULY,15);
        System.out.println(dr.isBefore(today));

        LocalDate newYearDate = LocalDate.of(today.getYear(),Month.DECEMBER,31);
        LocalDateTime newYear = LocalDateTime.of(newYearDate,LocalTime.MAX);
        LocalDateTime todayWithTime = LocalDateTime.now();
        //Duration toNY = Duration.between(todayWithTime,newYear);
        System.out.println(ChronoUnit.DAYS.between(todayWithTime, newYear));

        ZonedDateTime zonedNow = ZonedDateTime.of(todayWithTime,ZoneId.systemDefault());

        ZonedDateTime zonedDateTimeNowMoscow = zonedNow.withZoneSameInstant(ZoneId.of("Europe/Moscow"));

        System.out.println(zonedDateTimeNowMoscow);


    }
}
