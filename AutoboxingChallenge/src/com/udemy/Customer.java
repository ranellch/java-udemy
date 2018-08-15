package com.udemy;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTransaction(double amount) {
        return transactions.add(amount);
    }

    public void printTransactions() {
        System.out.println("Transactions: ");
        for(int i=0; i<transactions.size(); i++) {
            double value = transactions.get(i);
            System.out.println(i+1 + ". $" + value);
        }
    }

    public static Customer create(String name) {
        return new Customer(name);
    }
}
