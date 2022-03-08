package controller;

import model.Safe;
import model.Subject;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Controll {

    public static void handles(List<Subject> subjects, int safeVolum) {
        // Сортировка предметов по ценности на еденицу объёма
        Collections.sort(subjects, new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2) {
                return o2.getMinCost() - o1.getMinCost();
            }
        });

        for (Subject s : subjects)// Вывод отсортированных предметов
            System.out.println(s.getVolume() + " " + s.getPrice() + " "
                    + s.getMinCost());

        int i = 0;
        Safe safe = new Safe(safeVolum);
        while (safe.getVolume() > 0 && i < subjects.size()) {// Заполнение сейфа

            if (subjects.get(i).getVolume() > safe.getVolume()) {
                i++;
                continue;
            }
            safe.setSafeList(subjects.get(i));// Добавление в сейф
            i++;
        }
        System.out.println("Сейф полон! " + "Оставшийся объём сейфа = "
                + safe.getVolume() + " Ценность сейфа = " + safe.getPrice());

        for (Subject s : safe.getSafeList()) {
            System.out.println("Объём - " + s.getVolume() + " Ценность - "
                    + s.getPrice());
        }
    }
}
