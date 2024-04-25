package _08.OOP._04.DataTransferObjects.POJO;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Tim", "05/04/1990");
        System.out.println(student); //prints "Student{name='Tim', dateOfBirth='05/04/1990'}"
    }
}
