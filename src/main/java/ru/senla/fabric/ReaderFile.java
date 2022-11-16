package ru.senla.fabric;

import lombok.Getter;
import ru.senla.entity.Bank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class ReaderFile {

    private static HashMap<String, Bank> bankHashMap = new HashMap<>();

    public void readFile() {

        String cardNumber = null;
        Integer cardPin = null;
        BigDecimal balance = null;
        LocalDateTime transactionTime = null;
        Boolean blocking = false;

        try (Scanner scanner = new Scanner(new FileReader("src/main/resources/fileData.txt"))) {
            scanner.useLocale(Locale.ENGLISH);

            while (scanner.hasNext()) {
                cardNumber = scanner.next();
                cardPin = scanner.nextInt();
                balance = scanner.nextBigDecimal();
                transactionTime = LocalDateTime.parse(scanner.next());
                blocking = scanner.nextBoolean();

                Bank bank = new Bank(cardNumber, cardPin, balance, transactionTime, blocking);
                bankHashMap.put(cardNumber, bank);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!!!");
        }
    }

    public HashMap<String, Bank> getBankHashMap() {
        return bankHashMap;
    }
}
