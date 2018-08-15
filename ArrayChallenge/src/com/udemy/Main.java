package com.udemy;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        System.out.println("Input array:");
        printArray(myIntegers);
        int[] sortedIntegers = sortIntegers(myIntegers);
        System.out.println("Sorted array:");
        printArray(sortedIntegers);
    }

    public static void printArray(int[] array) {
        String arrayStr = "";
        for (int i = 0; i < array.length; i++) {
           arrayStr += array[i] + " ";
        }
        System.out.println(arrayStr);
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for(int i=0; i<values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int currentMax = array[0];
            int maxIndex = 0;
            for (int j =0; j < array.length; j++) {
                if (array[j] > currentMax) {
                    currentMax = array[j];
                    maxIndex = j;
                }
            }
            sortedArray[i] = currentMax;
            array[maxIndex] = -1000000;
        }
        return sortedArray;
    }
}
