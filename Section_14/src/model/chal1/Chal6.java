package model.chal1;

import java.util.function.Supplier;

public class Chal6 {

    public static void main(String[] args) {

        //supplier doesnt have any arguments
//        Supplier<String> java = () -> {
//            return "I love Java";
//        };
        Supplier<String> java = () -> "I love Java";

        String iLoveJava = java.get();
        System.out.println(iLoveJava);
    }


}
