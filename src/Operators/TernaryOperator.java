package Operators;

public class TernaryOperator {
    public static void main(String[] args) {

        //Structure of a ternary operator
        //<condition> ? <result if true> : <result if false>

        int myValue = 50;
        String result = (myValue >= 50) ? "Greater than or equal 50" : "Less than 50";
        System.out.print(result); //"Greater than or equal 50"
    }
}
