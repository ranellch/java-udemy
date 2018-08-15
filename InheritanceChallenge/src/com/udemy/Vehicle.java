package com.udemy;

public class Vehicle {

    private String name;
    private double speed;
    private String direction;

    public Vehicle(String name, double speed, String direction) {
        this.name = name;
        this.speed = speed;
        this.direction = direction;
    }

    public void move(double speed, String direction) {
        this.speed = speed;
        this.direction = direction;
        System.out.println("Moving " + direction + " at " + speed + "mph");
    }

    public void stop() {
        this.speed = 0;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public String getDirection() {
        return direction;
    }
}
