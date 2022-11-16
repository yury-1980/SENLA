package ru.senla;

import ru.senla.entity.Bank;
import ru.senla.fabric.ReaderFile;
import ru.senla.fabric.WriterFile;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        Menu menu = new Menu();
//        menu.menuOne();


        ReaderFile readerFile = new ReaderFile();
        readerFile.readFile();

        for (Map.Entry<String, Bank> entry : readerFile.getBankHashMap().entrySet()) {
            System.out.println("entry = " + entry);
        }

        WriterFile writerFile = new WriterFile();
        writerFile.writerFile();
    }
}

