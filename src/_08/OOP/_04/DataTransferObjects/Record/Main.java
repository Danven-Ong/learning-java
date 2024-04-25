package _08.OOP._04.DataTransferObjects.Record;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alex", "02/11/1987");
        System.out.println(teacher); //prints "Teacher[name=Alex, dateOfBirth=02/11/1987]"

        //Methods Record objects has the same name and type of component
        System.out.println(teacher.name()); //prints "Alex"
        System.out.println(teacher.dateOfBirth()); //prints "02/11/1987"
    }

}
