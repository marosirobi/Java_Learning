package Challenge1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainChallenge {
    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python MasterClass",50);
        Course jmc = new Course("JMC", "Java MasterClass",100);
        Course cgj = new Course("CGJ", "Creating Games in Java");

        List<Student> students = IntStream
                .rangeClosed(1,5000)
                .mapToObj(s -> Student.getRandomStudent(jmc,pymc))
                .toList();

        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
                .reduce(0, Double::sum);
//                .sum();

        double avePercent = totalPercent / students.size();

        System.out.println(avePercent);

        Comparator<Student> longTermStudent = Comparator.comparing(Student::getYearEnrolled);
        List<Student> betterStudents = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") > (int) avePercent * 1.25)
                .sorted(longTermStudent)
                .limit(10)
                .toList();

        betterStudents.forEach(s ->{
            s.addCourse(cgj);
            System.out.print(s.getStudentId() + " ");
        });
        System.out.println();


        Comparator<Student> uniqueSorted = longTermStudent.thenComparing(Student::getStudentId);
        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") > (int) avePercent * 1.25)
                .sorted(longTermStudent)
                .limit(10)
//                .toList()
//                .collect(Collectors.toList())
//                .collect(Collectors.toSet())
                .collect(() -> new TreeSet<>(uniqueSorted),
                        TreeSet::add,
                        TreeSet::addAll)
                .forEach(s ->{
                    s.addCourse(cgj);
                    System.out.print(s.getStudentId() + " ");
                });
        System.out.println();
    }
}
