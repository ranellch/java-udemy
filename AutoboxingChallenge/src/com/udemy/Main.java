package com.udemy;

public class Main {

    public static void main(String[] args) {
        Bank bankOfAmerica = new Bank("Bank of America");
        bankOfAmerica.addBranch("San Ramon Bank of America", "123 Street");
        bankOfAmerica.addCustomerToBranch("Chris","San Ramon Bank of America", 150.50);
        bankOfAmerica.printCustomersForBranch("San Ramon Bank of America");
        bankOfAmerica.addTransactionToCustomer("Chris","San Ramon Bank of America", -100);
        bankOfAmerica.printCustomerTransactionsForBranch("San Ramon Bank of America","Chris");
        bankOfAmerica.addCustomerToBranch("Rick","San Ramon Bank of America", 69);
    }
}