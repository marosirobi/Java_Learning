package model.challenge1;

import java.util.Arrays;

abstract class Point implements Mappable{
    private double[] location = new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    private String location(){
        return Arrays.toString(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }
}
