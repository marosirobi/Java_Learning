package mathRandomProject;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathRandomProject {

    public static void main(String[] args) {

//        int maxMinusFive = Integer.MAX_VALUE - 5;
//        for(int j = 0, id = maxMinusFive; j < 10; id = Math.incrementExact(id),j++){
//            System.out.println(id);
//        }

        System.out.println(Math.abs(-50));
        System.out.println(Math.abs(Integer.MIN_VALUE));
//        System.out.println(Math.absExact(Integer.MIN_VALUE));
        System.out.println(Math.abs((long)Integer.MIN_VALUE));

        System.out.println("Max = " + Math.max(10,-10));
        System.out.println("Min = " + Math.min(10.0000002,10.001f));

        System.out.println("Round Down = " + Math.round(10.2));
        System.out.println("Round Up = " + Math.round(10.8));
        System.out.println("Round ? = " + Math.round(10.5));

        System.out.println("Floor = " + Math.floor(10.8));
        System.out.println("Ceil = " + Math.ceil(10.2));

        System.out.println("Square root of 100 = " + Math.sqrt(100));
        System.out.println("2 to the third power (2*2*2) = " + Math.pow(2,3));
        System.out.println("10 to the third power (10*10*10*10*10) = " + Math.pow(10,5));

        for(int i = 0; i < 10; i++)
            System.out.printf("%1$d = %1$c%n".formatted((int) (Math.random() * 26) + 65));

        System.out.println(IntStream
                .generate(() -> (int) (Math.random() * 26) + 65)
                .limit(1000)
                .summaryStatistics()
        );

        Random rand = new Random();
        for(int i = 0; i < 10; i++)
            System.out.printf("%1$d = %1$c%n", rand.nextInt(65,91));
        System.out.println("----------------------------------");

        for(int i = 0; i < 10; i++)
            System.out.printf("%1$d = %1$c%n",
                    rand.nextInt((int)'A',(int)'Z' + 1));

        System.out.println("----------------------------------");
        for(int i = 0; i < 10; i++)
            System.out.printf("%1$d%n", rand.nextInt(-10,11));

        System.out.println("----------------------------------");
        rand.ints(0,10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("----------------------------------");
        rand.ints(10,0,10)
                .forEach(System.out::println);

        System.out.println("----------------------------------");
        rand.ints(10)
                .forEach(System.out::println);

        long nanoTime = System.nanoTime();
        Random pseudoRandom = new Random(nanoTime);
        System.out.println("----------------------------------");
        pseudoRandom.ints(10,0,10)
                .forEach(s -> System.out.print(s+" "));

        Random notReallyRandom = new Random(nanoTime);
        System.out.println("\n----------------------------------");
        notReallyRandom.ints(10,0,10)
                .forEach(s -> System.out.print(s+" "));
    }


}

