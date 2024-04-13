package _07.Inputs;

import java.util.Scanner;

public class ParsingInputs {
    public static void main(String[] args) {
        //System.console() does not work with IDE, but can work with command line or terminal session
        try {
            System.out.println(getInputFromConsole(2024));
        } catch (NullPointerException npe) {
            System.out.println(getInputFromScanner(2024));
        }

    }

    //Using System.console()
    public static String getInputFromConsole(int currentYear) {

        String name = System.console().readLine("What is your name ");
        System.out.println("Hi " + name);

        String dateOfBirth = System.console().readLine("Which year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "You are " + age + " years old";
    }

    //Using Scanner class
    public static String getInputFromScanner(int currentYear) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("Hi " + name);

        boolean validDOB = false;
        int age = 0;
        do {
            System.out.println("Which year were you born? ");
            try {
                age = checkData(currentYear, scanner.nextLine());
                validDOB = age >= 0;
            } catch (NumberFormatException nfe) {
                System.out.println("Characters not allowed, invalid data");
            }
        } while (!validDOB);

        return "You are " + age + " years old";

    }

    //Validating data
    public static int checkData(int currentYear, String dateOfBirth) {
        int minimumYear = currentYear - 125;
        int dob = Integer.parseInt(dateOfBirth);
        if ((dob < minimumYear) || (dob > currentYear)) {
            return -1;
        }
        return currentYear - dob;
    }
}
