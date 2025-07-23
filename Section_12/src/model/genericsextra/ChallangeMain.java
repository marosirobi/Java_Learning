package model.genericsextra;

import model.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class ChallangeMain {

    public static void main(String[] args) {
        QueryList<LPAStudent> queryList = new QueryList<>();
        for(int i = 0; i < 25; i++){
            queryList.add(new LPAStudent());

        }
        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("\nMatches");
        var matches = queryList
                .getMatches("PercentComplete","35")
                .getMatches("Course","Python");
        printList(matches);

        matches.sort(new LPAStudentComparator());
        printList(matches);
    }

    public static void printList(List<?> list){
        for(var student : list){
            System.out.println(student);
        }
    }
}
