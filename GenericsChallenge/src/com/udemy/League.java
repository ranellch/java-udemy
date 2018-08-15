package com.udemy;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team> {
    private String name;
    private ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        if(teams.contains(team)) {
            System.out.println(team.getName() + " is already in this league");
            return false;
        } else {
            teams.add(team);
            System.out.println(team.getName() + " added to league " + this.name);
            return true;
        }
    }

    public void printTeams() {
        Collections.sort(teams);
        System.out.println("Teams in order of rank:");
        for (int i=0; i<teams.size(); i++) {
            System.out.println((i+1) + ". " + teams.get(i).getName());
        }
    }
}
