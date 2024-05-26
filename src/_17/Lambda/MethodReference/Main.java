package _17.Lambda.MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class PlainOld {

    public static int last_id = 1;
    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "Anna", "Bob", "Chuck", "Dave"));

        //Using lambda expression
        list.forEach(s -> System.out.println(s));
        //prints
        //"Anna"
        //"Bob"
        //"Chuck"
        //"Dave"

        //Using method reference
        list.forEach(System.out::println);
        //prints
        //"Anna"
        //"Bob"
        //"Chuck"
        //"Dave"

        calculator(Integer::sum, 10, 25);
        //prints "Result of operation: 35"

        calculator(Double::sum, 2.5, 7.5);
        //prints "Result of operation: 10.0"

        //Creating a lambda expression
        Supplier<PlainOld> reference1 = () -> new PlainOld();

        //Using method reference
        Supplier<PlainOld> reference2 = PlainOld::new;

        PlainOld newPojo1 = reference1.get(); //prints "Creating a PlainOld Object: id = 1"
        PlainOld newPojo2 = reference2.get(); //prints "Creating a PlainOld Object: id = 2"

        PlainOld[] newPojo3 = seedArray(PlainOld::new, 3); //newPojo3 contains 3 PlainOld objects
        //prints
        //"Creating a PlainOld Object: id = 3"
        //"Creating a PlainOld Object: id = 4"
        //"Creating a PlainOld Object: id = 5"

        //Non-static method can be referenced
        BinaryOperator<String> b1 = String::concat;
        System.out.println(b1.apply("Hello", "World")); //prints "HelloWorld"

        BiFunction<String, String, String> b2 = String::concat;
        System.out.println(b2.apply("Hello", "World")); //prints "HelloWorld"

        UnaryOperator<String> u1 = String::toUpperCase;
        System.out.println(u1.apply("Hello")); //prints "HELLO"
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {

        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}
