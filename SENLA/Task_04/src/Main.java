import controller.Controller;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter a positive integer: ");

        String str = null;
        int d = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            str = br.readLine();
            d = Integer.parseInt(str);
            Controller.processes(str);// Вся обработка
            View.prints();// Вывод цыфр
        } catch (IOException | NumberFormatException e) {
            System.out.println("wrong number!!!");
        }
    }
}
