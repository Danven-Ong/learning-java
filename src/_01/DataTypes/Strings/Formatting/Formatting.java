package _01.DataTypes.Strings.Formatting;

public class Formatting {
    public static void main(String[] args) {

        //Old way of handling multi-line formatted Strings
        String bulletIt = "Print a Bulleted List:\n" +
                "\t• First Point\n" +
                "\t\t• Sub Point";
        System.out.println(bulletIt);
        //prints "Print a Bulleted List:
        //	        • First Point
        //		        • Sub Point"

        //Using text block instead (JDk 15)
        String textBlock = """
                Print a Bulleted List:
                    • First Point
                        • Sub Point""";
        System.out.println(textBlock);
        //prints "Print a Bulleted List:
        //	        • First Point
        //		        • Sub Point"

        //System.out.printf()
        int age = 35;
        //this does not print a new line by default, %n is the same as \n in System.out.printf()
        System.out.printf("Your age is %d%n", age); //prints "Your age is 35"

        //Using more than one parameter
        int yearOfBirth = 2024 - age;
        System.out.printf("Your age is %d, Birth year = %d%n", age, yearOfBirth);
        //prints "Your age is 35, Birth year = 1989"

        //Using other argument category
        //%f accepts decimal number, float/double data type
        System.out.printf("Your age is %f%n", (float) age); //prints "Your age is 35.000000"
        //Choosing precision (to 2 decimal points)
        System.out.printf("Your age is %.2f%n", (float) age); //prints "Your age is 35.00"

        for (int i = 1; i <= 10000; i*=10) {
            System.out.printf("Printing %5d %n", i); //%5d will result in each number to fill up 5 spaces
        }
        //"Printing     1
        // Printing    10
        // Printing   100
        // Printing  1000
        // Printing 10000"

        //Other formatting methods for Strings
        //String static method
        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString); //prints "Your age is 35"

        //String instance method (JDK 15)
        formattedString = "Your age is %d".formatted(age);
        System.out.println(formattedString); //prints "Your age is 35"
    }

}
