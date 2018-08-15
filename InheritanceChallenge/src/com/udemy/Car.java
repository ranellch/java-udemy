package com.udemy;

public class Car extends Vehicle {

    private int wheels;
    private String color;
    private int gear;

    public Car(String name, int wheels, String color) {
        super(name, 0, null);
        this.wheels = wheels;
        this.color = color;
        this.gear = 0;
    }

    public void move(double speed, String direction, int gear) {
        setGear(gear);
        super.move(speed, direction);
    }

    public void setGear(int gear) {
        this.gear = gear;
        System.out.println("Now in gear " + gear);
    }

    @Override
    public void stop() {
        super.stop();
        this.gear = 0;
    }

    public int getWheels() {
        return wheels;
    }

    public String getColor() {
        return color;
    }

    public int getGear() {
        return gear;
    }
}
