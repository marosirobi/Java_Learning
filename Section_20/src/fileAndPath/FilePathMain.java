package fileAndPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilePathMain {

    public static void main(String[] args) {

//        useFile("testfile.txt");
        usePath("files/pathfile.txt");
    }

    private static void useFile(String filename){

        File file = new File(filename);
        boolean fileExists = file.exists();

        System.out.printf("File '%s' %s%n",filename, fileExists ? "exists." : "doesnt exist.");

        if(fileExists){
            System.out.println("Deleting File: " + filename);
            fileExists = !file.delete();
        }

        if(!fileExists){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
            System.out.println("Created File: " + filename);
            if(file.canWrite()){
                System.out.println("Would write to file here");
            }
        }
    }

    private static void usePath(String filename){

        Path path = Path.of(filename);
        boolean fileExists = Files.exists(path);

        System.out.printf("File '%s' %s%n",filename, fileExists ? "exists." : "doesnt exist.");

        if(fileExists){
            System.out.println("Deleting File: " + filename);
            try {
                Files.delete(path);
                fileExists = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!fileExists){
            try {
                Files.createFile(path);
                if(Files.isWritable(path)){
                    Files.writeString(path, """
                        Here is some data,
                        For my File,
                        just to prove,
                        Using the files class and path are better!
                        """);
                }
                System.out.println("And i can read too");
                System.out.println("----------------------");
                Files.readAllLines(path).forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
            System.out.println("Created File: " + filename);

        }
    }
}
