public class Fish extends Animal{
    private int fins,gills;

    public Fish(String type, int weight, int fins, int gills) {
        super("small", type, weight);
        this.fins = fins;
        this.gills = gills;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
    }

    private void moveMuscles(){
        System.out.print("muscles moving ");
    }
    private void moveBackFin(){
        System.out.print("Backfin moving ");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        moveMuscles();
        if(speed == "fast")
            moveBackFin();
        System.out.println();
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fins=" + fins +
                ", gills=" + gills +
                "} " + super.toString();
    }
}
