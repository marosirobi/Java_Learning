package fileExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExceptionsMain {

    public static void main(String[] args) {

        System.out.println("Current Working Directory (cwd) = " +
                new File("").getAbsolutePath());
        String filename = "files/testing.csv";


        File file = new File(new File("").getAbsolutePath() ,filename);
        System.out.println(file.getAbsolutePath());
        if(!file.exists()){
            System.out.println("File doesnt exists");
            return;
        }
        System.out.println("File exists");

        for(File f : File.listRoots()){
            System.out.println(f);
        }

        Path path = Paths.get("files/testing.csv");
        System.out.println(file.getAbsolutePath());
        if(!Files.exists(path)){
            System.out.println("2. File doesnt exists");
            return;
        }
        System.out.println("2. File exists");
    }

    private static void testFile(String filename){

        Path path = Paths.get(filename);
        FileReader reader = null;

        try {
            reader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Logging something");
        }

        System.out.println("File exists");
    }

    private static void testFile2(String filename){

        try (FileReader reader = new FileReader(filename)) {

        } catch (FileNotFoundException e) {
            System.out.println("File '" + filename + "' doesnt exists");
            throw new RuntimeException(e);
        } catch (NullPointerException | IllegalArgumentException badData) {
            System.out.println("User has added bad data " + badData.getMessage());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            System.out.println("Something unrelated and unexpected happened");
        }finally{
            System.out.println("just to log something here...");
        }
        System.out.println("file exists");
    }
}
