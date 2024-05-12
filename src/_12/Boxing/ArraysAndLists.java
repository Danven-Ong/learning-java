package _12.Boxing;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysAndLists {
    public static void main(String[] args) {

        //Integer wrapper array
        Integer[] wrapperArray = new Integer[5]; //autoboxing occurs
        wrapperArray[0] = 50;

        //wrapper array will contain null default values instead of 0, since it is not a primitive type
        System.out.println(Arrays.toString(wrapperArray)); //prints "[50, null, null, null, null]"
        System.out.println(wrapperArray[0].getClass().getName()); //prints "java.lang.Integer"

        //Works while initializing array
        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray)); //prints "[a, b, c, d]"
        System.out.println(characterArray[0].getClass().getName()); //prints "java.lang.Character"

        var ourList = getList(1, 2, 3, 4, 5);
        System.out.println(ourList); //prints "[1, 2, 3, 4, 5]"
        System.out.println(ourList.get(0).getClass().getName()); //prints "java.lang.Integer"
    }

    //Creating method that return a ArrayList with Integer wrapper class type
    private static ArrayList<Integer> getList(int... varargs) {

        ArrayList<Integer> aList = new ArrayList<>();
        for (int i : varargs) {
            aList.add(i); //Autoboxing occurs here
        }
        return aList;
    }

}
