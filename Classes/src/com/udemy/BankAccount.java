package com.udemy;

public class BankAccount {

    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private int phoneNumber;

    public BankAccount() {
        this(56789, 2.50, "Default name",
                "Default address", 555555);
        System.out.println("Empty constructor called");
    }

    public BankAccount(int accountNumber, double balance, String customerName, String email,
                       int phoneNumber) {
        System.out.println("Account constructor with parameters called");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public  void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void depositFunds(double deposit) {
        System.out.println("Previous balance: " + this.balance);
        this.balance += deposit;
        System.out.println("New balance: " + this.balance);
    }

    public void withdrawFunds(double withdrawal) {
        if(balance < withdrawal) {
            System.out.println("Insufficient funds");
            return;
        }
        System.out.println("Previous balance: " + this.balance);
        this.balance -= withdrawal;
        System.out.println("New balance: " + this.balance);
    }
}
