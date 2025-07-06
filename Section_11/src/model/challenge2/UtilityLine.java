package model.challenge2;

import model.challenge2.enums.Color;
import model.challenge2.enums.Geometry;
import model.challenge2.enums.LineMarkers;
import model.challenge2.enums.UtilityType;

public class UtilityLine extends BaseMap implements Mappable{
    private String name;
    private UtilityType utilityType;

    public UtilityLine(Color color, LineMarkers marker, String name, UtilityType utilityType) {
        super(color, marker);
        this.name = name;
        this.utilityType = utilityType;
    }

    @Override
    public String getLabel() {
        return String.format("%s (%s)", name, utilityType);
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
        json.insert(json.length(),String.format(", \"name\": \"%s\", \"utility:\": \"%s\"",name,utilityType));
        return json.toString();
    }
}
