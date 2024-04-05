package _04.Methods;

public class Methods {
    //main is a method
    public static void main(String[] args) {

        //Simple method
        System.out.println("main is running");
        methodOne(); //calling the method
        System.out.println("main is running again");

        //method with parameters
        methodTwo(true, "Hello", 50);
        methodTwo(false, "Hello", 45);

        //methods that have return type
        int value = intMethod();
        System.out.println(value);
        System.out.println(stringMethod("Hello"));
    }

    //Creating a new method
    public static void methodOne() {
        System.out.println("methodOne is running");
        return; //return here is optional when method has a void return type
    }

    //method with parameters
    public static void methodTwo(boolean bool, String myString, int myValue) {
        if (bool) {
            System.out.println("Method is true, String = " + myString
                    + ", Value = " + myValue);
        }
    }

    //declaring method return type
    public static int intMethod() {
        return 5;
    }
    public static String stringMethod(String myString) {
        return myString;
    }
}

