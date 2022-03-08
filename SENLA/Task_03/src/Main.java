import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        String str = null;
        int num = 0;

        System.out.println("enter the string: ");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] strings;
        strings = str.split(" ");
        String pattern = "[ауоыиэяюёеАУОЫИЭЮЯЕЁ]";
        // Подсчёт гласных в букв
        // Переделка букв на большие
        for (int i = 0; i < strings.length; i++) {
            int num3 = 0;
            for (int j = 0; j < strings[i].length(); j++) {
                if (String.valueOf(strings[i].charAt(j)).matches(pattern)) {
                    num++;
                }
                if (String.valueOf(strings[i].charAt(j)).matches(pattern)
                        && num3 == 0) {
                    char f = (char) ((strings[i].charAt(j)) - 32);

                    num3++;
                }
            }
        }
        System.out.println("number of vowels: " + num);
        // Сортировка слов по кол-ву гласных
        System.out.println();
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1 = 0;
                int num2 = 0;

                for (int i = 0; i < o1.length(); i++) {
                    if (String.valueOf(o1.charAt(i)).matches(pattern)) {
                        num1++;
                    }
                }

                for (int i = 0; i < o2.length(); i++) {
                    if (String.valueOf(o2.charAt(i)).matches(pattern)) {
                        num2++;
                    }
                }
                return num2 - num1;
            }
        });

        for (String s : strings) {
            System.out.println(s);
        }

        for (int i = 0; i < strings.length; i++) {
            int num3 = 0;
            for (int j = 0; j < strings[i].length(); j++) {
                if (String.valueOf(strings[i].charAt(j)).matches(pattern)
                        && num3 == 0) {
                    char[] chars = strings[i].toCharArray();
                    chars[j] = (char) (chars[j] - 32);
                    String strings1 = String.valueOf(chars);
                    strings[i] = strings1;
                    num3++;
                }
            }
            System.out.println(strings[i]);
        }
    }
}
