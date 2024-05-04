package _10.Arrays;

import java.util.Arrays;
import java.util.Random;

public class Methods {
    public static void main(String[] args) {

        //Using java.util.Arrays
        int[] newArray = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(newArray)); //prints "[5, 4, 3, 2, 1]"

        int[] randomArray = getRandomArray(10);
        System.out.println(Arrays.toString(randomArray));

        //Entering array as argument in method
        int [] someArray = getArray(new int[] {1, 2, 3});
        System.out.println(Arrays.toString(someArray)); //prints "[1, 2, 3]"


        //Sorting arrays
        int[] firstArray = {1, 4, 2, 3, 8, 11, 6};
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray)); //prints "[1, 2, 3, 4, 6, 8, 11]"

        //Creating a copy of an array (array as 1st argument and size as 2nd argument)
        int[] secondArray = Arrays.copyOf(firstArray, firstArray.length);
        System.out.println(Arrays.toString(secondArray)); //prints "[1, 2, 3, 4, 6, 8, 11]"

        int[] smallerArray = Arrays.copyOf(firstArray, 5);
        System.out.println(Arrays.toString(smallerArray)); //prints "[1, 2, 3, 4, 6]"

        int[] largerArray = Arrays.copyOf(firstArray, 10);
        System.out.println(Arrays.toString(largerArray)); //prints "[1, 2, 3, 4, 6, 8, 11, 0, 0, 0]"


        //Filling arrays (of value 5)
        int[] thirdArray = Arrays.copyOf(firstArray, firstArray.length);
        Arrays.fill(thirdArray, 5);
        System.out.println(Arrays.toString(thirdArray)); //prints "[5, 5, 5, 5, 5, 5, 5]"

        //Copying array does not mutate original array
        System.out.println(Arrays.toString(firstArray)); //prints "[1, 2, 3, 4, 6, 8, 11]"

        //Searching for element in array
        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray); //binarySearch method requires array to be sorted
        if (Arrays.binarySearch(sArray, "Mark") >= 0) {
            System.out.println("Found Mark in the list");
        } //prints "Found Mark in the list"

        //Checking if arrays are equal (size, order and elements must be the same)
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {1, 2, 3, 4, 5};

        if (Arrays.equals(s1, s2)) {
            System.out.println("Arrays are equal");
        } //prints "Arrays are equal"
    }

    //Method return type can be an Array
    private static int[] getRandomArray(int len) {

        Random random = new Random();
        int[] intArray = new int[len];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(100);
        }

        return intArray;
    }

    //Method that accepts array as argument
    private static int[] getArray(int[] array) {
        return array;
    }
}
