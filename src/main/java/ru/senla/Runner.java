package ru.senla;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Runner {

    public static void main(String[] args) {

        LocalDateTime time1 = LocalDateTime.now().plusHours(24L);
        LocalDateTime time = LocalDateTime.now().;

        Duration duration = Duration.between(LocalDateTime.parse("2018-01-18T06:30")
                , LocalDateTime.parse("2018-02-14T22:58"));
        System.out.println("duration = " + duration);

        System.out.println("LocalDateTime.now() = " + time);
        System.out.println("LocalDateTime.now().plusHours(24L) = " + time1);

    }
}
