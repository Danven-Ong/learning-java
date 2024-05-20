package _16.NestedClass.StaticClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013) ));

        //Must call the Outer class name in order to call the nested class
        employees.sort(new Employee.EmployeeComparator<>());
        for (Employee e : employees) {
            System.out.println(e);
        }
        //prints
        //"10005 Carole   2021"
        //"10022 Jane     2013"
        //"10001 Ralph    2015"

        employees.sort(new Employee.EmployeeComparator<>("yearStarted"));
        for (Employee e : employees) {
            System.out.println(e);
        }
        //prints
        //"10022 Jane     2013"
        //"10001 Ralph    2015"
        //"10005 Carole   2021"

    }

}
