package ru.senla.fabric;

import ru.senla.entity.Bank;

import java.io.FileWriter;
import java.io.IOException;

public class WriterFile {

    public void writerFile() {

        ReaderFile readerFile = new ReaderFile();

        try (FileWriter writer = new FileWriter("fileData.txt")) {

            for (Bank bank : readerFile.getBankHashMap().values()) {
                writer.write(bank.getNumCard());
                writer.append(' ');
                writer.write(bank.getPinCard().toString());
                writer.append(' ');
                writer.write(bank.getBalance().toString());
                writer.append(' ');
                writer.write(bank.getTransactionTime().toString());
                writer.append(' ');
                writer.write(bank.getBlocking().toString());
                writer.append('\n');
                writer.flush();
            }
            System.out.println("Transaction Ok!");
        } catch (IOException ex) {
            System.out.println("Failed to write to file!!!");
        }
    }
}
