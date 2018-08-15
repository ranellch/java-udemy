package com.example.mypackage;

import com.example.game.IStorageWriter;
import com.example.game.Monster;
import com.example.game.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player chris = new Player("Chris",100, 1, 58);
        Monster thing = new Monster("Blob",200,100);

        save(chris);
        load(chris);

        System.out.println("================");

        save(thing);
        load(thing);

    }

    public static void save(IStorageWriter savableObject) {
        System.out.println(savableObject.toString());
        ArrayList data = savableObject.getValuesToWrite();
        for (int i=0; i<data.size(); i++) {
            System.out.println("["+(i+1)+"] "+data.get((i)));
        }
    }

    public static void load(IStorageWriter savableObject) {
        ArrayList<String> values = readValues();
        savableObject.populateFields(values);
        System.out.println(savableObject.toString());
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                            "1 to enter a string\n" +
                            "0 to quit");

        while(!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
