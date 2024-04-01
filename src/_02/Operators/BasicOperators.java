package _02.Operators;

public class BasicOperators {
    public static void main(String[] args) {

        //e.g. of Operators on numbers
        int result = 1 + 2; //result = 3
        result = result - 2; //result = 1

        //Remainder operator %
        System.out.println(10 % 5); //0

        //Using % to test for even numbers, when the final result == 0
        System.out.println(10 % 2); //0
        System.out.println(9 % 2); //1


        //+ Operator on char
        char firstChar ='A', secondChar = 'B';
        System.out.println(firstChar + secondChar); //131, numbers in memory get added together instead if the characters
        System.out.println("" + firstChar + secondChar); //AB, concat with string to get string result


    }
}
