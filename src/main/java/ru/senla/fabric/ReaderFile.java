package ru.senla.fabric;

import ru.senla.entity.Bank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import static ru.senla.validation.StringValidationConst.*;

public class ReaderFile {

    private static ConcurrentHashMap<String, Bank> bankHashMap = new ConcurrentHashMap<>();

    public void readFile() {

        String numCard;
        String pinCard;
        Double balance = 0.0;
        LocalDateTime transactionTime = null;
        boolean blocking = false;

        try (Scanner scanner = new Scanner(new FileReader("fileData.txt"))) {
            scanner.useLocale(Locale.ENGLISH);

            while (scanner.hasNext()) {
                numCard = scanner.next();

                if (!numCard.matches(REG_CARD)) {
                    numCard = "0000-0000-0000-0000";
                }

                pinCard = scanner.next();

                if (!pinCard.matches(REG_PIN)) {
                    pinCard = "0000";
                }
                balance = scanner.nextDouble();
                transactionTime = LocalDateTime.parse(scanner.next());
                blocking = scanner.nextBoolean();

                Bank bank = new Bank(numCard, pinCard, balance, transactionTime, blocking);
                bankHashMap.put(numCard, bank);
            }

        } catch (FileNotFoundException | DateTimeParseException | InputMismatchException e) {
//            e.printStackTrace();
            System.out.println("File not found or invalid data!!!");
        }
    }

    public static ConcurrentHashMap<String, Bank> getBankHashMap() {
        return bankHashMap;
    }
}
