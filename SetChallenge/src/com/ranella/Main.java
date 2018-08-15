package com.ranella;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        Planet temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        Planet pluto = new Planet("Pluto",12312312);
        Moon moonPluto = new Moon("Pluto",248);
        System.out.println(pluto.equals(temp));
        System.out.println(temp.equals(pluto));
        System.out.println(pluto.equals(moonPluto));

        System.out.println("All Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName()+ ", " + planet.getOrbitalPeriod());
        }
        planets.add(pluto);
        System.out.println("All Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName() + ", " + planet.getOrbitalPeriod());
        }

        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName() + ", " + moon.getOrbitalPeriod());
        }
        moons.add(new Moon("Ganymede",69));
        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName() + ", " + moon.getOrbitalPeriod());
        }

        Map<Integer,HeavenlyBody> things = new HashMap<>();
        things.put(pluto.hashCode(),pluto);
        things.put(moonPluto.hashCode(),moonPluto);
        for(int key : things.keySet()) {
            System.out.println(things.get(key).getOrbitalPeriod());
        }
        Moon duplicate1 = new Moon("Ganymede",69);
        Moon duplicate2 = new Moon("Ganymede",80085);
        things.put(duplicate1.hashCode(),duplicate1);
        for(int key : things.keySet()) {
            System.out.println(things.get(key));
        }
        things.put(duplicate2.hashCode(),duplicate2);
        for(int key : things.keySet()) {
            System.out.println(things.get(key));
        }
    }
}
