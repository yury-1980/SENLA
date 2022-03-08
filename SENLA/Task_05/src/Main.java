import controller.Controll;
import model.Subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int volume;
        int price;
        int safeVolum = 0;
        List<Subject> subjects = new ArrayList<>();
        System.out.print("Введите объём сейфа: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            safeVolum = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong volume!!!");
            System.exit(0);
        }
        System.out.println("Введите объём и стоимость 5 предметов:");

        for (int i = 0; i < 5; i++) {
            try {
                System.out.print("Введите объём: ");
                volume = Integer.parseInt(reader.readLine());
                System.out.print("Введите стоимость: ");
                price = Integer.parseInt(reader.readLine());
                subjects.add(new Subject(volume, price));
            } catch (IOException | NumberFormatException e) {
                System.out.println("wrong number!!!");
                System.exit(0);
            }

        }

        Controll.handles(subjects, safeVolum);
    }
}
