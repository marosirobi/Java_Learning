package model.StoreChallenge;

import java.time.LocalDate;
import java.util.*;

public class Store {

    private static Random random = new Random();
    private NavigableSet<Cart> carts = new TreeSet<>(Comparator.comparing(Cart::getId));
    private Map<String,InventoryItem> inventory;
    private Map<ProductCategory, Map<String, InventoryItem>> aisleInventory;

    public static void main(String[] args) {
        Store store = new Store();
        store.stockStore();
        store.listInventory();

        store.stockAisles();
        store.listProductsByCategory(false,true);

        store.manageStoreCarts();
        store.listInventory();

        store.carts.forEach(System.out::println);

        store.abandonCarts();
        store.listProductsByCategory(false,true);
        store.carts.forEach(System.out::println);
    }

    private void manageStoreCarts(){
        Cart cart1 = new Cart(Cart.CartType.PHY,1);
        carts.add(cart1);

        InventoryItem item = aisleInventory.get(ProductCategory.PRODUCE).get("apple");
        cart1.addItem(item,6);
        cart1.addItem(aisleInventory.get(ProductCategory.PRODUCE).get("pear"), 5);
        cart1.addItem(aisleInventory.get(ProductCategory.BEVERAGE).get("coffee"), 1);
        cart1.removeItem(aisleInventory.get(ProductCategory.PRODUCE).get("pear"),2);
        System.out.println(cart1);

        Cart cart2 = new Cart(Cart.CartType.VIR, 1);
        carts.add(cart2);
        cart2.addItem(inventory.get("L103"), 20);
        cart2.addItem(inventory.get("B100"), 10);
        System.out.println(cart2);

        Cart cart3 = new Cart(Cart.CartType.VIR, 0);
        carts.add(cart3);
        cart3.addItem(inventory.get("R777"), 998);
        System.out.println(cart3);

        if(!checkOutCart(cart3)){
            System.out.println("Something went wrong");
        }

        Cart cart4 = new Cart(Cart.CartType.PHY, 0);
        carts.add(cart4);
        cart4.addItem(aisleInventory.get(ProductCategory.BEVERAGE).get("tea"),1);
        System.out.println(cart4);
    }

    private void abandonCarts(){
        int dayOfYear = LocalDate.now().getDayOfYear();
        Cart lastCart = null;
        for(Cart c : carts){
            if(c.getDate().getDayOfYear() == dayOfYear){
                break;
            }
            lastCart = c;
        }
        var oldCarts = carts.headSet(lastCart,true);
        Cart abandonedCart = null;
        while((abandonedCart = oldCarts.pollFirst()) != null){
            for(String sku : abandonedCart.getProducts().keySet()){
                InventoryItem item = inventory.get(sku);
                item.releaseItem(abandonedCart.getProducts().get(sku));
            }
        }

    }

    private boolean checkOutCart(Cart cart){
        for (var cartItem : cart.getProducts().entrySet()){
            var item = inventory.get(cartItem.getKey());
            int qty = cartItem.getValue();
            item.sellItem();
        }
        cart.printSalesSlip(inventory);
        carts.remove(cart);
        return true;
    }

    private void listProductsByCategory(){
        listProductsByCategory(true,false);
    }

    private void listProductsByCategory(boolean includeHeader, boolean includeDetail){
        aisleInventory.keySet().forEach(k ->{
            if(includeHeader) System.out.println("-------\n" + k + "\n--------");
            if(!includeDetail) {
                aisleInventory.get(k).keySet().forEach(System.out::println);
            }else{
                aisleInventory.get(k).values().forEach(System.out::println);
            }
        });
    }

    private void stockStore(){
        inventory = new HashMap<>();
        List<Product> products = new ArrayList<>(List.of(
                new Product("A100","apple","local",ProductCategory.PRODUCE),
                new Product("B100","banana","local",ProductCategory.PRODUCE),
                new Product("P100","pear","local",ProductCategory.PRODUCE),
                new Product("L103","lemon","local",ProductCategory.PRODUCE),
                new Product("M201","milk","farm",ProductCategory.DAIRY),
                new Product("Y001","yogurt","farm",ProductCategory.DAIRY),
                new Product("C333","cheese","farm",ProductCategory.DAIRY),
                new Product("R777","rice chex","Nabisco",ProductCategory.CEREAL),
                new Product("G111","granola","Nat Valley",ProductCategory.CEREAL),
                new Product("BB11","ground beef","butcher",ProductCategory.MEAT),
                new Product("CC11","chicken","butcher",ProductCategory.MEAT),
                new Product("BC11","bacon","butcher",ProductCategory.MEAT),
                new Product("BC77","coke","coca cola",ProductCategory.BEVERAGE),
                new Product("BC88","coffee","value",ProductCategory.BEVERAGE),
                new Product("BC99","tea","herbal",ProductCategory.BEVERAGE)
        ));

        products.forEach(p -> inventory.put(p.sku(),new InventoryItem(p,
                random.nextDouble(0, 1.25), 1000, 5)));
    }

    private void stockAisles(){
        aisleInventory = new EnumMap<>(ProductCategory.class);
        for(InventoryItem item : inventory.values()){
            ProductCategory aisle = item.getProduct().category();
            Map<String, InventoryItem> productMap = aisleInventory.get(aisle);
            if(productMap == null){
                productMap = new TreeMap<>();
            }
            productMap.put(item.getProduct().name(), item);
            aisleInventory.putIfAbsent(aisle,productMap);
        }
    }

    private void listInventory(){
        System.out.println("----------------------------------------");
        inventory.values().forEach(System.out::println);
    }
}
