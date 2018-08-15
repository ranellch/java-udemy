package com.udemy;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(false);
        printer.printPage();
        printer.fillToner(100);
        printer.printPage();
    }
}
