package _12.Boxing;

public class PrimitiveTypes {
    public static void main(String[] args) {

        //Boxing is the conversion of a primitive type to its corresponding wrapper class object
        //Unboxing is the conversion of a wrapper class object back to its corresponding primitive type

        //Manual boxing methods
        Integer boxedInt = Integer.valueOf(15); //Unnecessary
        Integer deprecatedBoxing = new Integer(15); //deprecated since JDK 9


        //Manual unboxing method
        int unboxedInt = boxedInt.intValue(); //unnecessary

        //Autoboxing
        Integer autoBoxed = 15;

        //Automatic unboxing
        int autoUnboxed = autoBoxed;

        System.out.println(autoBoxed.getClass().getName()); //prints "java.lang.Integer"

        //Automatic boxing/unboxing occurs here
        Double autoboxedDouble = getLiteralDoublePrimitive(); //automatic boxing
        double autoUnboxedDouble = getDoubleObject(); //automatic unboxing


    }

    //Method that returns a Double object (boxed)
    private static Double getDoubleObject() {

        return Double.valueOf(100.00); //unnecessary but clear in stating that we are returning Double object
    }

    private static double getLiteralDoublePrimitive() {
        return 100.00;
    }

    private static int returnAnInt(Integer i) {
        return i; //Automatic unboxing occurs
    }

    private static Integer returnAnInteger(int i) {
        return i; //Autoboxing occurs
    }
}
