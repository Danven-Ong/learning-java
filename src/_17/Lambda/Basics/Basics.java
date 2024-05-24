package _17.Lambda.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Basics {

    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Patty"),
                new Person("Charlie", "Brown")));


        //Using Lambda expression (supported by types with functional interface - one abstract method)
        //method is inferred by Java
        people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        System.out.println(people);
        //prints "[Sally Brown, Charlie Brown, Linus Patty, Lucy Van Pelt]"


        interface EnhancedComparator<T> extends Comparator<T> {

            int secondLevel(T o1, T o2);
        }

        var comparatorMix = new EnhancedComparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };

        //comparatorMix cannot be turned into lambda expression (not functional interface)
        people.sort(comparatorMix);
        System.out.println(people);
        //prints "[Charlie Brown, Sally Brown, Linus Patty, Lucy Van Pelt]"

        //Example of another lambda expression (Using Consumer functional interface)
        people.forEach((myPerson) -> System.out.println(myPerson)); //prints elements in the list like a for loop
        //prints
        //"Charlie Brown"
        //"Sally Brown"
        //"Linus Patty"
        //"Lucy Van Pelt"

        String text = " -> ";
        //Lambda expression be a code block
        people.forEach((myPerson) -> {
            char first = myPerson.firstName.charAt(0);
            System.out.println(myPerson.firstName + text+ first); //Lambda support the use of final variables
        });
        //prints
        //"Charlie -> C"
        //"Sally -> S"
        //"Linus -> L"
        //"Lucy -> L"

        //Declaring type for parameter is optional
        int result = calculator((Integer a, Integer b) -> {int c = a + b; return c;}, 5, 2);
        //prints "Result of operation: 7"

        //Different ways of using lambda expressions
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5); //returns Double
        //prints "Result of operation: 4.0"

        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Mr", "Michael");
        //prints "Result of operation: MR MICHAEL"
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {

        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}
