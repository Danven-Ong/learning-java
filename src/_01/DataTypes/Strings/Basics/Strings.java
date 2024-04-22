package _01.DataTypes.Strings;

public class Strings {
    public static void main(String[] args) {

        //String Data Type (Not a primitive type)
        String myString = "This is a string";

        //Concatenation of strings
        myString = myString + ", and more.";
        System.out.println(myString); //"This is a string, and more."

        String test = "100";
        System.out.println(test + 5.5); //1005.5
        //Concatenation between a string and anything else gives a String as result

        //Using Unicode in strings
        String mySecondString = "I have \u0024100 dollars.";
        System.out.println(mySecondString); //"I have $100 dollars."

        //Strings are Immutable
        String lastString = "Last string";
        lastString = lastString + 5; //New string is created and lastString is reassigned to the new concatenated value
    }
}
