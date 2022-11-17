package ru.senla.fabric;

import ru.senla.entity.Bank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class ReaderFile {

    private static ConcurrentHashMap<String, Bank> bankHashMap = new ConcurrentHashMap<>();

    public void readFile() {

        String numCard = null;
        Integer pinCard = null;
        Double balance = null;
        LocalDateTime transactionTime = null;
        Boolean blocking = false;

        try (Scanner scanner = new Scanner(new FileReader("src/main/resources/fileData.txt"))) {
            scanner.useLocale(Locale.ENGLISH);

            while (scanner.hasNext()) {
                numCard = scanner.next();
                pinCard = scanner.nextInt();
                balance = scanner.nextDouble();
                transactionTime = LocalDateTime.parse(scanner.next());
                blocking = scanner.nextBoolean();

                Bank bank = new Bank(numCard, pinCard, balance, transactionTime, blocking);
                bankHashMap.put(numCard, bank);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!!!");
        }
    }

    public static ConcurrentHashMap<String, Bank> getBankHashMap() {
        return bankHashMap;
    }
}
