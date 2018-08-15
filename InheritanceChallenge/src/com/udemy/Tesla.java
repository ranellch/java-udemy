package com.udemy;

public class Tesla extends Car {

    private int charge;

    public Tesla(String name, String color, int charge) {
        super("Tesla " + name, 4, color);
        this.charge = charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getCharge() {

        return charge;
    }

}
