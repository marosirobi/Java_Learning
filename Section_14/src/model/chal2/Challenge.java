package model.chal2;

import java.util.*;
import java.util.function.BiPredicate;

public class Challenge {

    private static Random random = new Random();


    public static void main(String[] args) {
        String[] names = {"Anna", "Jeff","Robert","Peter","Bob","Cornel"};
        List<String> lastNames = new ArrayList<>(Arrays.asList(names));

        List<String> newNames = new ArrayList<>(Arrays.asList(names));

        newNames.replaceAll( s -> s.toUpperCase());
        System.out.println(Arrays.toString(names));
        newNames.replaceAll( s -> s + " " + s.charAt(random.nextInt(0, s.length() )) + ".");
        System.out.println(Arrays.toString(names));
        newNames.replaceAll(s ->
            s + " " + getReversedName(s.split(" ")[0]));


        Arrays.asList(newNames).forEach(s -> System.out.println(s));

        BiPredicate<String,String> predicate = (t1,t2) ->{
            return t1.equals(t2);
        };

        newNames.removeIf(s-> predicate.test(s.split(" ")[0], s.split(" ")[2]));

        System.out.println("-".repeat(10));
        newNames.forEach(s -> System.out.println(s));
    }

//    public static String reverse(String name, int s){
//        StringBuilder reversed = new StringBuilder();
//        for(int i = name.length()-1; i >= 0; i--){
//            reversed.append(name.charAt(i));
//        }
//        return reversed.toString().toUpperCase();
//    }

    public static String getReversedName(String name){
        return new StringBuilder(name).reverse().toString().toUpperCase();
    }
}
