import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String... args) {
        int[] newArray = {0,1,2,3,4,5};
        //foreach
        for(int i:newArray){
            System.out.println(i);
        }
        System.out.println(Arrays.toString(newArray));
        Object objectVariable = newArray;
        if(objectVariable instanceof int[]){
            System.out.println("objectVariable is really an int array");
        }

        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        objectArray[2] = newArray;

        Arrays.sort(newArray);

        Random rand = new Random();
        int[] array2 = new int[10];
        System.out.println(Arrays.toString(array2));
        Arrays.fill(array2,5);
        System.out.println(Arrays.toString(array2));

        int[] array3 = Arrays.copyOf(array2,array2.length);
        System.out.println(Arrays.toString(array3));

        int[] array4 = Arrays.copyOf(array2,5);
        System.out.println(Arrays.toString(array4));

        int[] array5 = Arrays.copyOf(array2,15);
        System.out.println(Arrays.toString(array5));

        //reference objects


    }
}