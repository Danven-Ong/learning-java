package _16.NestedClass.InnerClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Meal regularMeal = new Meal();
        System.out.println(regularMeal);
        //prints
        //"    burger        regular $5.00"
        //"     drink           coke $1.50"
        //"      side          fries $2.00"
        //"               Total Due: $8.50"

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);
        //prints
        //"    burger        regular $3.40"
        //"     drink           coke $1.02"
        //"      side          fries $1.36"
        //"               Total Due: $5.78"

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10015, "Meg", 2016, "Target"),
                new StoreEmployee(10105, "Tom", 2020, "Macys") ));

        //Calling an inner class require instance of enclosing class
        var genericEmployee = new StoreEmployee();
        var comparator2 = genericEmployee.new StoreComparator<>(); //inner class must also be instantiated

        //alternative way
        var comparator3 = new StoreEmployee().new StoreComparator<>();

        storeEmployees.sort(comparator2); //sorting List by store as first, then by yearStarted

        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }
        //prints
        //"Macys   10105 Tom      2020"
        //"Target  10015 Meg      2016"
        //"Target  10015 Meg      2019"
        //"Walmart 10515 Joe      2021"
    }
}
