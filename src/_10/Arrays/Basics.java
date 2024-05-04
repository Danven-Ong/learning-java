package _10.Arrays;

public class Basics {
    public static void main(String[] args) {

        //Declaring an Array (include square brackets after type of elements you want in array)
        int[] integerArray;

        //Instantiating an Array
        int[] myIntArray = new int[10]; //Declaring size (10) of array (fixed, not resizeable)

        //Accessing array elements
        myIntArray[5] = 50; //assigns 50 to element of index 6

        //Printing elements from arrays
        //Array elements get initialized to default value for that type if array initializer not used
        System.out.println(myIntArray[0]); //prints "0" (default int value)
        System.out.println(myIntArray[5]); //prints "50"

        //Initializing array (Anonymous array)
        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Both size and order is determined by how it was specified in the code
        System.out.println("first element = " + firstTen[0]); //prints "first element = 1"
        System.out.println(firstTen.length); //prints "10"
        System.out.println("last element = " + firstTen[firstTen.length - 1]); //prints "last element = 10"


        //Initializing array
        int[] newArray;
        //requires new keyword and square brackets in statement outside declaration
        newArray = new int[] {5, 4, 3, 2, 1};

        //Looping arrays
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        } //prints "5 4 3 2 1 "

        System.out.println();

        //Enhanced For loop
        for (int element : newArray) {
            System.out.print(element + " ");
        } //prints "5 4 3 2 1 "

        System.out.println();

        //Array can be assigned to Object variable
        Object objectVariable = newArray;
        if (objectVariable instanceof int[]) {
            System.out.println("objectVariable is an int array");
        } //prints "Array is an int array"

        //Assigning array of many different types
        Object[] objectArray = new Object[4];
        objectArray[0] = "Hello";
        objectArray[1] = 1;
        objectArray[2] = false;
        objectArray[3] = new StringBuilder("World");
    }
}
