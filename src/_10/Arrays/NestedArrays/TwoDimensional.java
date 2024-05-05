package _10.Arrays.NestedArrays;

import java.util.Arrays;

public class TwoDimensional {
    public static void main(String[] args) {

        //Declaring a two-dimensional array
        int[][] myArray;

        //Instantiating a two-dimensional array
        int[][] doubleArray = new int[4][4]; //first bracket specifies size of outer array, while second is for inner
        System.out.println(doubleArray.length); //prints "4" (represents the size of outer array)

        //Initializing a two-dimensional array (Inner arrays can have varying sizes)
        int[][] myArray2 = {
                {1, 2},
                {11, 12, 13},
                {21, 22, 23, 24, 25}
        };

        //Initializing a two-dimensional array, without specifying size of inner/nested arrays
        int[][] myArray3 = new int[3][]; //Returns an array of 3 null elements

        //Printing elements in the outer array
        for (int[] outer : doubleArray) {
            System.out.println(Arrays.toString(outer));
        }
        //prints "
        //[0, 0, 0, 0]
        //[0, 0, 0, 0]
        //[0, 0, 0, 0]
        //[0, 0, 0, 0]"

        //Looping through inner array
        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray[i].length; j++) {
                System.out.print(doubleArray[i][j] + " ");
            }
            System.out.println();
        }
        //prints "
        //0 0 0 0
        //0 0 0 0
        //0 0 0 0
        //0 0 0 0 "

        //Looping through inner array using enhanced for loop
        for (int[] innerArray : doubleArray) {
            for (int i : innerArray) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        //prints "
        //0 0 0 0
        //0 0 0 0
        //0 0 0 0
        //0 0 0 0 "

        //Printing multi-dimensional arrays using deepToString method
        System.out.println(Arrays.deepToString(doubleArray));
        //prints "[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]"

        //Accessing elements in two-dimensional arrays
        doubleArray[1] = new int[] {1, 1, 1};
        System.out.println(Arrays.deepToString(doubleArray));
    }
}
