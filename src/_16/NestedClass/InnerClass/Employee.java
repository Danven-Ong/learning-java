package _16.NestedClass.InnerClass;

import java.util.Comparator;

public class Employee {

    //Creating a nested static class
    public static class EmployeeComparator <T extends Employee>
            implements Comparator<Employee> {
        //this nested static class has access to outer classes' static fields and methods
        private String sortType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {

            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted; //compareTo method does not work on primitive type
            }
            //getter method for name is not needed since this class is declared inside
            return o1.name.compareTo(o2.name); //Comparing two Strings
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
