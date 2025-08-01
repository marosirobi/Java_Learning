package model.nesting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(101,"Ralph",2015,"Target"),
                new StoreEmployee(105,"Carole",2021,"Walmart"),
                new StoreEmployee(121,"Jane",2013,"Macys"),
                new StoreEmployee(144,"Laura",2020,"Walmart"),
                new StoreEmployee(103,"Jim",2018,"Target")
        ));

        var c0 = new EmployeeComparator<StoreEmployee>();
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        var c2 = new StoreEmployee(). new StoreComparator<StoreEmployee>();

        class NameSort<T> implements Comparator<StoreEmployee>{
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        var c3 = new NameSort<StoreEmployee>();
        var c4 = new Comparator<StoreEmployee>(){
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);
        sortIt(storeEmployees, c4);
        sortIt(storeEmployees, new Comparator<StoreEmployee>(){
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public static <T> void sortIt(List<T> list,
                                  Comparator<? super T> comparator){
        System.out.println("sorting with comparator: " + comparator.toString());
        list.sort(comparator);
        for(var employee : list){
            System.out.println(employee);
        }
    }
}
