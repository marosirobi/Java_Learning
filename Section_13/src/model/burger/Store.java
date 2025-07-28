package model.burger;

public class Store {

    public static void main(String[] args) {
        Meal regularMeal = new Meal();

        regularMeal.addToppings("AVOCADO","MAYO","CHEESE");

        System.out.println(regularMeal);

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);


    }
}
