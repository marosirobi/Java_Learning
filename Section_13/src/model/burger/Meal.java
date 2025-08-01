package model.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private double price = 5.0;
    private Item drink,side;
    private Burger burger;
    private double conversionRate;

    public Meal(){
        this(1);
    }

    public Meal(double conversionRate){
        burger = new Burger("regular");
        drink = new Item("coke","drink",1.5);
        System.out.println(drink.name);
        side = new Item("fries","side",2.0);
        this.conversionRate = conversionRate;
    }

    public double getTotal(){
        double total = burger.getPrice() + side.price + drink.price;
        return Item.getPrice(total,conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger,drink,side,"Total Due: ",getTotal());
    }

    public void addToppings(String... selectedToppings){
        burger.addToppings(selectedToppings);
    }

    private class Item{
        private String name,type;
        private double price;

        public Item(String name, String type) {
            this(name,type,type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type,name,getPrice(price,conversionRate));
        }

        private static double getPrice(double price, double rate){
            return price * rate;
        }
    }

    private class Burger extends Item{

        enum Extra{
            AVOCADO,BACON,CHEESE,KETCHUP,MAYO,MUSTARD,PICKLES;
            private double getPrice(){
                return switch (this){
                    case AVOCADO -> 1.0;
                    case BACON, CHEESE -> 1.5;
                    default -> 0;
                };
            }
        }

        private List<Item> toppings = new ArrayList<>();

        public Burger(String name) {
            super(name, "burger", 5.0);
        }

        public double getPrice(){
            double total = super.price;
            for(Item topping : toppings){
                total += topping.price;
            }
            return total;
        }

        private void addToppings(String...selectedToppings){
            for(String selectedTopping : selectedToppings){
                try{
                    Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
                    toppings.add(new Item(topping.name(),"TOPPING",topping.getPrice()));
                }
                catch (IllegalArgumentException ex){
                    System.out.println("The topping doesnt exists: " + selectedTopping);
                    System.out.println();
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder itemized = new StringBuilder(super.toString());
            for(Item topping : toppings){
                itemized.append("\n");
                itemized.append(topping);
            }
            return itemized.toString();
        }

        public Burger(String name, String type, double price, List<Item> toppings) {
            super(name, type, price);
            this.toppings = toppings;
            for(var topping : toppings){
                price += topping.price;
            }
        }


    }
}
