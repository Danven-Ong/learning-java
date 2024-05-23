package _16.NestedClass.AnonymousClass;

import _16.NestedClass.InnerClass.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Marty", 2021, "Walmart"),
                new StoreEmployee(10015, "Bud", 2016, "Target"),
                new StoreEmployee(10105, "Tom", 2020, "Macys") ));

        //Using an anonymous class
        var comparator = new Comparator<StoreEmployee>() {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName()); //sort by names alphabetically
            }
        };

        storeEmployees.sort(comparator);
        for (var employee : storeEmployees) {
            System.out.println(employee);
        }
        //prints
        //"Target  10015 Bud      2016"
        //"Walmart 10515 Marty    2021"
        //"Target  10015 Meg      2019"
        //"Macys   10105 Tom      2020"
    }
}
