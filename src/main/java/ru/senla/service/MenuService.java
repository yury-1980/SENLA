package ru.senla.service;

import ru.senla.entity.Bank;
import ru.senla.fabric.WriterFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ConcurrentHashMap;

import static ru.senla.validation.StringValidationConst.*;

public class MenuService {

    private final WriterFile writerFile = new WriterFile();

    public Double getBalanceCard(String numCard, ConcurrentHashMap<String, Bank> bankHashMap) {
        return bankHashMap.get(numCard).getBalance();
    }


    public boolean scanPin(String pinCard, String numCard, ConcurrentHashMap<String, Bank> bankHashMap) {
        return bankHashMap.get(numCard).getPinCard().equals(pinCard);
    }


    public void pinControl(int numPin, String numCard, ConcurrentHashMap<String, Bank> bankHashMap) {

        if (numPin == 3) {
            bankHashMap.get(numCard).setBlocking(true);
            bankHashMap.get(numCard).setTransactionTime(LocalDateTime.now().plusDays(BLOCKING_DAYS));
            System.out.println("Your card is blocked for " + BLOCKING_DAYS + " day!!!\n");
            writerFile.writerFile();
            System.exit(0);
        }
    }


    public Double withdrawBalance(String numCard, String amount, ConcurrentHashMap<String, Bank> bankHashMap) {

        if (bankHashMap.get(numCard).getBalance() >= Double.parseDouble(amount)
                && LIMIT >= Double.parseDouble(amount)) {
            Double aDouble = bankHashMap.get(numCard).getBalance() - Double.parseDouble(amount);
            bankHashMap.get(numCard).setBalance(aDouble);
        } else {
            System.out.println("Invalid amount!!!");
        }
        return bankHashMap.get(numCard).getBalance();
    }


    public Double topUpAccount(String numCard, String amount, ConcurrentHashMap<String, Bank> bankHashMap) {

        Double aDouble = bankHashMap.get(numCard).getBalance() + Double.parseDouble(amount);
        bankHashMap.get(numCard).setBalance(aDouble);
        return bankHashMap.get(numCard).getBalance();
    }


    public boolean cardVerification(String numCard, ConcurrentHashMap<String, Bank> bankHashMap) {

        LocalDateTime timeCard;
        LocalDateTime now;
        long diff;

        if (numCard.matches(REG_CARD) && bankHashMap.containsKey(numCard)) {
            timeCard = bankHashMap.get(numCard).getTransactionTime();
            now = LocalDateTime.now();
            diff = ChronoUnit.SECONDS.between(now, timeCard);

            if (!(bankHashMap.get(numCard).getBlocking())) {
                return true;
            } else if (bankHashMap.get(numCard).getBlocking() && diff <= 0) {
                bankHashMap.get(numCard).setBlocking(false);
                return true;
            } else {
                System.out.println("Your card is blocked until - " + bankHashMap.get(numCard).getTransactionTime()
                        .format(DateTimeFormatter.ofPattern("d:MM:uuuu HH:mm:ss")));
                return false;
            }
        } else {
            return false;
        }
    }
}