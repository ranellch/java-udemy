package com.udemy;

public class Main {

    public static void main(String[] args) {

        FootballTeam adelaideCrows = new FootballTeam("Adelaide Crows");
        FootballTeam detroitLions = new FootballTeam("Detroit Lions");
        FootballTeam jerseyMikes = new FootballTeam("Jersey Mikes");

        League<FootballTeam> nfl = new League<FootballTeam>("NFL");

        nfl.addTeam(adelaideCrows);
        nfl.addTeam(detroitLions);
        nfl.addTeam(jerseyMikes);

        detroitLions.matchResult(adelaideCrows,7,56);
        adelaideCrows.matchResult(jerseyMikes,14,23);
        jerseyMikes.matchResult(detroitLions,34,26);

        System.out.println("Lions ranking: " + detroitLions.ranking());
        System.out.println("Crows ranking: " + adelaideCrows.ranking());
        System.out.println("Mikes ranking: " + jerseyMikes.ranking());

        nfl.printTeams();
    }
}
