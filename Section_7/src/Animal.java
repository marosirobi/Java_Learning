public class Animal {
    private int weight;
    protected String type;
    private String size;

    public Animal(){

    }

    public Animal(String size, String type, int weight) {
        this.size = size;
        this.type = type;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public void move(String speed){
        System.out.println("The " + type + " moves " + speed);
    }

    public void makeNoise(){
        System.out.println("The " + type + " makes some kind of noise");
    }
}
