package ru.senla.view;

import ru.senla.entity.Bank;
import ru.senla.fabric.ReaderFile;
import ru.senla.fabric.WriterFile;
import ru.senla.service.MenuService;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import static ru.senla.validation.StringValidationConst.*;

public class Menu {

    public void menuOne() {

        ConcurrentHashMap<String, Bank> bankHashMap = ReaderFile.getBankHashMap();
        MenuService menuService = new MenuService();
        WriterFile writerFile = new WriterFile();
        String numCard;
        String pinCard;
        String numMenu;
        int numPin = 0;
        int exit = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Enter card number: ");
            numCard = scanner.next();

            if (menuService.cardVerification(numCard, bankHashMap)) {
                System.out.println("Number card Ok!\n");
                break;
            } else {
                System.out.println("Card number does not exist or is incorrect!!!");
                System.out.println(numCard + "\n");
            }
        }

        while (true) {
            System.out.print("Enter pin, 4 digits.: ");
            pinCard = scanner.next();

            if (pinCard.matches(REG_PIN) && menuService.scanPin(pinCard, numCard, bankHashMap)) {
                System.out.println("Pin code Ok!\n");
                break;
            } else {
                System.out.println("Wrong pin!!!: " + pinCard + '\n');
                numPin++;
                menuService.pinControl(numPin, numCard, bankHashMap);
            }
        }

        while (!(exit == 1)) {
            System.out.println("1 - Check card balance");
            System.out.println("2 - Withdraw money from the account (max. 100,000)");
            System.out.println("3 - Top up the balance (max. 1,000,000)");
            System.out.println("4 - EXIT");
            System.out.print("Enter transaction number: ");

            numMenu = scanner.next();

            if (numMenu.matches(REG_NUM_MENU)) {

                switch (numMenu) {
                    case "1":
                        System.out.println("Card balance: " + menuService.getBalanceCard(numCard, bankHashMap) + '\n');
                        break;
                    case "2":

                        while (true) {
                            System.out.println("Card balance: " + menuService.getBalanceCard(numCard, bankHashMap));
                            System.out.print("Enter amount to withdraw: ");
                            String amount = scanner.next();

                            if (amount.matches(REG_WITHDRAW)) {
                                System.out.println("Balance: " + menuService.withdrawBalance(numCard, amount,
                                        bankHashMap) + '\n');
                                writerFile.writerFile();
                                break;
                            } else {
                                System.out.println("Invalid amount!!!\n");
                            }
                        }
                        break;
                    case "3":

                        while (true) {
                            System.out.println("Card balance: " + menuService.getBalanceCard(numCard, bankHashMap));
                            System.out.print("Enter amount: ");
                            String amount = scanner.next();

                            if (amount.matches(REG_MAX_AMOUNT)) {
                                System.out.println("Balance: " + menuService.topUpAccount(numCard, amount,
                                        bankHashMap) + '\n');
                                writerFile.writerFile();
                                break;
                            } else {
                                System.out.println("Invalid amount!!!\n");
                            }
                        }
                        break;
                    case "4":
                        exit = 1;
                        break;
                    default:
                        break;
                }
            } else System.out.println("Wrong choice!!! : " + numMenu + '\n');
        }
        scanner.close();
        System.out.println("Good by!");
    }
}
