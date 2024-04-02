package _03.ConditionalLogic;

public class if_else {
    public static void main(String[] args) {

        //if else statement
        boolean isTrue = true;
        if (isTrue) {
            System.out.println("Running because expression is true");
        } else {
            System.out.println("Running because expression is not true");
        }

        //using else if
        int topScore = 100;
        if (topScore >= 100) {
            System.out.println("You got the high score more than or equal to 100");
        } else if (topScore >= 70) {
            System.out.println("You got high score more than or equal to 70");
        } else {
            System.out.println("You got high score less than 70");
        }

        topScore -= 5;
        int secondTopScore = 60;
        if ((topScore > secondTopScore) && (topScore < 100)) {
            System.out.println("Greater than second top score and less than 100");
        }

    }
}

