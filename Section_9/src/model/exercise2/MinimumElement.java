package model.exercise2;

import java.util.Scanner;

public class MinimumElement {

    private static int readInteger(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in a length:");
        int len = sc.nextInt();
        sc.close();
        return len;
    }

    private static int[] readElements(int len){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
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
}
