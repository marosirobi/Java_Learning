package model.exercise3;

import java.util.Arrays;

public class ReverseArray {

    private static void reverse(int[] array){
        System.out.println("Array = " + Arrays.toString(array));

        int maxIndex = array.length-1;
        for (int i = 0; i < array.length/2; i++){
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex--] = temp;
        }
        System.out.println("Reversed array = " + Arrays.toString(array));
    }
}
