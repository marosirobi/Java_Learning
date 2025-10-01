package Challenge1;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;

public class MainMapping {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python MasterClass",50);
        Course jmc = new Course("JMC", "Java MasterClass",100);
        Course cgj = new Course("CGJ", "Creating Games in Java");

        List<Student> students = IntStream
                .rangeClosed(1,5000)
                .mapToObj(s -> Student.getRandomStudent(jmc,pymc))
                .toList();

        var mappedStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getCountryCode));

        mappedStudents.forEach((k,v) -> System.out.println(k + " " + v.size()));

        System.out.println("-------------------------------------");

        int minAge = 25;
        var youngerSet = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        filtering(s -> s.getAge() <= minAge, toList())));

        youngerSet.forEach((k,v) -> System.out.println(k + " " + v.size()));

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        System.out.println("Experienced students = " + experienced.get(true).size());

        var expCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));
        System.out.println("Experienced students = " + expCount.get(true));

        var expCountActive = students.stream()
                .collect(partitioningBy(s -> s.getMonthsSinceActive() == 0 && s.hasProgrammingExperience(),
                        counting()));
        System.out.println("Experienced students = " + expCountActive.get(true));

        var multiLevel = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        groupingBy(Student::getGender)));

        multiLevel.forEach((key,value) ->{
            System.out.println(key);
            value.forEach((key1,value1) -> System.out.println("\t" + key1 + " " + value1.size()));
        });

        long studentBodyCount = experienced.values().stream()
                .mapToInt(l -> l.size())
                .sum();
        System.out.println("studentBodyCount = " +studentBodyCount);

        studentBodyCount = experienced.values().stream()
                .map(l -> l.stream()
                        .filter(s -> s.getMonthsSinceActive() <= 3)
                        .count())
                .mapToLong(l -> l)
                .sum();
        System.out.println("studentBodyCount = " +studentBodyCount);

        long count = experienced.values().stream()
                .flatMap(l -> l.stream())
                .filter( s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("count = " + count);

        count = multiLevel.values().stream()
                .flatMap(map -> map.values().stream()
                        .flatMap(l -> l.stream())
                )
                .filter( s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("count = " + count);

        count = multiLevel.values().stream()
                .flatMap(map -> map.values().stream())
                .flatMap(l -> l.stream())
                .filter( s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("count = " + count);
    }
}
