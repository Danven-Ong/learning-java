package _10.Arrays.NestedArrays;

import java.util.Arrays;

public class MultiDimensional {
    public static void main(String[] args) {

        Object[] anyArray = new Object[3];
        System.out.println(Arrays.toString(anyArray)); //prints "[null, null, null]"

        //anyArray accepts object variables
        //Adding a 1-D array
        anyArray[0] = new String[] {"a", "b", "c"};
        System.out.println(Arrays.deepToString(anyArray)); //prints "[[a, b, c], null, null]"

        //Adding a 2-D array
        anyArray[1] = new String[][] {
                {"1", "2"},
                {"3", "4", "5"},
                {"6", "7", "8", "9"}
        };
        System.out.println(Arrays.deepToString(anyArray));
        //prints "[[a, b, c], [[1, 2], [3, 4, 5], [6, 7, 8, 9]], null]"

        //Adding a 3-D array
        anyArray[2] = new int[2][2][2];

        System.out.println(Arrays.deepToString(anyArray));
        //prints "[[a, b, c], [[1, 2], [3, 4, 5], [6, 7, 8, 9]], [[[0, 0], [0, 0]], [[0, 0], [0, 0]]]]"
    }
}
