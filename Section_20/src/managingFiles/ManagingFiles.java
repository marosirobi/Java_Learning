package managingFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ManagingFiles {

    public static void main(String[] args) {

//        File oldFile = new File("students.json");
//        File newFile = new File("students.json");
//        if(oldFile.exists()){
//            oldFile.renameTo(newFile);
//            System.out.println("File renamed successfully");
//        }else{
//            System.out.println("File does not exist");
//        }
//
//        Path oldPath = Path.of("students.json");
//        Path newPath = Path.of("files/students.json");
//
//        try{
//            Files.createDirectories(newPath.subpath(0, newPath.getNameCount() - 1));
//            Files.move(oldPath, newPath);
//            System.out.println("Path renamed successfully");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Path fileDir = Path.of("files");
        Path resourceDir = Path.of("resources");
        try{
            Files.copy(fileDir, resourceDir);
            System.out.println("Directory copied to " + resourceDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
