package Chall2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Chall2 {

    public static void main(String[] args) {
        try {
            generateFile(Path.of("index.txt"), Path.of("public"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateFile(Path filename, Path path) throws IOException {

        Path target = Path.of(path+"/"+filename);

        if(Files.isDirectory(path)){

            try(BufferedWriter writer = Files.newBufferedWriter(target)){
                try(var children = Files.list(path)){
                    children.toList().forEach(
                            p ->{
                                try {
                                    writer.write(listDir(p));
                                    if(!Files.exists(Path.of(p+"/"+filename)) ){
                                        Chall2.generateFile(filename, p);
                                    }


                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                    );
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static String listDir(Path path){
        StringBuilder list = new StringBuilder();
        try (Stream<Path> paths = Files.find(path, Integer.MAX_VALUE,
                (p,attr) -> attr.isRegularFile() || attr.isDirectory()
        )) {
            paths
                    .forEach(s -> {
                        try {
                            list.append(s).append(" --> ").append(Files.getAttribute(s,"lastModifiedTime")).append("\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }catch (IOException e){
            e.printStackTrace();
        }
        return list.toString();
    }
}
