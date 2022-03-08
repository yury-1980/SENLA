package view;

import controller.Controller;
import model.Number;
import java.util.ArrayList;

public class View {
    public static void prints() {
        ArrayList<Number> arrayList = Controller.arrayList;
        // Вывод символов построчно
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case (0):
                    for (Number n : arrayList) {
                        n.str1();
                    }
                    break;
                case (1):
                    for (Number n : arrayList) {
                        n.str2();
                    }
                    break;
                case (2):
                    for (Number n : arrayList) {
                        n.str3();
                    }
                    break;
                case (3):
                    for (Number n : arrayList) {
                        n.str4();
                    }
                    break;
                case (4):
                    for (Number n : arrayList) {
                        n.str5();
                    }
            }
            System.out.println();
        }
    }
}
