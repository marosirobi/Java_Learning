package model.nesting;

import java.util.ArrayList;
import java.util.Comparator;
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

        System.out.println("\nStore Members");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(101,"Ralph",2015,"Target"),
                new StoreEmployee(105,"Carole",2021,"Walmart"),
                new StoreEmployee(121,"Jane",2013,"Macys"),
                new StoreEmployee(144,"Laura",2020,"Walmart"),
                new StoreEmployee(103,"Jim",2018,"Target")
        ));
        //inner class initialization
        var comp = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comp);
        printList(storeEmployees);

        System.out.println("With Pig Latin Names");
        addPigLatinName(storeEmployees);
    }

    public static void printList(List<? extends Employee> list){
        for(var item : list){
            System.out.println(item);
        }
    }

    public static void addPigLatinName(List<? extends StoreEmployee> list){

        final String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{
            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for(var employee : list){
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin,employee));
        }
        newList.sort(null);
        for(var dEmployee : newList){
            System.out.println("%-10s".formatted(dEmployee.originalInstance.getName())+ " " + dEmployee.pigLatinName);
        }
    }
}
