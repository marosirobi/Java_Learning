package model.enums;

import java.util.Random;

public class Enums {

    public static void main(String[] args) {

        // enum is a special data type that contains predefined constants
        DayOfTheWeek weekDay = DayOfTheWeek.TUES;
        System.out.println(weekDay);
        System.out.println(weekDay.name() + " " + weekDay.ordinal());

        for (int i = 0; i < 10; i++) {
            weekDay = getRandomDay();
            System.out.println(weekDay);
            switchDayOfWeek(weekDay);
        }

        for(Topping topping : Topping.values()){
            System.out.println(topping.name() + " : " + topping.getPrice());
        }




    }

    public static DayOfTheWeek getRandomDay(){
        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();

        return allDays[randomInteger];
    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay){

        int weekDayInteger = weekDay.ordinal() + 1;

        switch (weekDay){
            case WED -> System.out.println("Wednesday is Day " + weekDayInteger);
            case SAT -> System.out.println("Saturday is Day " + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) +
                    weekDay.name().substring(1).toLowerCase() +
                    "day is Day " + weekDayInteger);
        }
    }
}
