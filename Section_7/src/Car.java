public class Car {

    private String make;
    private String model;
    private String color;
    private int doors;
    private boolean convertible;

    public Car(){
        this("Default_make","Default_model","Default_color",3,false);
        System.out.println("Empty constructor called");
    }
    public Car(String make, String model, String color, int doors, boolean convertible){
        System.out.println("Car constructor with parameters called");
        this.make = make;
        this.model = model;
        this.convertible = convertible;
        this.color = color;
        this.doors = doors;
    }

    public Car(String make, String model) {
        this(make,model,"black", 3, true);
    }

    public void describeCar(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", doors=" + doors +
                ", convertible=" + convertible +
                '}';
    }

    public String getMake(){
        return make;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public int getDoors() {
        return doors;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public void setMake(String make) {
        if(make == null) make = "Unknown";
        String lowercaseMake = make.toLowerCase();
        switch (lowercaseMake){
            case "holden", "porsche", "tesla" -> this.make = make;
            default -> this.make = "Unsupported";
        }

    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }
}
