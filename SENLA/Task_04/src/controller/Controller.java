package controller;

import model.Number;
import model.*;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Number> arrayList = new ArrayList<>();

    public static void processes(String str) {

        char[] chars = str.toCharArray();
        int[] nums = new int[chars.length];
        int max = 0;

// Преобразование мас. символов в мас. целых и находим максимальное
        for (int i = 0; i < chars.length; i++) {
            nums[i] = Character.getNumericValue(chars[i]);
            if (max < Character.getNumericValue(chars[i])) {
                max = Character.getNumericValue(chars[i]);
            }
        }

// Заполняем массив объектами
        for (int i = 0; i < chars.length; i++) {

            switch (Character.getNumericValue(chars[i])) {

                case (0):
                    arrayList.add(new Zero());
                    break;
                case (1):
                    arrayList.add(new One());
                    break;
                case (2):
                    arrayList.add(new Two());
                    break;
                case (3):
                    arrayList.add(new Three());
                    break;
                case (4):
                    arrayList.add(new Four());
                    break;
                case (5):
                    arrayList.add(new Five());
                    break;
                case (6):
                    arrayList.add(new Six());
                    break;
                case (7):
                    arrayList.add(new Seven());
                    break;
                case (8):
                    arrayList.add(new Eight());
                    break;
                case (9):
                    arrayList.add(new Nine());
                    break;
            }
// Изменяем символ вывода максимального числа
            if (Character.getNumericValue(chars[i]) == max) {
                arrayList.get(i).setS(String.valueOf(max));
            }
        }
    }
}
