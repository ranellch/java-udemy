package com.udemy;

public class Desk {

    private int size;
    private String color;
    private boolean isClean;

    public Desk(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public void clean() {
        System.out.println("Cleaning desk");
        isClean = true;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
