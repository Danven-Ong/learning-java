package Operators;

public class LogicalOperators {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        //AND operator (&&)
        boolean resultAnd = (a && b);   // false

        //OR operator (||)
        boolean resultOr = (a || b);    // true

        //NOT operator (!)
        boolean resultNotA = !a;        // false
        boolean resultNotB = !b;        // true
    }
}
