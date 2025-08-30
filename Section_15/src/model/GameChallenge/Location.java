package model.GameChallenge;

import java.util.Map;

public class Location {

    private String name, desc;
    private Map<String, String> nextPlaces;


    public Location(String name) {
        this.name = name;
        this.desc = LocationData.getDesc(name);
        this.nextPlaces = LocationData.getNextLocations(name);
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Map<String, String> getNextPlaces() {
        return nextPlaces;
    }
}
