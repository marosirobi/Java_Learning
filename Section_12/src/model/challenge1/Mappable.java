package model.challenge1;

public interface Mappable {

    void render();

    static double[] stringToLatLon(String data){
        String[] array = data.split(",");
        double lat = Double.parseDouble(array[0]);
        double lng = Double.parseDouble(array[1]);
        return new double[]{lat,lng};
    }
}
