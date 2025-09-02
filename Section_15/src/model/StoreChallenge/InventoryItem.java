package model.StoreChallenge;

import java.util.Scanner;

enum ProductCategory{
    PRODUCE,DAIRY, CEREAL,MEAT,BEVERAGE
}

record Product(String sku,String name,String manufacturer, ProductCategory category){

}

public class InventoryItem {

    private Product product;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder;
    private int qtyLow;
    private double salesPrice;

    public InventoryItem(Product product, double salesPrice) {
        this(product, salesPrice, 10, 2);
    }

    public InventoryItem(Product product, double salesPrice, int qtyTotal){
        this(product, salesPrice, qtyTotal,2);
    }

    public InventoryItem(Product product, double salesPrice, int qtyTotal, int qtyLow) {
        this.product = product;
        this.salesPrice = salesPrice;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.qtyReorder = qtyTotal;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public Product getProduct() {
        return product;
    }

    public boolean reserveItem(int amount){
        if(amount <= qtyTotal) {
            qtyReserved += amount;
            qtyTotal -= amount;
            return true;
        }
        System.out.println("You can't reserve this much: " + amount + ", Stock is: " + qtyTotal);
        return false;
    }

    public void releaseItem(int qty){
        qtyReserved -=qty;
        qtyTotal += qty;
    }

    public boolean sellItem(){
        qtyReserved = 0;
        placeInventoryOrder(qtyTotal <= qtyLow);
        return true;
    }

    public void placeInventoryOrder(boolean needReorder){
        if(needReorder) {
            qtyTotal += qtyReorder;
        }
    }


    @Override
    public String toString() {
        return "%s: Total: %d, Reserved: %d, Price: $%.2f".formatted(product,qtyTotal,qtyReserved,salesPrice);
    }
}
