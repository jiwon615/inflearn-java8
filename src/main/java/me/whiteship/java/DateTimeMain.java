package me.whiteship.java;

import java.time.*;

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

        // 기간을 표현하는 방법

    }
}
