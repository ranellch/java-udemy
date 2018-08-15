package com.udemy;

public class Sheets {
    private boolean clean;
    private int threadCount;

    public Sheets(boolean clean, int threadCount) {
        this.clean = clean;
        this.threadCount = threadCount;
    }

    public void washSheets() {
        System.out.println("Washing sheets");
        clean = true;
    }
}
