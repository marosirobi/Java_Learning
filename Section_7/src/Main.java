import ExerciseClasses.Person;
import ExerciseClasses.SimpleCalculator;

public class Main {
    public static void main(String[] args) {

//        Car car = new Car();
//        car.setColor("blue");
//        car.setMake("Mercedes");
//        car.describeCar();

//        SimpleCalculator calculator = new SimpleCalculator();
//        calculator.setFirstNumber(5.0);
//        calculator.setSecondNumber(4);
//        System.out.println("add = " + calculator.getAdditionResult());
//        System.out.println("subtract = " + calculator.getSubtractionResult());

        Person person = new Person();
        person.setFirstName("Ali");   // firstName is set to empty string
        person.setLastName("baba");    // lastName is set to empty string
        person.setAge(10);
        System.out.println("fullName = \t" + person.getFullName());
        System.out.println("teen = \t\t" + person.isTeen());
    }
}