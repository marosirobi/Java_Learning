package model.challenge1;

public class GraphicsCard extends ProductForSale{

    public GraphicsCard(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("GPU type is: %s, Price is: %.2f$%n%s%n",  type, price, description);
    }
}
