package model.StoreChallenge;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    enum CartType{VIR,PHY}

    private static int LAST_ID = 1;

    private int id;
    private Map<String,Integer> products;
    private LocalDate date;
    private CartType type;

    public Cart(CartType type, int days) {
        this.type = type;
        id = LAST_ID++;
        products = new HashMap();
        date = LocalDate.now().minusDays(days);
    }

    public Cart(int id) {
        this.id = id;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void addItem(InventoryItem item, int qty){
        if(!item.reserveItem(qty)){
            System.out.println("Something went wrong...");
        }
        products.merge(item.getProduct().sku(), qty, Integer::sum);


    }
    public void removeItem(InventoryItem item, int qty){
        int current = products.get(item.getProduct().sku());
        if(current <= qty){
            qty = current;
            products.remove(item.getProduct().sku());
            System.out.printf("The item [%s] removed from basket%n", item.getProduct().name());
        }else{
            products.merge(item.getProduct().sku(), -qty,Integer::sum);
            System.out.printf("%d amount of %s is removed",qty, item.getProduct().name());
        }
        item.releaseItem(qty);
    }

    public void printSalesSlip(Map<String, InventoryItem> inventory){
        double total = 0;
        System.out.println("-----------------------------------------------------");
        for(var cartItem : products.entrySet()){
            var item = inventory.get(cartItem.getKey());
            int qty = cartItem.getValue();
            double itemPrice = qty * item.getSalesPrice();
            System.out.printf("\t%s %-10s (%d)@ $%.2f = $%.2f%n",cartItem.getKey(),item.getProduct().name(),
                    qty, item.getSalesPrice(), itemPrice);
            total += itemPrice;
        }
        System.out.printf("Total Sale: %.2f%n",total);
        System.out.println("-----------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", products=" + products +
                ", date=" + date +
                '}';
    }
}
