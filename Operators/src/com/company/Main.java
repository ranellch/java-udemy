package com.company;

public class Main {

    public static void main(String[] args) {
	    boolean isAlien = false;
	    if (isAlien == false)
            System.out.println("It is not an alien!");

	    int topScore = 100;
	    if (topScore >= 100)
            System.out.println("You got the high score!");

	    int secondTopScore = 81;
	    if ((topScore > 90) || (secondTopScore <= 90))
            System.out.println("One of these tests is true");

	    boolean isCar = true;
	    boolean wasCar = isCar ? true : false;

	    if (wasCar)
            System.out.println("wasCar is true");

	    double x = 20d;
        double y = 80d;
        double z = (x+y) * 25;
        double w = z % 40;

        if (w <= 20)
            System.out.println("Total was over the limit");
    }
}
