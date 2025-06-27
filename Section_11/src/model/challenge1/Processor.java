package model.challenge1;

public class Processor extends ProductForSale{

    public Processor(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("CPU type is: %s, Price is: %.2f$%n%s%n",  type, price, description);
    }
}
