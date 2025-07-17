package model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0,5,10,-50,50};
//        for(Integer i : others){
//            int value = five.compareTo(i);
//            System.out.printf("%d %s %d: compareTo=%d%n",five,value == 0 ? "==" : (value > 0 ? ">" : "<"),i, value );
//        }

        String banana = "banana";
        String[] fruit = {"apple", "orange", "banana", "BANANA", "pear"};
        for(String s : fruit){
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n",banana,val == 0 ? "==" : (val > 0 ? ">" : "<"),s, val );

        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        Student tim = new Student("Tim");
        Student[] students = {
                new Student("Zach"),
                new Student("Ann"),
                new Student("Tim")
        };

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        System.out.println("result = " + tim.compareTo(new Student("Tim")));

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students,gpaSorter.reversed());
        System.out.println(Arrays.toString(students));
    }
}

class StudentGPAComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static Random random = new Random();
    protected String name;

    private int id;
    protected double gpa;

    public Student(String name){
        this.name = name;
        id = LAST_ID++;
        gpa =random.nextDouble(1.0,4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id,name,gpa);
    }

    
    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
//    @Override
//    public int compareTo(Object o) {
//        Student other = (Student) o;
//        return name.compareTo(other.name);
//    }
}
