package model.challenge1;

public class Main {

    public static void main(String[] args) {
        var nationalUSParks = new Park[]{
                new Park("Yellowstone", "44.47, -110.57"),
                new Park("Grand Canyon", "36.1, -112.1"),
                new Park("Yosemite", "37.88, -119.53"),
        };

        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();

        System.out.println();

        var majorUSRivers = new River[]{
                new River("Mississipi", "47.22,-95,23", "29.16,-89.25", "35.16,-90.06"),
                new River("Missouri", "45.92,-111,49", "38.81,-90.25")
        };


        Layer<River> riverLayer = new Layer<>(majorUSRivers);


        riverLayer.addElements(
                new River("Colorado", "40.47,-105.826", "31.78, -114.77")
        );
        riverLayer.renderLayer();
    }
}
