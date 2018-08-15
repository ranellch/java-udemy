package com.ranella;

import java.util.Set;

public class Moon extends HeavenlyBody {
    public Moon(String name, double orbitalPeriod) {
        super(name, "MOON", orbitalPeriod);
    }

    @Override
    public Set<HeavenlyBody> getSatellites() {
        System.out.println("No satellites around moons");
        return null;
    }
}
