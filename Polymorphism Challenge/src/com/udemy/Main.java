package com.udemy;

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;
    private int speed;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
        this.speed = 0;
    }

    public void startEngine() {
        System.out.println("Starting engine");
    }

    public void accelerate(int speedIncrease) {
        System.out.println("Current speed: "+ speed + " Increasing speed.");
        speed += speedIncrease;
        System.out.println("New speed: " + speed);
    }

    public void hitBreak(int speedDecrease) {
        System.out.println("Current speed: "+ speed + " Decreasing speed.");
        speed -= speedDecrease;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("New speed: " + speed);
    }

    public String getName() {
        return name;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public int getSpeed() {
        return speed;
    }
}

class Ferrari extends Car {
    public Ferrari() {
        super(6,"Ferrari");
    }

    public void accelerate(int speedIncrease) {
        if (speedIncrease + super.getSpeed() > 240) {
            speedIncrease = 240 - super.getSpeed();
        }
        super.accelerate(speedIncrease);
        int accelerationTime = speedIncrease/12;
        System.out.println("Ferrari accelerated in " + accelerationTime + " seconds");
    }
}

class Malibu extends Car {
    public Malibu() {
        super(4,"Malibu");
    }

//    public void accelerate(int speedIncrease) {
//        if (speedIncrease + super.getSpeed() > 120) {
//            speedIncrease = 120 - super.getSpeed();
//        }
//        super.accelerate(speedIncrease);
//        int accelerationTime = speedIncrease/6;
//        System.out.println("Malibu accelerated in " + accelerationTime +" seconds");
//    }
}

class Lexus extends Car {
    public Lexus() {
        super(6,"Lexus");
    }

    public void accelerate(int speedIncrease) {
        if (speedIncrease + super.getSpeed() > 140) {
            speedIncrease = 140 - super.getSpeed();
        }
        super.accelerate(speedIncrease);
        int accelerationTime = speedIncrease/9;
        System.out.println("Lexus accelerated in " + accelerationTime +" seconds");
    }
}

public class Main {

    public static void main(String[] args) {
	    Lexus lexus = new Lexus();
	    Malibu malibu = new Malibu();
	    Ferrari ferrari = new Ferrari();

	    lexus.accelerate(100);
        System.out.println("=====");
        malibu.accelerate(100);
        System.out.println("=====");
        ferrari.accelerate(100);
    }
}
