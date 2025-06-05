import ExerciseClasses.Person;
import ExerciseClasses.SimpleCalculator;

public class Main {
    public static void main(String[] args) {

//        Car car = new Car("Tesla","Model Y","Red",5,true);
//        Car car = new Car();
//        Car car = new Car("Mercedes","SLS");
//        System.out.println(car);

//        SimpleCalculator calculator = new SimpleCalculator();
//        calculator.setFirstNumber(5.0);
//        calculator.setSecondNumber(4);
//        System.out.println("add = " + calculator.getAdditionResult());
//        System.out.println("subtract = " + calculator.getSubtractionResult());

//        Person person = new Person();
//        person.setFirstName("Ali");   // firstName is set to empty string
//        person.setLastName("baba");    // lastName is set to empty string
//        person.setAge(10);
//        System.out.println("fullName = \t" + person.getFullName());
//        System.out.println("teen = \t\t" + person.isTeen());

        for (int i = 1; i <= 5; i++) {
            LPAStudent s = new LPAStudent("S92300" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        case 5 -> "Lisa";
                        default -> "Anonymous";
                    },
                    "05/11/1985",
                    "Java Masterclass");
            //System.out.println(s);
        }

        Student pojoStudent = new Student("S923006", "Ann", "05/11/1985","Java Masterclass");
        LPAStudent recordStudent = new LPAStudent("S923007", "Bill", "05/11/1985","Java Masterclass");

        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        pojoStudent.setClassList(pojoStudent.getClassList() + ", Java OCP Exam 829");
//        recordStudent.setClassList(recordStudent.classList() + ", Java OCP Exam 829");

        System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());


    }
}