package _05.ControlFlow;

public class While_Loop {
    public static void main(String[] args) {

        //while loop
        int i = 1;
        while (i <= 5) {
            System.out.println(i); //prints 1 to 5
            i++;
        }

        //breaking in while loops
        i = 1;
        while (true) {
            if (i > 5) {
                break;
            }
            System.out.println(i); //prints 1 to 5
            i++;
        }

        //continue statement
        i = 0;
        while (i < 5) {
            i++;
            if (i == 3) {
                continue;
            }
            System.out.println(i); //prints 1 to 5 except 3
        }

        //do while loop
        i = 1;
        boolean isReady = false;
        //do code block is executed at least once even if expression is false
        do {
            if (i > 2) {
                break;
            }
            System.out.println("isReady == " + isReady); //line was printed when isReady is false
            i++;
            isReady = true;
        } while (isReady);
    }
}
