package model.genericsextra;

import model.util.QueryList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < studentCount; i++){
            students.add(new Student());
        }

        printList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for(int i = 0; i < studentCount; i++){
            lpaStudents.add(new LPAStudent());
        }

        printList(lpaStudents);

        testList(new ArrayList<String>(List.of("Able","Barry","Charlie")));
        testList(new ArrayList<Integer>(List.of(1,2,3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches(
                "Course","Python");
        printList(matches);

        var students2021 = QueryList.getMatches(lpaStudents,"YearStarted", "2021");
        printList(students2021);

//        QueryList<Employee> employeeList = new QueryList<>();
    }

    public static void printList(List<? extends Student> students){

        for(var student : students){
            System.out.println(student);
        }
        System.out.println();
    }

    public static void testList(List<?> list){
        for(var element : list){
            if(element instanceof String s){
                System.out.println("String: " + s.toUpperCase());
            }else if(element instanceof Integer s){
                System.out.println("Integer: " + s.floatValue());
            }
    }

//    public static void testList(List<String> list){
//        for(var element : list){
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list){
//        for(var element : list){
//            System.out.println("Integer: " + element.floatValue());
//        }
    }
//    public static <T extends Student> void printList(List<T> students){
//        for(var student : students){
//            System.out.println(student.getYearStarted() + " " + student);
//        }
//        System.out.println();
//    }
}
