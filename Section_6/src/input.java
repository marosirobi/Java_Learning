import java.util.Scanner;

public class input {

    public static void main(String[] args) {
//        try{
//
//            System.out.println(getInputFromScanner(24));
//        }catch (NullPointerException e){
//
//            System.out.println(getInputFromConsole(24));
//        }
//        System.out.println();

        System.out.println(getInputFromConsole(24));
    }
    public static String getInputFromConsole(int currentYear){

        String name = System.console().readLine("Hi, what's your name? ");
        System.out.println("Hi " + name + ", thanks.");

        return "";
    }
    public static String getInputFromScanner(int currentYear){
        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner(new File("NameOfFileOnFileSystem"));
        System.out.print("Hi, what's your name? ");
        String name = sc.nextLine();
        System.out.println("Hi " + name + ", thanks.");

        return "";
    }
}
