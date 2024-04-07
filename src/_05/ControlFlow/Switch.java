package _05.ControlFlow;

public class Switch {
    public static void main(String[] args) {

        //traditional switch statement
        int value = 3;
        switch (value) {
            case 1: //code to execute if expression matches value 1
                System.out.println("Value was 1");
                break; //terminate the switch block
            case 2: //code to execute if expression matches value 2
                System.out.println("Value was 2");
                break;
            case 3:
                System.out.println("Value was 3");
                break;
            case 4:
                System.out.println("Value was 4");
                break;
            default: //code to execute if expression does not match any case
                System.out.println("Value is not within range 1 to 4");
                break;
        }

        //checking for more than one case while using the same code block
        int value2 = 3;
        switch (value2) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2: case 3: case 4:
                System.out.println("Value is within range 1 to 4");
                System.out.println("Value was " + value2);
                break;
            default: //terminate the switch block
                System.out.println("Value is not within range 1 to 4");
                break;
        }

        //enhanced switch statement (finalised in Java 14)
        switch (value2) {
            case 1 -> {
                System.out.println("Value was 1");

            }
            case 2, 3, 4 -> {
               System.out.println("Value is within range 1 to 4");
               System.out.println("Value was " + value2);
            }
            default -> {
                System.out.println("Value is not within range 1 to 4");
            }
        }

        //yield in switch statements
        //yield is a specific keyword used to return a value to the switch expression, only used in a code block
        int value3 = 1;
        String number = switch (value3) {
            case 1 -> {
                yield "one"; //yield is optional here
            }
            case 2 -> "two";
            default -> "Out of range";
        };
        System.out.println("Number is " + number);
    }
    //return may be used in methods (finalised in Java 14)
    public static String test(int myValue) {
        return switch (myValue) {
            case 1 -> {
                yield "one"; //yield is optional here
            }
            case 2 -> "two";
            case 3, 4 -> "either three or four";
            default -> {
                String badValue = myValue + " is not within range 1 to 4";
                yield badValue;
            }
        };
    }
}
