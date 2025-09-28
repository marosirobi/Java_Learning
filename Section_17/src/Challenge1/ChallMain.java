package Challenge1;

import streamsIntermediate.StreamInterMain;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ChallMain {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python MasterClass");
        Course jmc = new Course("JMC", "Java MasterClass");
//        Student tim = new Student("AU",2019,30,"M",
//                true, jmc, pymc);
//
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//
//        System.out.println(tim);

        var stream =Stream.generate(() -> Student.getRandomStudent(pymc,jmc))
                .limit(30);

        Student[] studs = Stream.generate(() -> Student.getRandomStudent(pymc,jmc))
                        .limit(1000)
                        .toArray(Student[]::new);

//        Arrays.asList(studs).forEach(System.out::println);

//        var male = Arrays.stream(studs)
//                .filter(i -> i.getGender().equals("M"))
//                .count();
//
//        var female = Arrays.stream(studs)
//                        .filter(i -> i.getGender().equals("F"))
//                                .count();

//        long[] ageRanges =
//                {       Arrays.stream(studs)
//                                .filter(i -> i.getAge() < 30)
//                                .count(),
//                        Arrays.stream(studs)
//                                .filter(i -> i.getAge() > 30 && i.getAge() < 60)
//                                .count(),
//                        Arrays.stream(studs)
//                                .filter(i -> i.getAge() > 60)
//                                .count(),
//        };

        long[] ageRanges = Arrays.stream(studs)
                        .collect(() -> new long[]{0L,0L,0L},
                                (arr,student) -> {
                                    int age = student.getAge();
                                    if(age < 30) arr[0]++;
                                    else if(age > 60) arr[2]++;
                                    else arr[1]++;
                                },
                                (arr1, arr2) -> {
                                    arr1[0] = arr2[0];
                                    arr1[1] = arr2[1];
                                    arr1[2] = arr2[2];
                                }
                        );


        for(String gender : List.of("F","M","U")){
            var genderFilter = Arrays.stream(studs)
                    .filter(s -> s.getGender().equals(gender));
            System.out.printf("%s gender count = %d%n",gender,genderFilter.count());
        }

        List<Predicate<Student>> list = List.of(
                s -> s.getAge() < 30,
                (Student s) -> s.getAge() >30 && s.getAge() < 60
        );
        long total = 0L;
        for(int i = 0; i < list.size(); i++){
            var ageMap = Arrays.stream(studs)
                    .filter(list.get(i));
            long cnt =ageMap.count();
            total += cnt;
            System.out.printf("number of students (%s) = %d%n",
                    i == 0 ? "under 30" : "between 30 and 60", cnt);
        }
        System.out.println("number of students (over 60) = " + (studs.length - total));

//        System.out.println("male = " + male);
//        System.out.println("female = " + female);
//        System.out.println("<30 =\t" + ageRanges[0]);
//        System.out.println("30-60 =\t" + ageRanges[1]);
//        System.out.println(">60 = \t" + ageRanges[2]);

        var ages = Arrays.stream(studs)
                .mapToInt(Student::getAgeEnrolled);

        System.out.println("agesResult = " + ages.summaryStatistics());

        var currentAges = Arrays.stream(studs)
                .mapToInt(Student::getAge);

        System.out.println("currentAges = " + currentAges.summaryStatistics());

        var countries = Arrays.stream(studs)
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .toList();
        System.out.println(countries);



        var activeLongTime = Arrays.stream(studs)
                .anyMatch(i -> (i.getAge() - i.getAgeEnrolled() >= 7) &&
                        (i.getMonthsSinceActive() < 12));

        System.out.println(activeLongTime);

        var studentsLongActive = Arrays.stream(studs)
                .filter(i -> (i.getAge() - i.getAgeEnrolled() >= 7) &&
                        (i.getMonthsSinceActive() < 12))
                .limit(5)
                .toList();
//                .toArray(Student[]::new);
//                .toArray(size -> new Student[size]);

        studentsLongActive.forEach(System.out::println);

        var longTermCount = Arrays.stream(studs)
                .filter(i -> (i.getAge() - i.getAgeEnrolled() >= 7) &&
                        (i.getMonthsSinceActive() < 12))
                .count();

        System.out.println(longTermCount);

        var learners = Arrays.stream(studs)
                .filter(i -> (i.getAge() - i.getAgeEnrolled() >= 7) &&
                        (i.getMonthsSinceActive() < 12))
                .limit(5)
                .collect(Collectors.toList());

        Collections.shuffle(learners);
    }
}
