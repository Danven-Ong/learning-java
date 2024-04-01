package _01.DataTypes;

public class Casting {
    public static void main(String[] args) {

        //Declaring multiple variables with same data type
        byte firstByte = 1, secondByte = 2;

        //casting
        byte myMinByteValue = Byte.MIN_VALUE;
        byte myNewValue = (byte) (myMinByteValue / 2);

        //No casting required
        byte myOtherValue = (128 / 2);

    }
}
