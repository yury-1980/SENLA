package ru.senla.fabric;

import ru.senla.entity.Bank;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class WriterFile {

    public void writerFile() {

        /*Bank bank = Bank.builder()
                .cardNumber("1111-2222-3333-4444")
                .cardPin(1111)
                .balance(BigDecimal.valueOf(500.00))
                .transactionTime(LocalDateTime.now())
                .blocking(false)
                .build();*/

//        Bank bank = new Bank();
        ReaderFile readerFile = new ReaderFile();

        try (FileWriter writer = new FileWriter("fileData.txt")) {

            for (Bank bank : readerFile.getBankHashMap().values()) {
                writer.write(bank.getCardNumber());
                writer.append(' ');
                writer.write(bank.getCardPin().toString());
                writer.append(' ');
                writer.write(bank.getBalance().toString());
                writer.append(' ');
                writer.write(bank.getTransactionTime().toString());
                writer.append(' ');
                writer.write(bank.getBlocking().toString());
                writer.append('\n');
                writer.flush();
            }
            System.out.println("Ok!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
