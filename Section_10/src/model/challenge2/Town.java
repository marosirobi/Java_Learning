package model.challenge2;

public class Town {

    private String town;
    private int distance; // from sydney

    public Town(String town, int distance) {
        this.town = town;
        this.distance = distance;
    }

    public String getTown() {
        return town;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return String.format("%s --> %d",town,distance);
    }
}
