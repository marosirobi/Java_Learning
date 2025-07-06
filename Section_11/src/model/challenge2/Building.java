package model.challenge2;

import model.challenge2.enums.Color;
import model.challenge2.enums.Geometry;
import model.challenge2.enums.PointMarkers;
import model.challenge2.enums.UsageType;

public class Building extends BaseMap implements Mappable{
    private String name;
    private UsageType buildingType;

    public Building(Color color, PointMarkers marker, String name, UsageType buildingType) {
        super(color, marker);
        this.buildingType = buildingType;
        this.name = name;
    }

    @Override
    public String getLabel() {
        return String.format("%s (%s)", name, buildingType);
    }

    @Override
    public Geometry getShape() {
        return super.getGeometry();
    }

    @Override
    public String getMarker() {
        return super.getMarker();
    }

    @Override
    public String toJSON() {
        StringBuilder json = new StringBuilder();
        json.append(Mappable.super.toJSON());
        json.insert(json.length(),String.format(", \"name\": \"%s\", \"usage:\": \"%s\"",name,buildingType));
        return json.toString();
    }
}
