package model.chal1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Adam","Adolf","12/04/2012"),
                new Employee("Jim","Albert","12/04/2013"),
                new Employee("Peter","Small","12/04/2018"),
                new Employee("Cornel","Vargus","12/04/2022"),
                new Employee("Adam","Jones","12/03/2012"),
                new Employee("Tay","Trump","12/04/2015")
        ));


        printList(employees, "name");
        System.out.println();
        printList(employees,"year");

    }

    public static void printList(List<Employee> employees, String sortField){
        int currentYear = LocalDate.now().getYear();

        class LocalEmployee{
            Employee e1;
            int yearsWorked;
            String fullName;

            public LocalEmployee(Employee e1) {
                this.e1 = e1;
                yearsWorked = currentYear - Integer.parseInt(e1.hireDate().split("/")[2]);
                fullName = String.join(" ", e1.firstName(),e1.lastName());
            }

            @Override
            public String toString() {
                return "%s has been emplyed for %d years".formatted(fullName,yearsWorked);
            }
        }

        List<LocalEmployee> list = new ArrayList<>();
        for(Employee employee : employees){
            list.add(new LocalEmployee(employee));
        }

        var comparator = new Comparator<LocalEmployee>(){

            @Override
            public int compare(LocalEmployee o1, LocalEmployee o2) {
                if (sortField.equalsIgnoreCase("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        list.sort(comparator);

        for (LocalEmployee e : list){
            System.out.println(e);
        }
    }
}
