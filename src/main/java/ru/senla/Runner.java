package ru.senla;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Runner {

    public static void main(String[] args) {

        LocalDateTime time1 = LocalDateTime.now().plusDays(1L);
        LocalDateTime time = LocalDateTime.now();

//        Long l = LocalDateTime.now().getLong(time.);


        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenSecondsLater = now.plusSeconds(10);

        long diff = ChronoUnit.SECONDS.between(now, time1);
        System.out.println("diff = " + diff);
//        assertEquals(10, diff);

        boolean a = false;
        boolean b = false;
        System.out.println("a == b = " + (a == b));

      /*  Duration duration = Duration.between(LocalDateTime.parse("2018-01-18T06:30")
                , LocalDateTime.parse("2018-02-14T22:58"));
        System.out.println("duration = " + duration);

        System.out.println("LocalDateTime.now() = " + time);
        System.out.println("LocalDateTime.now().plusHours(24L) = " + time1);*/

    }
}
