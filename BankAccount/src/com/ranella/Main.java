package com.ranella;

public class Main {

    public static void main(String[] args) {
        final MyBankAccount account = new MyBankAccount(1000.00, "12345-678");

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        }).start();

    }
}
