package com.udemy;

import java.util.ArrayList;

public abstract class Team implements Comparable<Team> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;


    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void matchResult(Team opponent, int ourScore, int theirScore) {

        String message;

        if (ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if (ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team team) {
        if(this.ranking() > team.ranking()) {
            return -1;
        } else if(this.ranking() < team.ranking()) {
            return 1;
        }
        return 0;
    }
}
