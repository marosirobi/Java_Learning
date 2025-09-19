package streamChallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Bingo {

    private static int COUNTER = 1;

    public static void main(String[] args) {
        int i = 1;

        Stream<String> concatedStream = Stream.empty();
//        for(char c : "BINGO".toCharArray()){
//            var stream = Stream.iterate(i, n -> n + 1)
//                    .map(s -> c + "" + s)
//                    .limit(15);
//            concatedStream = Stream.concat(concatedStream,stream);
//            i = i + 15;
//        }
//
//        concatedStream.forEach(System.out::println);

        var stream1 = Stream.iterate(i, n -> n+1)
                .map(s -> "B" + s)
                .limit(15);

        i += 15;
        int next = i +15;
        var stream2 = Stream.iterate(i, n -> n < next, n -> n+1)
                .map(s -> "I" + s);

        i += 15;
        var stream3 = IntStream.range(i, i +15)
                .mapToObj(s -> "N" + s);

        i += 15;
        String[] strings = new String[15];
        int j = i;
        Arrays.setAll(strings, s -> "G" + (j+s));
        var stream4 = Arrays.stream(strings);

        var stream5 = Stream.of("O61","O62","O63","O64","O65","O66","O67",
                "O68","O69","O70","O71","O72","O73","O74","O75");

        for (Stream stream : Arrays.asList(stream1,stream2,stream3,stream4,stream5)) {

           concatedStream = Stream.concat(concatedStream, stream);
        }
        concatedStream.forEach(System.out::println);

        var streamA = Stream.generate(Bingo::getCounter)
                .limit(15)
                .map(s -> "A" + (s + j));

        System.out.println("-------------");
        int rSeed = 61;

        Stream.generate(() -> new Random().nextInt(rSeed , rSeed+15))
                .distinct()
                .limit(15)
                .map(s -> "O"+s)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    private static int getCounter() {
        return COUNTER++;
    }
}
