package model.copyingClasses;

import java.util.Arrays;

record Person(String name, String dob, Person[] kids){

    public Person(Person p) {
        this(p.name,p.dob,
                p.kids == null ? null : Arrays.copyOf(p.kids,p.kids.length));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
}

public class CopyClassMain {

    public static void main(String[] args) {
        
        Person joe = new Person("Joe", "01/01/1961",null);
        Person jim = new Person("Jim", "01/01/1962",null);
        Person jack = new Person("Jack", "01/01/1963",
                new Person[]{joe, jim});
        Person jane = new Person("Jane", "01/01/1964",null);
        Person jill = new Person("Jill", "01/01/1965",
                new Person[]{joe,jim});

        Person[] persons = {joe, jim,jack,jane,jill};
//        Person[] personsCopy = Arrays.copyOf(persons, persons.length);
//        Person[] personsCopy = new Person[5];
        Person[] personsCopy = persons.clone();

//        Arrays.setAll(personsCopy, i -> new Person(persons[i]));

//        for(int i = 0; i < 5; i++){
//            Person current = persons[i];
//            var kids = current.kids() == null ? null :
//                    Arrays.copyOf(current.kids(), current.kids().length);
////            if(kids != null){
////                Person[] kidsCopy = new Person[kids.length];
////                for(int j = 0; j < kids.length; j++){
////                    kidsCopy[j] = new Person(kids[j].name(),kids[j].dob(),kids[j].kids());
////                }
////                kids = kidsCopy;
////            }
//            personsCopy[i] = new Person(current.name(),current.dob(),kids);
//        }
        var jillsKids = personsCopy[4].kids();
        jillsKids[1] = jane;

        for(int i = 0; i < 5; i++){
            if(persons[i] == personsCopy[i]){
                System.out.println("Equal References " + persons[i]);
            }
        }
        System.out.println(personsCopy[4]);
        System.out.println(persons[4]);
    }
}
