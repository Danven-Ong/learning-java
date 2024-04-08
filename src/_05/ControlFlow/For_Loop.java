package _05.ControlFlow;

public class For_Loop {
    public static void main(String[] args) {

        //for (<init>; <expression>>; <increment>) { <code block> }

        //Using post-fix increment
        for (int counter = 1; counter <= 5; counter++) {
            System.out.println(counter); //prints 1 to 5
        }

        //Using Compound Operator Assignment
        for (int counter = 1; counter <= 5; counter *= 5) {
            System.out.println(counter); //prints 1 and 5
        }

        //Breaking in for loops
        for (int counter = 1; counter <= 5; counter++) {
            if (counter > 3) {
                break;
            }
            System.out.println(counter); //prints 1 to 3
        }

        //continue statement
        for (int counter = 1; counter <= 5; counter++) {
            if (counter == 3) {
                continue;
            }
            System.out.println(counter); //prints 1 to 5 except 3
        }

    }
}
