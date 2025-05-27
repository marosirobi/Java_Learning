import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //1.
        int myMaxIntTest = 2_147_483_647;
        System.out.println(myMaxIntTest);
        //2.
        System.out.println("Float value range is between " + Float.MIN_VALUE + " to " + Float.MAX_VALUE );
        System.out.println("Float value range is between " + Double.MIN_VALUE + " to " + Double.MAX_VALUE );
        //3.
        float myFloatValue = 5.25f;
        System.out.println(myFloatValue);
        float myOtherFloatValue = (float) 5.25;
        System.out.println(myOtherFloatValue);
        //challenge
        double pounds = 200, kgs = pounds * 0.45359237;
        System.out.println(pounds + " pounds in kgs is " + kgs + " kg");
        //4.
        double num = 3_000_000.3_4455_34_00d;
        System.out.println(num);
        //5.
        //unicode 'D'
        char myChar = '\u0044';
        System.out.println(myChar);
        char decimalChar = 68;
        System.out.println(decimalChar);
        //6.
        
    }
}