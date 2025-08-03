package model.chal1;
import java.util.function.UnaryOperator;

public class Chal3 {

    public static void main(String[] args) {

        UnaryOperator<String>  everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        var value = EverySecondCharacter(everySecondChar, "1234567890");
    }

    public static <T> T EverySecondCharacter(UnaryOperator<T> everySecondChar, T source){
        T result = everySecondChar.apply(source);
        System.out.println(result);
        return result;
    }

}
