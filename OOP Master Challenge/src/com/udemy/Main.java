package com.udemy;

class Hamburger {

    private String bread;
    private String meat;
    private double price;
    private Addition addition1;
    private Addition addition2;
    private Addition addition3;
    private Addition addition4;
    private int additionCount = 0;


    public Hamburger(String bread, String meat, double price) {
        this.bread = bread;
        this.meat = meat;
        this.price = price;
    }

    public void addItem(Addition addition) {
        if (additionCount < 4) {
            switch (additionCount) {
                case 0:
                    addition1 = addition;
                    break;
                case 1:
                    addition2 = addition;
                    break;
                case 2:
                    addition3 = addition;
                    break;
                case 3:
                    addition4 = addition;
            }
            additionCount++;
        } else {
            System.out.println("Only 4 additional items allowed");
        }
    }

    public void totalPrice() {
        System.out.println("Base price: $" + price);
        double total = price + ringUpAdditions();
        System.out.println("===================");
        System.out.println("Grand total: $" + total + "\n");
    }

    public double ringUpAdditions() {
        double total = 0;
        switch(additionCount) {
            case 0:
                System.out.println("No additional items");
                break;
            case 1:
                total += getAddition(addition1);
                break;
            case 2:
                total += getAddition(addition1);
                total += getAddition(addition2);
                break;
            case 3:
                total += getAddition(addition1);
                total += getAddition(addition2);
                total += getAddition(addition3);
                break;
            case 4:
                total += getAddition(addition1);
                total += getAddition(addition2);
                total += getAddition(addition3);
                total += getAddition(addition4);
                break;
        }
        return total;
    }

    public double getAddition(Addition addition) {
        System.out.println(addition.getName() +": $"+addition.getPrice());
        return addition.getPrice();
    }

    public String getBread() {
        return bread;
    }

    public String getMeat() {
        return meat;
    }

    public double getPrice() {
        return price;
    }

    public int getAdditionCount() {
        return additionCount;
    }


}

class HealthyBurger extends Hamburger {

    private Addition addition5;
    private Addition addition6;
    private int extraAdditionCount = 0;

    public HealthyBurger(String meat, double price) {
        super("Brown Rye", meat, price);
    }

    @Override
    public void addItem(Addition addition) {
        if (super.getAdditionCount() < 4) {
            super.addItem(addition);
        } else if (super.getAdditionCount() >= 4 && extraAdditionCount < 2) {
            switch (extraAdditionCount) {
                case 0:
                    addition5 = addition;
                    break;
                case 1:
                    addition6 = addition;
                    break;
            }
            extraAdditionCount++;
        } else {
            System.out.println("Only 6 additional items allowed");
        }
    }

    @Override
    public void totalPrice() {
        if (super.getAdditionCount() <= 4 && extraAdditionCount == 0) {
            System.out.println("Base price: $" + super.getPrice());
            double total = super.getPrice() + super.ringUpAdditions();
            System.out.println("===================");
            System.out.println("Grand total: $" + total + "\n");
        } else {
            double price = super.getPrice();
            System.out.println("Base price: $" + price);
            double total = price + super.ringUpAdditions();
            total += ringUpAdditions();
            System.out.println("===================");
            System.out.println("Grand total: $" + total + "\n");
        }
    }

    @Override
    public double ringUpAdditions() {
        double total = 0;
        switch (extraAdditionCount) {
            case 0:
                break;
            case 1:
                total += super.getAddition(addition5);
                break;
            case 2:
                total += super.getAddition(addition5);
                total += super.getAddition(addition6);
                break;
        }
        return total;
    }
}

class DeluxeBurger extends Hamburger {

    public DeluxeBurger(String bread, String meat, double price) {
        super(bread, meat, price);
        super.addItem(new Addition("chips",0.85));
        super.addItem(new Addition("drink",1.00));
    }

    @Override
    public void addItem(Addition addition) {
        System.out.println("No other additions allowed");
    }
}

class Addition {

    private String name;
    private double price;

    public Addition(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class Main {

    public static void main(String[] args) {
        Hamburger myBurger = new Hamburger("Brioche","Sirloin",9.95);
        myBurger.addItem(new Addition("Swiss",1.00));
        myBurger.addItem( new Addition("Mushrooms",0.65));
        myBurger.totalPrice();

        HealthyBurger myBurger2 = new HealthyBurger("Turkey",8.95);
        myBurger2.addItem(new Addition("Arugula",0.65));
        myBurger2.addItem(new Addition("Tomato",0.65));
        myBurger2.addItem(new Addition("Muenster",0.65));
        myBurger2.addItem(new Addition("Guacamole",0.65));
        myBurger2.addItem(new Addition("Mayo",0.65));
        myBurger2.addItem(new Addition("Onions",0.65));
        myBurger2.addItem(new Addition("Arugula",0.65));
        myBurger2.totalPrice();

        DeluxeBurger myBurger3 = new DeluxeBurger("Sourdough","Sirloin",9.95);
        myBurger3.addItem(new Addition("Arugula",0.65));
        myBurger3.totalPrice();
    }
}
