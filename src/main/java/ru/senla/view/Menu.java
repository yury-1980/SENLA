package ru.senla.view;

import java.util.Scanner;

import static ru.senla.validation.StringValidation.*;

public class Menu {

    public void menuOne() {

        String s;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter card number: ");
            s = scanner.next();

            if (s.matches(regCard)) {
                break;
            } else {
                System.out.println("Card number does not exist or is incorrect!!!");
                System.out.println(s);
            }
        }

        while (true) {
            System.out.print("Enter pin: ");
            s = scanner.next();

            if (s.matches(regPin)) {
                int n = Integer.parseInt(s);
                break;
            } else {
                System.out.println("Wrong pin!!! : " + s);
            }
        }

        while (true) {
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
            System.out.print("Enter transaction number: ");

            s = scanner.next();

            if (s.matches(regNumMenu)) {

                switch (s) {
                    case ("1"):
                        System.out.println(1);
                        break;
                    case "2":
                        System.out.println(2);
                        break;
                    case "3":
                        System.out.println(3);
                        break;
                    case "4":
                        System.out.println(4);
                        break;
                }
                break;
            }else System.out.println("Wrong choice!!! : " + s);
        }
        scanner.close();
        System.out.println("Ok!");
    }
}
