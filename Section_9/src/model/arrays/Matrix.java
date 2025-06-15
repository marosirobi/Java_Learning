package model.arrays;

import java.util.Arrays;

public class Matrix {

    public static void main(String[] args) {

        int[][] arr = new int[4][4];
        for (int[] outer:arr){
            System.out.println(Arrays.toString(outer));
        }
        for (int i = 0; i < arr.length; i++){
            var innerArray = arr[i];
            for (int j = 0; j < innerArray.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (var outer : arr){
            for (var elem : outer){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(Arrays.deepToString(arr));

        Object[] anyArray = new Object[4];
        System.out.println(Arrays.toString(anyArray));

        anyArray[0] = new String[] {"dddd","as","xdd"};
        anyArray[1] = new String[] {"dddd","as","xdd"};
        anyArray[2] = new String[][] {
                {"dddd","as","xdd"},
                {"dddd","as","xdd","1"},
                {"dddd","as","xdd","r","e"}
        };
        anyArray[3] = new int[2][2][2];

        System.out.println(Arrays.deepToString(anyArray));
        System.out.println("-".repeat(30));

        for(Object elem : anyArray){
            System.out.println("Element type = " + elem.getClass().getSimpleName());
            System.out.println("Element toString() = " + elem);
            System.out.println(Arrays.deepToString( (Object[]) elem) );
            System.out.println();
        }
    }
}
