import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    record Person(String first, String last){
        @Override
        public String toString() {
            return first + " " + last;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Main.Person("Charlie","Brown")
        ));
        //anonymous class
        var comparatorLastName = new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                if(!o1.last().equals(o2.last()))
                    return o1.last().compareTo(o2.last());
                else
                    return o1.first().compareTo(o2.first());
            }
        };

        people.sort((o1, o2) -> o1.last().compareTo(o2.last()));
        System.out.println(people);


        interface EnhanchedComparator<T> extends Comparator<T>{
            int secondLevel(T o1, T o2);
        }
        var comparatorMixed = new EnhanchedComparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.last().compareTo(o2.last());
                return (result == 0 ? secondLevel(o1,o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.first().compareTo(o2.first());
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);
    }
}