package _17.Lambda.Chaining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        String name = "Tim";
        Function<String,String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String,String> lastName = s -> s.concat(" Dave");

        //Chaining lambdas
        Function<String,String> uCaseLastName = uCase.andThen(lastName); //uCase is executed first, then lastName
        System.out.println(uCaseLastName.apply(name)); //prints "TIM Dave"

        //compose method is only available to lambda expressions that target a Function or UnaryOperator interface
        uCaseLastName = uCase.compose(lastName); //lastName is executed first, then uCase
        System.out.println(uCaseLastName.apply(name)); //prints "TIM DAVE"

        //Chaining more lambdas
        Function<String,String[]> f0 = uCase
                .andThen(s -> s.concat(" Dave"))
                .andThen(s -> s.split(" "));

        System.out.println(Arrays.toString(f0.apply(name))); //prints "[TIM, Dave]"

        Function<String,String> f1 = uCase
                .andThen(s -> s.concat(" Dave"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);

        System.out.println(f1.apply(name)); //prints "DAVE, TIM"

        //Chaining series of method with void return types
        String[] names = {"Ann", "Bob", "Carol"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;
        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.print(" - "))
                .andThen(s1));
        //prints
        //"A - Ann"
        //"B - Bob"
        //"C - Carol"

        //Chaining with Predicates (boolean return type)
        Predicate<String> p1 = s -> s.equals("TIM");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");
        Predicate<String> p3 = s -> s.startsWith("T");
        Predicate<String> p4 = s -> s.startsWith("e");

        System.out.println(name); //prints "Tim"

        Predicate<String> combined1 = p1.or(p2); //Test if either Predicate is true
        System.out.println(combined1.test(name)); //prints "true"

        Predicate<String> combined2 = p3.and(p4); //Test if both Predicates are true
        System.out.println(combined2.test(name)); //prints "false"

        Predicate<String> combined3 = p3.and(p4).negate(); //negate function returns opposite of the result
        System.out.println(combined3.test(name)); //prints "true"

        record Person(String firstName, String lastName) {}

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Peter", "Pan"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse"),
                new Person("Peter", "PumpkinEater")
        ));

        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);
        //prints
        //"Person[firstName=Minnie, lastName=Mouse]"
        //"Person[firstName=Mickey, lastName=Mouse]"
        //"Person[firstName=Peter, lastName=Pan]"
        //"Person[firstName=Peter, lastName=PumpkinEater]"

        //A better way of sorting it
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);
        //prints
        //"Person[firstName=Minnie, lastName=Mouse]"
        //"Person[firstName=Mickey, lastName=Mouse]"
        //"Person[firstName=Peter, lastName=Pan]"
        //"Person[firstName=Peter, lastName=PumpkinEater]"

        //This allows for multi-level sorting, since chaining is supported
        list.sort(Comparator.comparing(Person::lastName)
                        .thenComparing(Person::firstName));
        list.forEach(System.out::println);
        //prints
        //"Person[firstName=Mickey, lastName=Mouse]"
        //"Person[firstName=Minnie, lastName=Mouse]"
        //"Person[firstName=Peter, lastName=Pan]"
        //"Person[firstName=Peter, lastName=PumpkinEater]"

        //Chaining with reverse method
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);
        //prints
        //"Person[firstName=Peter, lastName=PumpkinEater]"
        //"Person[firstName=Peter, lastName=Pan]"
        //"Person[firstName=Minnie, lastName=Mouse]"
        //"Person[firstName=Mickey, lastName=Mouse]"
    }
}
