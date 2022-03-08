import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String str = null;
        int num = 0;
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("enter the number: ");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            str = reader.readLine();
            num = Integer.parseInt(str);
        } catch (IOException | NumberFormatException e) {
            System.out.println("wrong number!!!");
            System.exit(0);
        }

        int i = 2;

        while (num != 1) {
            if (num % i == 0) {
                num = num / i;
                list.add(i);
                i = 1;
            }
            i++;
        }

        for (Integer n : list) {
            System.out.print(n + " ");
        }
    }
}
