package _09.StringBuilder;

public class Methods {
    public static void main(String[] args) {

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");

        //Deleting character at specified index
        helloWorldBuilder.deleteCharAt(16);
        System.out.println(helloWorldBuilder); //prints "Hello World and oodbye"

        //Inserting a character at specified index
        helloWorldBuilder.insert(16, 'g');
        System.out.println(helloWorldBuilder); //prints "Hello World and goodbye"

        //Replacing a specified sequence of characters
        helloWorldBuilder.replace(16, 17, "G");
        System.out.println(helloWorldBuilder); //prints "Hello World and Goodbye"

        //Reversing the sequence of characters
        helloWorldBuilder.reverse();
        System.out.println(helloWorldBuilder); //prints "eybdooG dna dlroW olleH"

        //Modifying length of the sequence of characters
        helloWorldBuilder.setLength(7);
        System.out.println(helloWorldBuilder); //prints "eybdooG"



    }
}
