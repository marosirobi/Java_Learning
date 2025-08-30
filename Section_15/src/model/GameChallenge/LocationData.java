package model.GameChallenge;

import java.util.HashMap;
import java.util.Map;

public class LocationData {

    private static String data = """
            road,at the end of the road, W: hill, E:well house,S:valley,N:forest
            hill,on top of hill with a view in all directions,N:forest, E:road
            well house,inside a well house for a small spring,W:road,N:lake,S:stream
            valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
            forest,at the edge of a thick dark forest,S:road,E:lake
            lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
            stream,near a stream with a rocky bed,W:valley, N:well house
            """;

    public static void addPlaces(String places){
        data += places;
    }

    public static Map<String, String> getNextLocations(String name){

        Map<String, String> locations = new HashMap<>();

        for(String s : data.split("\n")){

            String[] array = s.split(",");
            if (array[0].contains(name) && array.length > 2) {
                for(int i = 2; i < array.length; i++){
                    locations.put(array[i].split(":")[0].trim(),array[i].split(":")[1].trim());
                }
                break;
            }
        }
        return locations;
    }

    public static String getDesc(String name){
        for(String s : data.split("\n")){
            String[] array = s.split(",");
            if (array[0].contains(name)) {
                return array[1];
            }
        }
        return null;
    }
}
