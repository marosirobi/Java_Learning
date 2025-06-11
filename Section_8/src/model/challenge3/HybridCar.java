package model.challenge3;

public class HybridCar extends Car{

    private double avgKmPerLitre;
    private int cylinders = 6, batterySize;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double avgKmPerLitre, int cylinders, int batterySize) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        System.out.printf("Hybrid -> All %d cylinders are fired up, Ready!%n",cylinders);
        System.out.printf("Hybrid -> switch %d kWh battery on, Ready!%n",batterySize);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Hybrid -> Usage below average: %.2f%n", avgKmPerLitre);
    }
}
