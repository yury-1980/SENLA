package ru.senla.service;

import ru.senla.entity.Bank;
import ru.senla.fabric.WriterFile;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

import static ru.senla.validation.StringValidation.regCard;

public class MenuService {

    private WriterFile writerFile = new WriterFile();

    public Double getBalanceCard(String numCard, ConcurrentHashMap<String, Bank> bankHashMap) {
        return bankHashMap.get(numCard).getBalance();
    }

    public boolean scanPin(String pinCard, String numCard, ConcurrentHashMap<String, Bank> bankHashMap) {
        Integer pin = Integer.parseInt(pinCard);
        return bankHashMap.get(numCard).getPinCard().equals(pin);
    }

    public Double withdrawBalance(String numCard, String amount, ConcurrentHashMap<String, Bank> bankHashMap) {

        if (bankHashMap.get(numCard).getBalance() >= Double.parseDouble(amount)) {
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
        return numCard.matches(regCard) && bankHashMap.containsKey(numCard)
                && !(bankHashMap.get(numCard).getBlocking());
    }

    public void pinControl(int numPin, String numCard, ConcurrentHashMap<String, Bank> bankHashMap) {

        if (numPin == 3) {
            bankHashMap.get(numCard).setBlocking(true);
            bankHashMap.get(numCard).setTransactionTime(LocalDateTime.now());
            System.out.println("Your card is blocked for 1 day!!!\n");
            writerFile.writerFile();
            System.exit(0);
        }
    }
}