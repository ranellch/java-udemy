package com.udemy;

import java.util.ArrayList;

public class Branch {
    private String name;
    private String address;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public boolean addCustomer(Customer customer, double transaction) {
        if (findCustomer(customer.getName()) >= 0) {
            System.out.println("Customer already exists.");
            return false;
        }
        customer.addTransaction(transaction);
        boolean success = customers.add(customer);
        if (success) {
            System.out.println("Customer added - Name: " + customer.getName());
            retrieveCustomer(customer.getName()).printTransactions();
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String name, double amount) {
        int index = findCustomer(name);
        if (index < 0) {
            System.out.println("Customer does not exist.");
            return false;
        }
        boolean success = customers.get(index).addTransaction(amount);
        if (success) {
            System.out.println("Name: " + name + " Transaction amount: $" + amount);
            return true;
        }
        return false;
    }

    public void printCustomers() {
        System.out.println("Customers: ");
        for(int i=0; i<customers.size(); i++) {
            Customer customer = customers.get(i);
            String name = customer.getName();
            System.out.println(i+1 + ". " + name);
        }
    }

    public void printCustomerTransactions(String name) {
        Customer customer = retrieveCustomer(name);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        System.out.println( name + ": ");
        customer.printTransactions();
    }

    public Customer retrieveCustomer(String name) {
        int index = findCustomer(name);
        if (index >= 0) {
            return customers.get(index);
        }
        return null;
    }

    private int findCustomer(String name) {
        for(int i=0; i<customers.size(); i++) {
           if (customers.get(i).getName().equals(name)) {
               return i;
           }
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static Branch create(String name, String address) {
        return new Branch(name, address);
    }
}
