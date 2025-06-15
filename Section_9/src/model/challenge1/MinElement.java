package model.challenge1;

import java.util.Arrays;
import java.util.Scanner;

public class MinElement {
    public static void main(String[] args) {

        int[] array = getIntegers();
        System.out.println(Arrays.toString(array));

        int min = findMin(array);
        System.out.println(min);

//        int[] reverse = reverseArray(array);
//        System.out.println(Arrays.toString(reverse));
//        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(reverseCopyArray(array)));

    }

    public static int[] getIntegers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in integers with commas:");
        String input = sc.nextLine();
        String[] sInput = input.split(",");

        int[] arr = new int[sInput.length];

        for (int i = 0; i < sInput.length; i++) {
            arr[i] = Integer.parseInt(sInput[i].trim());
        }
        return arr;
    }

    private static int findMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int elem : arr){
            if(min > elem)
                min = elem;
        }
        return min;
    }

    private static int[] reverseArray(int[] arr){
        int end = arr.length-1;

        for (int i = 0; i < arr.length/2;i++){

            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
            end--;

        }

        return arr;
    }

    private static int[] reverseCopyArray(int[] arr){
        int[] reverse = new int[arr.length];
        int maxIndex = arr.length-1;
        for (int i : arr){
            reverse[maxIndex--] = i;
        }

        return reverse;
    }
}
