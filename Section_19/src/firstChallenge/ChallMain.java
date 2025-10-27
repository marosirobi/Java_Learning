package firstChallenge;

import java.util.Scanner;

public class ChallMain {

    public static void main(String[] args) {

        // 1. challenge
        String line = "Hello, World!";
        Scanner sc = new Scanner(System.in);
//        System.out.println(line.matches(sc.nextLine()));
        // 2. challenge
//        String[] expressions = {
//                "The bike is red.",
//                "I am a new student.",
//                "hello world.",
//                "How are you?"
//        };
//
//        for(String expr : expressions){
//            System.out.println(expr + " -> " + expr.matches("^[A-Z].*\\."));
//
//        }
        // 3. challenge
        String[] expressions = {
                "The bike is red, and has a flat tire.",
                "I love being a new L.P.A student!",
                "Hello, friends and family: Welcome!",
                "How are you, Mary?"
        };

        for(String expr : expressions){
            System.out.println(expr + " -> " + expr.matches("^[A-Z].+[.!?]$"));

        }


    }
}
