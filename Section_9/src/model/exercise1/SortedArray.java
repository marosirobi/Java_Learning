package model.exercise1;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = getIntegers(5) ;
        printArray(arr);
        System.out.println();
        arr = sortIntegers(arr) ;
        printArray(arr);
    }

    public static int[] getIntegers(int len){
        int[] arr = new int[len];
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in " + len + " integers");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println("Element " + i + " contents " + arr[i]);
        }
    }

    public static int[] sortIntegers(int[] arr){

        int[] sortedArray = Arrays.copyOf(arr,arr.length);
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for (int i = 0; i < sortedArray.length-1; i++) {
                if(sortedArray[i] < sortedArray[i + 1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }

        return sortedArray;
    }
}
