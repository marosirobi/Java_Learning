package model.methodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld{
    private static int last_id = 1;
    private int id;
    public PlainOld(){
        id = last_id++;
        System.out.println("creating PlainOld Object: id = " + id);

    }
}


public class MethodReferences {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "Anna", "Bob", "Chuck", "Dave"
        ));

        list.forEach(System.out::println);

        calculator(Integer::sum, 1,3);
        calculator(Double::sum, 2.5,4.7);

        Supplier<PlainOld> reference = PlainOld::new;

        PlainOld newPojo = reference.get();

        System.out.println("getting array:");
        PlainOld[] pojo1 = seedArray(PlainOld::new,10);

        //concat is an instance method and not a static method
        calculator(String::concat, "Hello ", "World");

        BinaryOperator<String> b1 = String::concat;
        BiFunction<String,String,String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Hello ", "World"));
        System.out.println(b2.apply("Hello ", "World"));
        System.out.println(u1.apply("Hello "));

        String result = "Hello".transform(u1);
        System.out.println("Result = " + result);

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);

        Function<String,Boolean> f0 = String::isEmpty;
        boolean resutlBoolean = result.transform(f0);
        System.out.println("Result = " + resutlBoolean);
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1,value2);
        System.out.println("Result of the operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}
