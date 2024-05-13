package _13.Enum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Assigning enum value to a variable
        DayOfTheWeek weekDay = DayOfTheWeek.TUESDAY;
        System.out.println(weekDay); //prints "TUESDAY"

        //Assigned variable has a name and ordinal value (order of element in enum object)
        System.out.println(weekDay.name()); //prints "TUESDAY"
        System.out.println(weekDay.ordinal()); //prints "1"

        //Creating an array with enum constants
        DayOfTheWeek[] allDays = DayOfTheWeek.values();
        System.out.println(Arrays.toString(allDays));
        //prints "[MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]"

        //Applying switch to enum values
        switchDayOfTheWeek(weekDay); //prints "Tuesday is Day 2"
        switchDayOfTheWeek(DayOfTheWeek.THURSDAY); //prints "Thursday day is Day 4"

        //Looping through enum
        for (Topping topping : Topping.values()) {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }
        //prints
        //"MUSTARD : 0.0"
        //"PICKLES : 0.0"
        //"BACON : 1.5"
        //"CHEDDAR : 1.0"
        //"TOMATO : 0.0"
    }

    public static void switchDayOfTheWeek(DayOfTheWeek weekDay) {

        int weekDayInteger = weekDay.ordinal() + 1;
        switch (weekDay) {
            case SUNDAY-> System.out.println("Sunday is Day " + weekDayInteger);
            case MONDAY-> System.out.println("Monday is Day " + weekDayInteger);
            case TUESDAY-> System.out.println("Tuesday is Day " + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) +
                    weekDay.name().substring(1).toLowerCase() +
                    " day is Day " + weekDayInteger);
        }
    }
}
