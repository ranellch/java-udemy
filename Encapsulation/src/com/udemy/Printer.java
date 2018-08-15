package com.udemy;

public class Printer {

    private int tonerLevel = 0;
    private int pagesPrinted = 0;
    private boolean duplex;

    public Printer(boolean duplex) {
        this.duplex = duplex;
    }

    public void fillToner(int amount) {
        tonerLevel += amount;
        if (tonerLevel > 100) {
            tonerLevel = 100;
        }
        System.out.println("Toner level now at " + tonerLevel + "%");
    }

    public void printPage() {
        if (tonerLevel > 0) {
            System.out.println("Printing page...");
            tonerLevel -= 1;
            pagesPrinted += 1;
            System.out.println("Total pages printed: " + pagesPrinted);
        } else {
            System.out.println("Refill toner");
        }
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }
}
