package _15.Generics.Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"),
                new Student("Ann")};

        Arrays.sort(students); //Students are sorted by their id
        System.out.println(Arrays.toString(students));
        //prints "[1001 - Zach (1.12), 1002 - Tim (3.67), 1003 - Ann (3.28)]"

        //Sorting by gpa (lowest to highest)
        Comparator<Student> gpaSorter = new StudentGPAComparator();
        //Array has a overloaded sort method that takes Comparator as its second argument
        Arrays.sort(students, gpaSorter);
        System.out.println(Arrays.toString(students));
        //prints "[1001 - Zach (1.12), 1003 - Ann (3.28), 1002 - Tim (3.67)]"

        //Reversing how gpa is sorted (highest to lowest)
        Arrays.sort(students, gpaSorter.reversed()); //Comparator has other helper methods like reversed
        System.out.println(Arrays.toString(students));
        //prints "[1002 - Tim (3.67), 1003 - Ann (3.28), 1001 - Zach (1.12)]"
    }
}

class StudentGPAComparator implements Comparator<Student> { //Ensuring Comparator only accepts Student type parameter

    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}
class Student implements Comparable<Student>{

    private static int LAST_ID = 1000;
    private static Random random = new Random();
    protected String name;
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
