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

//        for (int i = 1; i <= 5; i++) {
//            LPAStudent s = new LPAStudent("S92300" + i,
//                    switch (i) {
//                        case 1 -> "Mary";
//                        case 2 -> "Carol";
//                        case 3 -> "Tim";
//                        case 4 -> "Harry";
//                        case 5 -> "Lisa";
//                        default -> "Anonymous";
//                    },
//                    "05/11/1985",
//                    "Java Masterclass");
//            //System.out.println(s);
//        }
//
//        Student pojoStudent = new Student("S923006", "Ann", "05/11/1985","Java Masterclass");
//        LPAStudent recordStudent = new LPAStudent("S923007", "Bill", "05/11/1985","Java Masterclass");
//
//        System.out.println(pojoStudent);
//        System.out.println(recordStudent);
//
//        pojoStudent.setClassList(pojoStudent.getClassList() + ", Java OCP Exam 829");
//        recordStudent.setClassList(recordStudent.classList() + ", Java OCP Exam 829");
//
//        System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());
//        System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());

        Animal animal = new Animal("big", "Pig", 80);
        doAnimalStuff(animal, "slow");
        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");

        Dog retriever = new Dog("Retriever", 65, "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");

        Dog wolf = new Dog("Wolf", 65, "Floppy", "Swimmer");
        doAnimalStuff(wolf, "slow");

        Fish goldie = new Fish("Goldfish" ,1,3,2);
        doAnimalStuff(goldie,"fast");

        String bulletIt = "Print a Bulleted List:\n" + "\t\u2022 First Point\n" + "\t\u2022 Sub Point";
        System.out.println(bulletIt);
        String textBlock = """
                Print Bulleted List:
                    \u2022 First Point
                    \u2022 Sub Point""";
        System.out.println(textBlock);

        int age =35;
        System.out.printf("Your age is %d%n",age);
        System.out.printf("Your age is %.2f%n",(float)age);

        for (int i = 1; i <= 100000; i *= 10) {
            System.out.printf("%6d %n",i);
        }

        String formattedString = String.format("Your age is %d",age);
        System.out.println(formattedString);

        formattedString = "Your age is at %d".formatted(age);
        System.out.println(formattedString);

        System.out.printf("index of age = %d %n",formattedString.indexOf('a'));
        System.out.printf("index of age = %d %n",formattedString.lastIndexOf('a'));

        System.out.printf("index of age = %d %n",formattedString.indexOf('a',4));
        System.out.printf("index of age = %d %n",formattedString.lastIndexOf('a',8));

        String helloWorld = "Hello World";
        String hwLower = helloWorld.toLowerCase();

        if(helloWorld.equals(hwLower)){
            System.out.println("Values match");
        }
        if(helloWorld.equalsIgnoreCase(hwLower)) {
            System.out.println("Values match ignoring case");
        }

        if(helloWorld.startsWith("Hello")){
            System.out.println("String starts with Hello");
        }
        if(helloWorld.endsWith("World")){
            System.out.println("String ends with World");
        }
        if(helloWorld.contains("World")){
            System.out.println("String contains World");
        }
        if(helloWorld.contentEquals("Hello World")){
            System.out.println("Values match");
        }
    }
    public static void doAnimalStuff(Animal animal, String speed){
        animal.move(speed);
        animal.makeNoise();
        System.out.println(animal);
        System.out.println();
    }
}