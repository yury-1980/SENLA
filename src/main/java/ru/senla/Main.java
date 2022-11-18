package ru.senla;

import ru.senla.fabric.ReaderFile;
import ru.senla.view.Menu;

public class Main {

    public static void main(String[] args) {

        ReaderFile readerFile = new ReaderFile();
        readerFile.readFile();

        Menu menu = new Menu();
        menu.menuOne();
    }
}