package _13.Enum;

public enum DayOfTheWeek {

    //enum is used to define a fixed set of constants.
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

enum Topping {

    MUSTARD, PICKLES, BACON, CHEDDAR, TOMATO;

    //enum allows fields, methods and constructors
    public double getPrice() {
        return switch(this) {
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }
}
