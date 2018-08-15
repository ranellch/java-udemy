package com.ranella;

import java.util.HashSet;
import java.util.Set;

public class Planet extends HeavenlyBody {
    private final Set<Moon> satellites;

    public Planet(String name, double orbitalPeriod) {
        super(name, "PLANET", orbitalPeriod);
        this.satellites = new HashSet<>();
    }

    @Override
    public Set<Moon> getSatellites() {
        return satellites;
    }

    public boolean addMoon(Moon moon) {
        return this.satellites.add(moon);
    }
}
