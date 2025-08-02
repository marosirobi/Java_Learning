package model.lambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;


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

        int result = calculator((var a,var b) -> a+b,5,2);
        var result2 = calculator((a,b) -> a/b, 10.0,2.5);
        var result3 = calculator(
                (a,b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Ralph", "Kramden");

        var coords = Arrays.asList(
                new double[] {47.2160, -95.2348},
                new double[] {29.1566, -89.2495},
                new double[] {35.1556, -90.0659});

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double,Double> p1 = (lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n",lat,lng);

//        var firstPoint = coords.get(0);
//        processPoint(firstPoint[0],firstPoint[1],p1);

        System.out.println("-".repeat(10));
        coords.forEach(s -> processPoint(s[0],s[1],p1));

        System.out.println("-".repeat(10));
        coords.forEach(s -> processPoint(s[0],s[1],(lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n",lat,lng))
        );

        coords.forEach(s -> testCondition(s[0],s[1],(lat, lng) -> lat > lng));

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        System.out.println("-".repeat(10));
        list.forEach(s -> System.out.println(s));
        list.addAll(List.of("echo","easy","earnest"));
        System.out.println("-".repeat(10));
        list.forEach(s -> System.out.println(s));
        System.out.println("-".repeat(10));

        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){

        T result = function.apply(value1,value2);
        System.out.println("Result of operation: " +result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1,t2);
    }

    public static <T> boolean testCondition(T t1, T t2, BiPredicate<T,T> predicate){
        boolean result = predicate.test(t1,t2);
        System.out.println(result);
        return result;
    }
}
