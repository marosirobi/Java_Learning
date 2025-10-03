package Challenge1;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class FinalChallenge {

    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python MasterClass",50);
        Course jmc = new Course("JMC", "Java MasterClass",100);
        Course cmc = new Course("CMC", "C# MasterClass",60);
        Course wmc = new Course("WMC", "Web MasterClass",70);

        int currentYear = LocalDate.now().getYear();
//        List<Student> students = IntStream
//                .rangeClosed(1,10000)
//                .mapToObj(s -> Student.getRandomStudent(jmc,pymc,cmc,wmc))
//                .filter(s -> s.getYearsSinceEnrolled() >= (currentYear - 4))
//                .toList();

        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc,pymc,cmc,wmc))
                .filter(s -> s.getYearEnrolled() >= (currentYear - 4))
                .limit(10000)
                .toList();

        System.out.println(students
                .stream()
                .mapToInt(Student::getYearEnrolled)
                .summaryStatistics());

        students.subList(0,10).forEach(System.out::println);

        System.out.println(students
                .stream()
                .mapToInt(s -> s.getEngagementMap().size())
                .summaryStatistics());

        var mappedActivity = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        counting()));

        mappedActivity.forEach((k,v) -> System.out.println(k +  " " + v));

        var classCounts = students.stream()
                .collect(groupingBy(s -> s.getEngagementMap().size(),
                        counting()));

        classCounts.forEach((k,v) -> System.out.println(k +  " " + v));

        var percentages = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        summarizingDouble(CourseEngagement::getPercentComplete)));

        percentages.forEach((k,v) -> System.out.println(k +  " " + v));

        var yearMap = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        groupingBy(CourseEngagement::getLastActivityYear,
                                counting())));
        System.out.println();
        yearMap.forEach((k,v) -> System.out.println(k +  " " + v));
        System.out.println();

        students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getEnrollmentYear,
                        groupingBy(CourseEngagement::getCourseCode,
                        counting())))
                .forEach((k,v) -> System.out.println(k + " " + v));
    }
}
