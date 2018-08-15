package com.udemy;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<Branch>();

    public Bank(String name) {
        this.name = name;
    }

    public void addBranch(String name, String address) {
        if (findBranch(name) >= 0) {
            System.out.println("Branch already exists.");
            return;
        }
        Branch newBranch = Branch.create(name, address);
        boolean success = branches.add(newBranch);
        if (success) {
            System.out.println(name + " successfully added.");
        }
    }

    public void addCustomerToBranch(String customerName, String branchName, double initialTransaction) {
        int branchIndex = findBranch(branchName);
        if (branchIndex < 0) {
            System.out.println("Branch not found.");
            return;
        }
        Customer newCustomer = Customer.create(customerName);
        boolean success = branches.get(branchIndex).addCustomer(newCustomer,initialTransaction);
        if (success) {
            System.out.println(customerName + " added to branch " + branchName);
        }
    }

    public void addTransactionToCustomer(String customerName, String branchName, double amount) {
        int branchIndex = findBranch(branchName);
        if (branchIndex < 0) {
            System.out.println("Branch not found.");
            return;
        }
        branches.get(branchIndex).addCustomerTransaction(customerName, amount);
    }

    public void printCustomersForBranch(String branchName) {
        int branchIndex = findBranch(branchName);
        if (branchIndex < 0) {
            System.out.println("Branch not found.");
            return;
        }
        branches.get(branchIndex).printCustomers();
    }

    public void printCustomerTransactionsForBranch(String branchName, String customerName) {
        int branchIndex = findBranch(branchName);
        if (branchIndex < 0) {
            System.out.println("Branch not found.");
            return;
        }
        branches.get(branchIndex).printCustomerTransactions(customerName);
    }

    private int findBranch(String name) {
        for(int i=0; i<branches.size(); i++) {
            if (branches.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String getName() {
        return name;
    }
}
