package model.chal3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class LambdaChallenge {

    private static Random rand = new Random();

    private record Person(String first){

        public String last(String s){
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }


    public static void main(String[] args) {

        String[] names = {"Peter","Bob","Anna","Cornel","Alex"};

        Person Tim = new Person("Tim");

        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toLowerCase,
                s -> s = s + " " + addMiddle(s.charAt(0), s.charAt(s.length()-1)) + ".",
                s -> s += " " + reversedName(s, 0, s.indexOf(" ")),
                LambdaChallenge::reversedName,
                String::new,
//                s -> new String("hey " + s),
                String::valueOf,
                Tim::last,
                (new Person("MARY"))::last
        ));
        transformFunctions(names, list);
    }

    public static void transformFunctions(String[] names, List<UnaryOperator<String>> funcList){

        List<String> backedNames = Arrays.asList(names);
        for(var function : funcList){
            backedNames.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }

    }

    private static char addMiddle(char startChar,char endChar){
        return (char)rand.nextInt((int) startChar,(int) endChar + 1);
    }

    private static String reversedName(String name){
        return reversedName(name, 0, name.length());
    }

    private static String reversedName(String name, int start, int end){
        return new StringBuilder(name.substring(start,end)).reverse().toString();
    }
}
