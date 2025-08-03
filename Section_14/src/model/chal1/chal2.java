package model.chal1;

import java.util.function.Function;
import java.util.function.Predicate;

public class chal2 {

    public static void main(String[] args) {

        var test = everySecondChar("aladar", (i) -> i % 2 == 1);
        System.out.println(test);

        Function<String,String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));
    }

    public static String everySecondChar(String source, Predicate<Integer> predicate){
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < source.length(); i++){
            if(predicate.test(i)){
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }
}
