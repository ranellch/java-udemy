package com.udemy;

public class Main {

    public static void main(String[] args) {
	    int count = 1;
	    while(count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }

        count = 1;
	    while(true) {
	        if (count == 6) {
	            break;
            }
            System.out.println("Count value is " + count);
	        count++;
        }

        count = 1;
        do {
            System.out.println("Count value was " + count);
            count++;
        } while(count != 6);

        int x = 5;
        int y = 20;
        count = 0;
        while (x <= y && count < 5) {
            if (!isEvenNumber(x)) {
                x++;
                continue;
            }
            System.out.println("Even number " + x);
            count++;
            x++;
        }
        System.out.println("Total even numbers found = " + count);
    }

    public static boolean isEvenNumber(int x) {
        if (x % 2 == 0) {
            return true;
        }
        return false;
    }
}
