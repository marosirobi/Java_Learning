package model.challenge1;

public class ComputerObject extends ProductForSale{


    public ComputerObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("Part type is: %s, Price is: %.2f$%n%s%n",  type, price, description);
    }
}
