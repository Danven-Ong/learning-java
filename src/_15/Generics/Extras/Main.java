package _15.Generics.Extras;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            students.add(new Student());
        }

        printList(students);
        //prints
        //"Cathy           Python          2018"
        //"Ann             C++             2018"

        List<NewStudent> newStudents = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            newStudents.add(new NewStudent());
        }

        printList(newStudents);
        //prints
        //"Ann             Java            2018     13.9%"
        //"Bill            Python          2021      4.6%"

        printMoreList(newStudents);
        //prints
        //"Ann             Java            2018     13.9%"
        //"Bill            Python          2021      4.6%"

        printMoreList2(newStudents);
        //prints
        //"Ann             Java            2018     13.9%"
        //"Bill            Python          2021      4.6%"

        List<String> stringList = new ArrayList<>(List.of("Able", "Betty", "Charlie"));
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3));

        testList(stringList);
        //"String : ABLE"
        //"String : BETTY"
        //"String : CHARLIE"

        testList(integerList);
        //prints
        //"Integer : 1"
        //"Integer : 2"
        //"Integer : 3"

        var queryList = new QueryList<>(newStudents);
        var matches = queryList.getMatches(
                "Course", "Python");

        printMoreList(matches);
        //prints
        //"Bill            Python          2021      4.6%"

        var students2021 =
                QueryList.getMatches(newStudents, "YearStarted", "2021");

        printMoreList(students2021);
        //prints
        //"Bill            Python          2021      4.6%"

        var lst =
                QueryList.<Student>getMatches(new ArrayList<>(), "YearStarted", "2021");
        //Specifying type argument for generic method to ensure printMoreList runs
        printMoreList(lst);

    }

    //Using a generic method
    //Declaring a generic parameter type before the return type on a method
    //Ensuring the generic parameter only accepts Student or subtype of Student
    public static <T extends Student> void printList(List<T> students) {

        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    //method that uses a wildcard parameter (? parameter)
    public static void printMoreList(List<? extends Student> students) {
        //This accepts Student or subtype of Student as its List type (Upper bound)
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void printMoreList2(List<? super NewStudent> students) {
        //This accepts NewStudent or supertype of NewStudent including Object type (Lower Bound)
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    //method that uses unbounded wildcard parameter
    public static void testList(List<?> list) {

        for (var element : list) {
            if (element instanceof String s) {
                System.out.println(("String : " + s.toUpperCase()));
            } else if (element instanceof Integer i) {
                System.out.println("Integer : " + i);
            }
        }
    }
}
