package me.whiteship.java;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeMain {

    public static void main(String[] args) {
        // 기계용 API : Instant
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);  // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);  // Asia/Seoul
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println("zonedDateTime = " + zonedDateTime);

        // 인류용
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime birthDay = LocalDateTime.of(1994, Month.JUNE, 15, 0, 0, 0); // 특정 시간대 해당하는 날짜 만들기
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul")); // 특정 존의 날짜 시간
        System.out.println(nowInKorea);

        // 기간을 표현하는 방법 (email 변경)
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2021, Month.OCTOBER, 27);
        Period period = Period.between(today, thisYearBirthday);
        System.out.println("today부터 thisYearBirthday까지 남은 기간 (getDays() : 일수) =>" + period.getDays());

        Period until = today.until(thisYearBirthday);
        System.out.println(until.getDays() + " " + until.get(ChronoUnit.DAYS));

        // 원하는 포맷으로 날짜시간 표현
        LocalDateTime now2 = LocalDateTime.now();
        DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(now.format(yyyyMMdd)); // 2021/08/09

        LocalDate parse = LocalDate.parse("1994/06/15", yyyyMMdd);
        System.out.println(parse);  // 1994-06-15
    }
}
