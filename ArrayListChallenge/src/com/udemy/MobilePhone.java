package com.udemy;

import java.util.Scanner;

public class MobilePhone {
    private static Scanner scanner = new Scanner(System.in);
    private ContactList contactList = new ContactList();


    public void printInstructions() {
        System.out.println("Press");
        System.out.println("0 - To print options");
        System.out.println("1 - To print contacts");
        System.out.println("2 - To add contact");
        System.out.println("3 - To modify contact");
        System.out.println("4 - To remove contact");
        System.out.println("5 - To search for contact");
        System.out.println("6 - to quit the application");
    }

    public void printContacts() {
        contactList.printContactList();
    }

    public void addContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the phone number (xxx) xxx - xxxx:");
        String number = scanner.nextLine();
        contactList.addContact(new Contact(name,number));
    }

    public void modifyContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the new phone number (xxx) xxx - xxxx");
        String number = scanner.nextLine();
        contactList.modifyContact(name,number);
    }

    public void removeContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.nextLine();
        contactList.removeContact(name);
    }

    public void searchContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.nextLine();
        Contact contactInfo = contactList.getContact(name);
        if (contactInfo != null) {
            System.out.println("Number: " + contactInfo.getNumber());
        } else {
            System.out.println("Could not find contact.");
        }

    }
}
