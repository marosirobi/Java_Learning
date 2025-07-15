package model.challenge1;

import java.util.Arrays;

abstract class Line implements Mappable{

    private double[][] locations;

    public Line(String... locations){
        this.locations = new double[locations.length][];
        int index = 0;
        for(var l : locations){
            this.locations[index++] = Mappable.stringToLatLon(l);
        }
    }

    private String location(){
        return Arrays.deepToString(locations);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + location() + ")");
    }


}
