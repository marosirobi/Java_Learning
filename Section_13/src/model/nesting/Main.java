package model.nesting;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(101,"Ralph",2015),
                new Employee(105,"Carole",2021),
                new Employee(121,"Jane",2013),
                new Employee(144,"Laura",2020),
                new Employee(103,"Jim",2018)
        ));

//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);
        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
        printList(employees);
    }

    public static void printList(List<? extends Employee> list){
        for(var item : list){
            System.out.println(item);
        }
    }
}
