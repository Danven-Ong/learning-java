package _09.StringBuilder;

public class Main {
    public static void main(String[] args) {

        String helloWorld = "Hello" + " World";
        helloWorld.concat(" and Goodbye");
        //helloWorld variable never changed, new String was created but not assigned as String is immutable

        //Creating a StringBuilder object
        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");
        //helloWorldBuilder is the same object and value of the object has changed (self-reference), is mutable

        printInfo(helloWorld); //prints "String = HelloWorld", "length = 11"
        printInfo(helloWorldBuilder); //prints "String = HelloWorld and Goodbye", "length = 23"

        //No parameters in StringBuilder object
        StringBuilder emptyStart = new StringBuilder();
        System.out.println(emptyStart.capacity()); //prints "16" (default capacity)
        emptyStart.append("a".repeat(17));
        System.out.println(emptyStart.capacity()); //prints "34" (capacity adjust as string grows beyond capacity)

        //Specifying capacity in StringBuilder object
        StringBuilder emptyStart32 = new StringBuilder(32);
        System.out.println(emptyStart32.capacity()); //prints "32"
    }

    public static void printInfo(String string) {

        System.out.println("String = " + string);
        System.out.println("length = " + string.length());
    }

    public static void printInfo(StringBuilder builder) {

        System.out.println("String = " + builder);
        System.out.println("length = " + builder.length());
    }
}
