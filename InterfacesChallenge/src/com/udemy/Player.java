package com.udemy;

import java.util.ArrayList;

public class Player implements IStorageWriter {
    private String name;
    private int points;
    private int rank;
    private int health;

    public Player(String name, int points, int rank, int health) {
        this.name = name;
        this.points = points;
        this.rank = rank;
        this.health = health;
    }

    @Override
    public ArrayList<String> getValuesToWrite() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(name);
        data.add(Integer.toString(points));
        data.add(Integer.toString(rank));
        data.add(Integer.toString(health));
        return data;
    }

    @Override
    public void populateFields(ArrayList<String> data) {
        this.name = data.get(0);
        this.points = Integer.parseInt(data.get(1));
        this.rank = Integer.parseInt(data.get(2));
        this.health = Integer.parseInt(data.get(3));
    }

    @Override
    public String toString() {
        return "Player: " + name +"\n"+
                "Points: " + points +"\n"+
                "Rank: " + rank + "\n" +
                "Health: " + health;
    }


    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getRank() {
        return rank;
    }

    public int getHealth() {
        return health;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
