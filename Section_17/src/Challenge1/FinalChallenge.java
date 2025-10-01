package Challenge1;

import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.*;

public class FinalChallenge {

    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python MasterClass",50);
        Course jmc = new Course("JMC", "Java MasterClass",100);
        Course cmc = new Course("CMC", "C# MasterClass",60);
        Course wmc = new Course("WMC", "Web MasterClass",70);
        List<Student> students = IntStream
                .rangeClosed(1,10000)
                .mapToObj(s -> Student.getRandomStudent(jmc,pymc,cmc,wmc))
                .filter(s -> s.getYearsSinceEnrolled() <= 4)
                .toList();

        var groupedByCourse = students.stream()
                .collect(groupingBy(Student::getEngagementMap));

    }
}
