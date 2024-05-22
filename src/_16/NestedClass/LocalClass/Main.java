package _16.NestedClass.LocalClass;

import _16.NestedClass.InnerClass.Employee;
import _16.NestedClass.InnerClass.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Marty", 2021, "Walmart"),
                new StoreEmployee(10015, "Bud", 2016, "Target"),
                new StoreEmployee(10105, "Tom", 2020, "Macys") ));

        addPigLatinName(storeEmployees);
        //prints
        //"Marty artyMay Piggy"
        //"Meg egMay Piggy"
        //"Tom omTay Piggy"
        //"Bud udBay Piggy"
    }

    public static void addPigLatinName(List<? extends StoreEmployee> list) {

        String lastName = "Piggy";

        //Creating a local class in method body
        class DecoratedEmployee extends StoreEmployee
                implements Comparable<DecoratedEmployee>{

            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                //Local class support the use local variables or method arguments in the local class
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + "   " + pigLatinName ;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        newList.sort(null); //Using null is the same as using Comparable's compareTo method
        for (var dEmployee : newList) {
            //Private fields from local class is accessible outside of class declaration
            System.out.println(dEmployee.originalInstance.getName() + " "
                    + dEmployee.pigLatinName);
        }
    }
}
