package _01.DataTypes.Strings.Methods;

public class Comparison {
    public static void main(String[] args) {

        String helloWorld = "Hello World";

        //Changing string to all lowercase
        String helloWorldLower = helloWorld.toLowerCase();
        System.out.println(helloWorldLower); //prints "hello world"

        //Comparing strings
        if (!helloWorld.equals(helloWorldLower)) {
            System.out.println("Strings are not equal"); //Strings are not equal
        }

        //Check is string starts with substring
        if (helloWorld.startsWith("H")) {
            System.out.println("String starts with H"); //prints "String starts with H"
        }

        //Check is string ends with substring
        if (helloWorld.endsWith("World")) {
            System.out.println("String ends with World"); //prints "String ends with World"
        }

        //Check is string contains substring
        if (helloWorld.contains("ello")) {
            System.out.println("String contains ello"); //prints "String ends with World"
        }
    }
}
