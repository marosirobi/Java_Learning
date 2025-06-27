package model.challenge1;

public abstract class ProductForSale {

    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity) {
        return quantity * price;
    }

    public void printPricedItem(int quantity){
        System.out.printf("%s %2d qty at $%8.2f each, %-5s %-15s %n", type, quantity, price, quantity, getSalesPrice(quantity));
    }

    public abstract void showDetails();


}
