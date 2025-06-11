import model.challenge1.SmartKitchen;
import model.challenge2.Printer;
//import model.challenge3.Car;
import model.challenge4.MealOrder;
import model.exercise3.Car;
import model.challenge3.GasPoweredCar;
import model.encapsulation.EnhancedPlayer;
import model.encapsulation.Player;
import model.exercise1.*;
import model.exercise3.Mitsubishi;
import model.polymorphism.Adventure;
import model.polymorphism.Comedy;
import model.polymorphism.Movie;
import model.polymorphism.Scifi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        SmartKitchen kitchen = new SmartKitchen();
//
//        kitchen.setKitchenState(true,false,true);
//        kitchen.doKitchenWork();
//
//        // bad example -- no encapsulation
//        System.out.println("\nbad example:");
//        Player player = new Player();
//        player.name = "Tim";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Reamining health = " + player.getHealth());
//        player.health = 200;
//        player.loseHealth(damage);
//        System.out.println("Reamining health = " + player.getHealth());
//
//        System.out.println("\nEnhanced player:");
//        EnhancedPlayer player2 = new EnhancedPlayer("Tim");
//
//        player2.loseHealth(damage);
//        System.out.println("Reamining health = " + player2.getHealth());
//        player2.loseHealth(damage);
//        System.out.println("Reamining health = " + player2.getHealth());

//        Printer printer = new Printer(50, false);
//        System.out.println("initial page count = " + printer.getPagesPrinted());
//
//        int pagesPrinted = printer.printPages(5);
//        System.out.printf("Current Job Pages: %d, Printer Total: %d %n",pagesPrinted,printer.getPagesPrinted());
//
//        pagesPrinted = printer.printPages(10);
//        System.out.printf("Current Job Pages: %d, Printer Total: %d %n",pagesPrinted,printer.getPagesPrinted());

        // polymorphism

//        Scanner sc = new Scanner(System.in);
//        String inputType = sc.nextLine();
//        String inputTitle = sc.nextLine();
//        Movie movie = Movie.getMovie(inputType,inputTitle);
//        movie.watchMovie();

//        Object comedy = Movie.getMovie("C","Airplane");
//        Comedy comedyMovie = (Comedy) comedy;
//        comedyMovie.watchComedy();
//
//        var airplane = Movie.getMovie("C","Airplane");
//        airplane.watchMovie();
//
//        var plane = new Comedy("Airplane");
//        plane.watchComedy();
//
//        Object unknownObject = Movie.getMovie("C","Airplane");
//        if(unknownObject.getClass().getSimpleName() == "Comedy"){
//            Comedy c = (Comedy) unknownObject;
//            c.watchComedy();
//        }else if( unknownObject instanceof Adventure){
//            ((Adventure) unknownObject).watchAdventure();
//        }else if( unknownObject instanceof Scifi sci){
//            sci.watchScifi();
//        }
//        Car car = new Car("2022 Blue Ferrari 296 GTS");
//        runRace(car);
//
//        System.out.println();
//        Car ferrari = new GasPoweredCar("2022 Blue Ferrari 296 GTS", 15.4,6);
//        runRace(ferrari);
//
//        Car car = new Car(8, "Base car");
//        System.out.println(car.startEngine());
//        System.out.println(car.accelerate());
//        System.out.println(car.brake());
//
//        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
//        System.out.println(mitsubishi.startEngine());
//        System.out.println(mitsubishi.accelerate());
//        System.out.println(mitsubishi.brake());

//        MealOrder regularMeal = new MealOrder();
//        regularMeal.addBurgerToppings("BACON","CHEESE","MAYO");
//        regularMeal.setDrinkSize("LARGE");
//        regularMeal.printItemizedList();

//        MealOrder secondMeal = new MealOrder("turkey","7-up","chili");
//        secondMeal.addBurgerToppings("LETTUCE","CHEESE","MAYO");
//        secondMeal.setDrinkSize("SMALL");
//        secondMeal.printItemizedList();

        MealOrder deluxeMeal = new MealOrder("deluxe","7-up","chili");
        deluxeMeal.addBurgerToppings("LETTUCE","CHEESE","MAYO","AVOCADO","BACON");
        deluxeMeal.setDrinkSize("SMALL");
        deluxeMeal.printItemizedList();
    }

//    public static void runRace(Car car){
//        car.startEngine();
//        car.drive();
//    }
}