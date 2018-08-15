package com.udemy;

public class Main {

    public static void main(String[] args) {
	    Tesla mycar = new Tesla("Model 3", "black", 100);
        System.out.println(mycar.getName());
        mycar.move(120, "NW", 4);
    }
}
