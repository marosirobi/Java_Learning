package model.chal1;

import java.util.Arrays;
import java.util.function.Consumer;

public class Chal1 {

    public static void main(String[] args) {

//        printTheParts((s) -> {
//            String[] ss = s.split(" ");
//            for(String part : ss)
//                System.out.println(part);
//        }, parts);

        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for(String part : parts)
                System.out.println(part);
        };

        printWordsLambda.accept("engine brakes pump");

        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };
        printWordsForEach.accept("engine brakes pump");

        Consumer<String> printWordsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };
        printWordsConcise.accept("engine brakes pump");



    }

//    public static void printTheParts(Consumer<String> c, String sentence){
//        c.accept(sentence);
//    }

}
