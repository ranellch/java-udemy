package com.company;

public class Main {

    public static void main(String[] args) {

        byte x = 10;
        short y = 1000;
        int z = 10000;

        long w = 50000L + 10L*(x + y + z);
        System.out.println(w);
    }
}
