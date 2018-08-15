package com.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(5,6));
        System.out.println(calcFeetAndInchesToCentimeters(100));
    }

    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        if (feet < 0 ) {
            return -1;
        }
        if (inches < 0 || inches > 12) {
            return -1;
        }
        int inchesTotal = feet * 12 + inches;
        return inchesTotal * 2.54;
    }

    public static double calcFeetAndInchesToCentimeters(int inches) {
        if (inches < 0) {
            return -1;
        }
        int feet = inches / 12;
        int inchesRemainder = inches % 12;
        return calcFeetAndInchesToCentimeters(feet,inchesRemainder);
    }
}
