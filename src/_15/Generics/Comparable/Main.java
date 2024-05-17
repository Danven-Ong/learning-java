package _15.Generics.Comparable;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //Using classes that implements the Comparable interface

        //Wrapper class implements Comparable interface
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};
        for (Integer i : others) {
            int val = five.compareTo(i); //Comparable interface has compareTo method
            System.out.printf("%d %s %d: compareTo = %d%n", five,
                    (val == 0) ? "==" : (val < 0) ? "<" : ">", i, val);
            //val returns 1 if greater, 0 if equal, -1 if less
        }
        //prints
        //"5 > 0: compareTo = 1"
        //"5 == 5: compareTo = 0"
        //"5 < 10: compareTo = -1"
        //"5 > -50: compareTo = 1"
        //"5 < 50: compareTo = -1"

        String banana = "banana";
        String[] fruits = {"apple", "banana", "pear", "BANANA"};

        for (String s : fruits) {
            int val = banana.compareTo(s); //Comparable interface has compareTo method
            System.out.printf("%s %s %s: compareTo = %d%n", banana,
                    (val == 0) ? "==" : (val < 0) ? "<" : ">", s, val);
            //val returns difference between underlying integer values between the
            //first character of the two strings being compared
        }
        //prints
        //"banana > apple: compareTo = 1"
        //"banana == banana: compareTo = 0"
        //"5 < 10: compareTo = -1"
        //"banana < pear: compareTo = -14"
        //"banana > BANANA: compareTo = 32"

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"),
                new Student("Ann")};

        Arrays.sort(students); //Students are sorted by their id
        System.out.println(Arrays.toString(students));
        //prints "[1001 - Zach (3.49), 1002 - Tim (2.22), 1003 - Ann (2.25)]"
    }
}

class Student implements Comparable<Student>{ //Ensuring Comparable only accepts Student type parameter

    private static int LAST_ID = 1000;
    private static Random random = new Random();
    private String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    //Overriding Student compareTo method
    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(id)); //Student are compared based on id
    }
}
