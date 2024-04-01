package _02.Operators;

public class AbbreviatingOperators {
    public static void main(String[] args) {

        //Post-fix Increment Operator
        int result = 100;
        result++; //This also means result = result + 1;
        result--; //This means result = result - 1;

        //Compound Operator Assignment (supports +, -, *, /)
        result += 1; //This means result = result + 1;
        result -= 5; //This means result = result - 5;

        int otherResult = 10;
        otherResult -= 5.5;
        System.out.println(otherResult); //4, using Compound Operator Assignment hides the lossy conversion error

        int otherResult2 = 10;
        otherResult2 = (int) (otherResult2 - 5.5);
        System.out.println(otherResult2); //4, this also fixes the lossy conversion error using casting
        //Conclusion: x -= y is x = (data type of x) (x - y)
    }
}
