package model.setOperationsChallenge;

import java.io.FileNotFoundException;
import java.util.*;

public class TestingTasks {

    public static void main(String[] args) throws FileNotFoundException {
        String employee = "All";
        Set<Task> tasks = TaskData.getTask(employee);

        Comparator<Task> sort = Comparator.comparing(Task::getPriority);
        sortAndPrint(employee,tasks,sort);

        Set<Task> union = getUnion(List.of(TaskData.getTask("All"), TaskData.getTask("Bob"), TaskData.getTask("Ann"), TaskData.getTask("Carol")));
        Set<Task> intersect = getIntersect(TaskData.getTask("Bob"),TaskData.getTask("Ann"));
        Set<Task> difference = getDifference(TaskData.getTask("Carol"),TaskData.getTask("Ann"));
        sortAndPrint("Union of tasks", union);
        sortAndPrint("Intersect of two sets", intersect);
        sortAndPrint("difference of two sets", difference);

        Comparator<Task> priorityNatural = sort.thenComparing(Comparator.naturalOrder());
        sortAndPrint("sorted", union, priorityNatural);
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
        list.forEach(System.out::println);
    }

    public static Set<Task> getUnion(List<Set<Task>> sets){
        Set<Task> union = new HashSet<>();
        sets.forEach(union::addAll);
        return union;
    }

    public static Set<Task> getIntersect(Set<Task> A, Set<Task> B){
        Set<Task> intersectOfTwo = new HashSet<>(A);
        intersectOfTwo.retainAll(B);
        return intersectOfTwo;
    }

    public static Set<Task> getDifference(Set<Task> A, Set<Task> B){
        Set<Task> differenceOfTwo = new HashSet<>(A);
        differenceOfTwo.removeAll(B);
        return differenceOfTwo;
    }
}
