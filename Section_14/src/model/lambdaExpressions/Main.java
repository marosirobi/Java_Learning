package model.lambdaExpressions;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha","bravo","charlie","delta"));
        for(String s : list){
            System.out.println(s);
        }

        System.out.println("-".repeat(10));

        list.forEach((var string) -> System.out.println(string));

        System.out.println("-".repeat(10));

        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });

    }
}
