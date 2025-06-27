package model.challenge1;

import java.util.ArrayList;

public class Store {

    private ArrayList<ProductForSale> products;
    private ArrayList<OrderItem> itemsOrdered;

    public Store() {
        this.itemsOrdered = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.addNewProduct(new ComputerObject("Intel", 150.4,"decent processor"));
        store.addNewProduct(new ComputerObject("NVIDIA", 654,"best processor"));
        store.addNewProduct(new ComputerObject("Gigabyte", 114.2,"worst cpu"));
        store.addNewProduct(new ComputerObject("AMD", 255.2,"good processor"));

        displayProducts(store.products);

        System.out.println("/".repeat(40));

        store.addOrderItem(10,"nvidia");
        store.addOrderItem(15,"amd");
        store.addOrderItem(5,"InTel");
        store.addOrderItem(13,0);

        listOrderedItems(store.itemsOrdered);
    }

    public static void displayProducts(ArrayList<ProductForSale> products){
        System.out.println("The list of the products");
        int index = 0;
        for(var item : products){
            System.out.println("-".repeat(30));
            System.out.print(index+1 + ". ");
            item.showDetails();
            index++;
        }
    }

    public void addNewProduct(ProductForSale product){
        products.add(product);
    }

    public void addOrderItem(int quantity, String type){
        for(var item : products){
            if(item.type.equalsIgnoreCase(type)){
                itemsOrdered.add(new OrderItem(quantity,item));
            }
        }
    }

    public void addOrderItem(int quantity, int itemIndex){
        itemsOrdered.add(new OrderItem(quantity,products.get(itemIndex)));
    }

    public static void listOrderedItems(ArrayList<OrderItem> itemsOrdered){
        for(var item : itemsOrdered){
            item.product().printPricedItem(item.quantity());
        }
        System.out.println("-".repeat(40));
        System.out.printf("Sum is = %.2f%n", getPriceOfOrdered(itemsOrdered));
    }

    public static double getPriceOfOrdered(ArrayList<OrderItem> itemsOrdered){
        double sum = 0;
        for(var item : itemsOrdered){
            sum += item.product().getSalesPrice(item.quantity());
        }
        return sum;
    }

}
