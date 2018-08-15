package com.udemy;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        mobilePhone.printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    mobilePhone.printInstructions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    mobilePhone.addContact();
                    break;
                case 3:
                    mobilePhone.modifyContact();
                    break;
                case 4:
                    mobilePhone.removeContact();
                    break;
                case 5:
                    mobilePhone.searchContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

}
