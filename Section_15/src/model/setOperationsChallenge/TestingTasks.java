package model.setOperationsChallenge;

import java.io.FileNotFoundException;
import java.util.*;

public class TestingTasks {

    public static void main(String[] args) throws FileNotFoundException {
        String employee = "Ann";
        Set<Task> tasks = TaskData.getTask(employee);

        Comparator<Task> sort = Comparator.comparing(Task::getPriority);
        sortAndPrint(employee,tasks,sort);
    }
    public static void sortAndPrint(String header, Collection<Task> tasks){
        sortAndPrint(header,tasks,null);
    }

    public static void sortAndPrint(String header, Collection<Task> tasks, Comparator<Task> sorter){

        System.out.println("-".repeat(80));
        System.out.println(header);
        System.out.println("-".repeat(80));
        List<Task> list = new ArrayList<>(tasks);
        list.sort(sorter);
        tasks.forEach(System.out::println);
    }
}
