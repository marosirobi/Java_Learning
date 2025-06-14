package model.arrays;

import java.util.Arrays;
import java.util.Random;

public class SearchingArrays {
    public static void main(String[] args) {
        String[] sArray = {"Able", "Jane", "Mark", "Ralph","David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));

        //binary seach only works on sorted arrays
        if(Arrays.binarySearch(sArray,"Mark") >= 0){
            System.out.println("Found");
        }

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5};

        if(Arrays.equals(s1,s2)){
            System.out.println("arrays are equal");
        }else{
            System.out.println("they are not equal");
        }
        //challenge 1.
        int[] reverseArray = createRandArray(10);

        System.out.println(Arrays.toString(reverseArray));
        reverseArray = reverseSort(reverseArray);
        System.out.println(Arrays.toString(reverseArray));

        int[] sortedArray = reverseSort(new int[]{1,432,43,22,3456,3,0});
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] createRandArray(int len){
        Random rand = new Random();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++){
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    public static int[] reverseSort(int[] arr){
        int[] reverseArray = Arrays.copyOf(arr,arr.length);
        boolean flag = true;
        int temp;

        while (flag){
            flag =false;
            for(int i = 0; i < reverseArray.length-1; i++){
                if(reverseArray[i] < reverseArray[i+1]){
                    temp = reverseArray[i];
                    reverseArray[i] = reverseArray[i+1];
                    reverseArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return reverseArray;
    }



}
