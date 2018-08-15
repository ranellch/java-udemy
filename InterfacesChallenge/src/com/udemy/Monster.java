package com.udemy;

import java.util.ArrayList;

public class Monster implements IStorageWriter {
    private String name;
    private int size;
    private int health;

    public Monster(String name, int size, int health) {
        this.name = name;
        this.size = size;
        this.health = health;
    }

    @Override
    public ArrayList<String> getValuesToWrite() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(name);
        data.add(Integer.toString(size));
        data.add(Integer.toString(health));
        return data;
    }

    @Override
    public void populateFields(ArrayList<String> data) {
        this.name = data.get(0);
        this.size = Integer.parseInt(data.get(1));
        this.health = Integer.parseInt(data.get(2));
    }

    @Override
    public String toString() {
        return "Monster: " + name +"\n"+
                "Size: " + size +"\n"+
                "Health: " + health;
    }


    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}