package _06.Exceptions;

public class HandlingExceptions {
    public static void main(String[] args) {

        try {
            // Code that may throw an exception
            int result = 10 / 0; // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            // Handling specific exception
            System.out.println("Error: Division by zero");
            System.out.println(e);
        } finally {
            // Cleanup code or any code that should be executed regardless of exceptions
            System.out.println("Finally block executed");
        }
    }
}
