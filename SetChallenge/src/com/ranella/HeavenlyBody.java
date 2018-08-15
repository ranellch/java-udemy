package com.ranella;

import java.util.Set;

public abstract class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final String bodyType;

    public HeavenlyBody(String name, String bodyType, double orbitalPeriod) {
        this.name = name;
        this.bodyType = bodyType;
        this.orbitalPeriod = orbitalPeriod;
    }

    public abstract Set getSatellites();

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getBodyType() {
        return bodyType;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        String objType = ((HeavenlyBody) obj).getBodyType();
        return (this.name.equals(objName) && this.bodyType.equals(objType));
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.bodyType.hashCode() + 57;
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + name + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
