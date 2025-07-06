package model.challenge2;

import model.challenge2.enums.Geometry;

public interface Mappable {

    String JSON_PROPERTY = """
                           "properties":{%s}""";

    String getLabel();
    Geometry getShape();
    String getMarker();

    default String toJSON(){
        return String.format("\"type\": \"%s\", \"label\": \"%s\", \"marker\": \"%s\"",getShape(),getLabel(),getMarker());
    }

    static void mapIt(Mappable map){
        System.out.println(JSON_PROPERTY.formatted(map.toJSON()));
    }
}
