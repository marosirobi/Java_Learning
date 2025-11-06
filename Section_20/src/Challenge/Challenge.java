package Challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Challenge {

    public static void main(String[] args) {

        Path path = Path.of("file.txt");

        try{
//            Map<String, Integer> list = new TreeMap<>();
//            Pattern longWords = Pattern.compile("[a-zA-Z]{6,}");
//            Files.readAllLines(path)
//                    .forEach(s -> {
//                        for(var word : s.split("[ ,!.?-]+")){
//                            Matcher m = longWords.matcher(word.toLowerCase());
//                            if(m.matches()){
//                                list.merge(word, 1, (o, n) -> o += n);
//
//                            }
//
//                        }
//                    });
//            list.entrySet().stream()
//                            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
//                    .limit(10)
//                    .forEach(System.out::println);
//
//            try(var resultStream = Files.lines(path)){
//                var results = resultStream
//                        .map( s -> s.split(" "))
////                        .filter(Matcher::matches)
//                        .toArray(String[][]::new);
//
//                System.out.println(Arrays.deepToString(results));
//            }

            try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
//                System.out.printf("%,d lines in file%n",br.lines().count());

                Pattern p = Pattern.compile("\\p{javaWhitespace}+");
//                System.out.printf("%,d words in file%n",br.lines()
////                   .flatMap(p::splitAsStream)
//                                .flatMap(l -> Arrays.stream(l.split(p.toString())))
//                        .count()
//                );

//                System.out.printf("%,d words in file%n",br.lines()
//                        .mapToLong(l -> l.split(p.toString()).length)
//                        .sum()
//                );

                List<String> excluded = List.of(
                        "Britain",
                        "Creator",
                        "history",
                        "these"
                );

                var result = br.lines()
                        .flatMap(p::splitAsStream)
                        .map(w -> w.replaceAll("\\p{Punct}", ""))
                        .filter(w -> w.length() > 4)
                        .map(String::toLowerCase)
                        .filter(w -> !excluded.contains(w))
                        .collect(Collectors.groupingBy(w -> w,Collectors.counting()));

                result.entrySet().stream()
                        .sorted(Comparator.comparing(Map.Entry::getValue,
                                Comparator.reverseOrder()))
                        .limit(10)
                        .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + " times"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-------------------------------------");
        String input = null;
        try {
            input = Files.readString(Path.of("file.txt"));
            input = input.replaceAll("\\p{Punct}", "");

            Pattern p = Pattern.compile("\\w{5,}+");
            Matcher m = p.matcher(input);
            Map<String, Long> results = new HashMap<>();
            while(m.find()){
                String word = m.group().toLowerCase();
//                if(word.length() > 4){
                    results.merge(word, 1L, (o, n) -> o += n);
//                }
            }

            var sortedEntries = new ArrayList<>(results.entrySet());
            sortedEntries.sort(Comparator.comparing(
                    Map.Entry::getValue,
                    Comparator.reverseOrder()));

            for(int i = 0; i < Math.min(10, sortedEntries.size()); i++){
                var entry = sortedEntries.get(i);
                System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
