package _01.DataTypes.Strings.Methods;

public class Inspection {
    public static void main(String[] args) {

        printInfo("Hello World");
        //prints "Length = 11"
        //"First char = H"
        //"Last char = d"

        printInfo("");
        //prints "Length = 0"
        //"String is empty"

        printInfo("\t   \n   \t\n");
        //prints "Length = 10"
        //"String is blank"

        //Checking index number for first occurrence of a specified char in string
        String helloWorld = "Hello World";
        System.out.printf("index of l = %d %n", helloWorld.indexOf('l')); //prints "index of l = 2"

        //Checking index number for first occurrence of a specified char in string from the right
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l')); //prints "index of l = 9"

        //Specify which index to start from
        System.out.printf("index of l = %d %n", helloWorld.indexOf('l', 3)); //prints "index of l = 3"
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l', 8)); //prints "index of l = 3"

        //Supports method overloading
        //Checking index number for first occurrence of a specified substring
        System.out.printf("index of World = %d %n", helloWorld.indexOf("World")); //prints "index of World = 6"



    }

    public static void printInfo(String string) {

        int length = string.length();
        System.out.printf("Length = %d %n", length);

        //Checking if string has no characters.
        if (string.isEmpty()) {
            System.out.println("String is empty");
            return;
        }

        //Checking if string has no characters or contains only whitespace
        if (string.isBlank()) {
            System.out.println("String is blank");
            return;
        }

        System.out.printf("First char = %c %n", string.charAt(0)); //string.charAt() accepts an String index no.
        System.out.printf("Last char = %c %n", string.charAt(length -1)); //getting the last character
    }
}
