package _17.Lambda.Functional_Interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        int result = calculator((Integer a, Integer b) -> {int c = a + b; return c;}, 5, 2);
        //prints "Result of operation: 7"

        var result2 = calculator((a, b) -> a / b, 10.0, 2.5); //returns Double
        //prints "Result of operation: 4.0"

        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Mr", "Michael");
        //prints "Result of operation: MR MICHAEL"

        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659});

        coords.forEach(s -> System.out.println(Arrays.toString(s)));
        //prints
        //"[47.216, -95.2348]"
        //"[29.1566, -89.2495]"
        //"[35.1556, -90.0659]"

        //Lambda expression can be assigned to local variable
        BiConsumer<Double, Double> p1 = (latitude, longitude) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n", latitude, longitude);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);
        //prints "[lat:47.216 lon:-95.235]"

        //Utilizing processPoint method while looping
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        //prints
        //"[lat:47.216 lon:-95.235]"
        //"[lat:29.157 lon:-89.250]"
        //"[lat:35.156 lon:-90.066]"

        //Same result will happen below
        coords.forEach(s -> processPoint(s[0], s[1],
                (latitude, longitude) ->
                        System.out.printf("[lat:%.3f lon:%.3f]%n", latitude, longitude)));


        //Utilizing Predicate functional interface (boolean return type)
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));
        System.out.println(list); //prints "[alpha, bravo, charlie, delta]"

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        System.out.println(list); //prints "[alpha, charlie, delta]"

        list.removeIf(s -> s.startsWith("a"));
        System.out.println(list); //prints "[charlie, delta]"

        //Utilizing UnaryOperator functional interface (same return type as parameter)
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println(list); //prints "[c - CHARLIE, d - DELTA]"

        String[] emptyStrings = new String[10];
        //Utilizing IntFunction functional interface (uses int primitive argument and uses apply method)
        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1)
                + switch (i) { //lambda expression support use of switch statements
                        case 0 -> " - one";
                        case 1 -> " - two";
                        case 2 -> " - three";
                        default -> "";
                }
        );
        System.out.println(Arrays.toString(emptyStrings));
        //prints "[1 - one, 2 - two, 3 - three, 4, 5, 6, 7, 8, 9, 10]"

        String[] names = {"Ann", "Bob", "Carol", "David"};
        String[] randomList = randomlySelectedValues(8, names,
                () -> new Random().nextInt(0, names.length)); //using Supplier interface

        System.out.println(Arrays.toString(randomList));
        //prints "[Bob, Bob, Carol, David, Ann, Bob, Carol, Ann]"
    }


    //Utilizing BinaryOperator functional interface (Same return type as parameter)
    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    //Utilizing BiConsumer functional interface (void return type)
    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer) {
        consumer.accept(t1, t2);
    }

    //Utilizing Supplier functional interface (return instance of some type T, does not accept arguments)
    public static String[] randomlySelectedValues(int count,
                                                  String[] values,
                                                  Supplier<Integer> s) {

        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}
