package _01.DataTypes.Strings.Methods;

public class Manipulation {
    public static void main(String[] args) {

        //Return a part of String, range defined by start and end
        String birthDate = "25/11/1982";
        System.out.println("Birth year = " + birthDate.substring(6)); //prints "Birth year = 1982"

        //Range does not include end index
        System.out.println("Month = " + birthDate.substring(3, 5)); //prints "Month = 11"

        //Joining Strings together using join, specifying a delimiter
        String newDate = String.join("/", "25", "11", "1982");
        System.out.println(newDate); //prints "25/11/1982"

        //Joining Strings together using concat
        newDate = "25".concat("/").concat("11").concat("/").concat("1982");
        System.out.println(newDate); //prints "25/11/1982"

        //Replacing a character or String
        System.out.println(newDate.replace('/', '-')); //prints "25-11-1982"
        System.out.println(newDate.replace("2", "00")); //prints "005/11/19800"
        System.out.println(newDate.replaceFirst("/", "-")); //prints "25-11/1982"

        //Repeating Strings
        System.out.println("-".repeat(20)); //prints "--------------------"

        //Indenting Strings
        System.out.println("ABC\n".repeat(3).indent(8));
        //prints "
        //        ABC
        //        ABC
        //        ABC
        //"

        //Removing spaces
        System.out.println("    ABC\n".repeat(3).indent(-2));
        //prints "
        //  ABC
        //  ABC
        //  ABC
        //"
    }
}
