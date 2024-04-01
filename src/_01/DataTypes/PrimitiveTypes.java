package _01.DataTypes;

public class PrimitiveTypes {
    public static void main(String[] args) {

        //Integer Data Type (Default)
        int myMinIntValue = Integer.MIN_VALUE; //myMinIntValue = -2147483648
        int myMaxIntValue = Integer.MAX_VALUE; //myMinIntValue = 2147483647

        int myIntResult = 5 / 2; //myIntResult = 2 (Not a decimal since it is an integer data type)

        //Overflow
        int bustedMaxValue = myMaxIntValue + 1;
        System.out.println(bustedMaxValue); //-2147483648
        //When max value overflows, wraps around to min value and continues processing without error

        //Underflow
        int bustedMinValue = myMinIntValue - 1;
        System.out.println(bustedMinValue); // 2147483647
        //When min value underflows, wraps around to max value and continues processing without error

        //Byte Data Type
        byte myMinByteValue = Byte.MIN_VALUE; //myMinByteValue = -128
        byte myMaxByteValue = Byte.MAX_VALUE; //myMaxByteValue = 127

        //Short Data Type
        short myMinShortValue = Short.MIN_VALUE; //myMinShortValue = -32768
        short myMaxShortValue = Short.MAX_VALUE; //myMaxShortValue = 32767

        //Long Data Type
        long myMinLongValue = Long.MIN_VALUE; //myMinLongValue = -9223372036854775808
        long myMaxLongValue = Long.MAX_VALUE; //myMaxLongValue = 9223372036854775807

        long bustedValue = myMaxIntValue + 10L; //bustedValue = 2147483657
        long myLongLiteralValue = 2_147_483_647_100L; //Range larger than Integers

        //Float Data Type
        float myMinFloatValue = Float.MIN_VALUE; //myMinFloatValue = 1.4E-45
        float myMaxFloatValue = Float.MAX_VALUE; //myMaxFloatValue = 3.4028235E38

        float myFloatValue = 5.0f;
        float myFloatResult = 5f / 3f; //myFloatResult = 1.6666666

        //Double Data Type (Default)
        double myMinDoubleValue = Double.MIN_VALUE; //myMinDoubleValue = 4.9E-324
        double myMaxDoubleValue = Double.MAX_VALUE; //myMaxDoubleValue = 1.7976931348623157E308

        double myDoubleValue = 5.0d;
        double myOtherDoubleValue = 5.0;
        double myDoubleResult = 5d / 3d; //myDoubleResult = 1.6666666666666667

        //Char Data Type
        char myChar = 'D'; //Char data type holds 1 character, literal enclosed in Single Quotes

        //Can assign a Unicode value or an integer value
        char myUnicode = '\u0044'; //myUnicode = 'D'
        char myDecimalCode = 68; //myDecimalCode = 'D'

        //Boolean Data Type
        boolean myFalseBool = false;

    }
}