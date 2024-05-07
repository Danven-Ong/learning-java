package _11.Lists.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record GroceryItem(String name, String type, int count) {

    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class Main {
    public static void main(String[] args) {

        //Declaring and instantiating an ArrayList
        ArrayList objectList = new ArrayList();

        //Since ArrayList that was created has no specific type, any type can be added
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        //Specifying type in ArrayList
        ArrayList<String> stringArray = new ArrayList<>();

        //Setting ArrayList capacity
        ArrayList<String> stringArray2 = new ArrayList<>(10);

        //Adding elements to ArrayList
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("Oranges", "PRODUCE", 5));

        //Can specify which index to slot in element
        groceryList.add(0, new GroceryItem("Apples", "PRODUCE", 8));

        //Printing ArrayList
        System.out.println(groceryList);
        //prints "[8 APPLES in PRODUCE, 1 BUTTER in DAIRY, 1 MILK in DAIRY, 5 ORANGES in PRODUCE]"

        //Replacing elements in ArrayList
        groceryList.set(0, new GroceryItem("Cheese"));
        System.out.println(groceryList);
        //prints "[1 CHEESE in DAIRY, 1 BUTTER in DAIRY, 1 MILK in DAIRY, 5 ORANGES in PRODUCE]"

        //Removing elements in ArrayList
        groceryList.remove(1);
        System.out.println(groceryList);
        //prints "[1 CHEESE in DAIRY, 1 MILK in DAIRY, 5 ORANGES in PRODUCE]"


        //Creating a string array
        String[] items = {"Apples", "Bananas", "Milk", "Eggs"};

        //Declaring a list with String type
        List<String> list = List.of(items); //List.of() method turns an array to a list

        //List is immutable
        //list.add("Yogurt"); gives an error

        System.out.println(list); //prints "[Apples, Bananas, Milk, Eggs]"

        //ArrayList accepts List instance as argument
        ArrayList<String> groceries = new ArrayList<>(list);
        //This creates a mutable ArrayList populated with elements from immutable list
        groceries.add("Yogurt");
        System.out.println(groceries); //prints "[Apples, Bananas, Milk, Eggs, Yogurt]"

        //Creating ArrayList with elements in one statement
        ArrayList<String> nextList = new ArrayList<>(List.of("Pickles","Mustard", "Cheese"));

        //Adding two list together
        groceries.addAll(nextList);
        System.out.println(groceries); //prints "[Apples, Bananas, Milk, Eggs, Yogurt, Pickles, Mustard, Cheese]"

        //Accessing elements in ArrayList
        String thirdItem = groceries.get(2);
        System.out.println("Third item = " + thirdItem); //prints "Third item = Milk"

        //Checking if element is in ArrayList
        if (groceries.contains("Mustard")) {
            System.out.println("List contains mustard");
        } //prints "List contains mustard"

        //Retrieving index position
        groceries.add("Yogurt");
        System.out.println(groceries);
        //prints "[Apples, Bananas, Milk, Eggs, Yogurt, Pickles, Mustard, Cheese, Yogurt]"
        System.out.println("First = " + groceries.indexOf("Yogurt")); //prints "First = 4"
        System.out.println("Last = " + groceries.lastIndexOf("Yogurt")); //prints "Last = 8"

        //Removing elements (Either using index no. or element)
        groceries.remove(1);
        groceries.remove("Yogurt");
        System.out.println(groceries); //prints "[Apples, Milk, Eggs, Pickles, Mustard, Cheese, Yogurt]"

        //Removing a list of elements
        groceries.removeAll(List.of("Apples", "Eggs"));
        System.out.println(groceries); //prints "[Milk, Pickles, Mustard, Cheese, Yogurt]"

        //Removing a list of elements that are not specified in argument
        groceries.retainAll(List.of("Apples", "Milk", "Mustard", "Cheese"));
        System.out.println(groceries); //prints "[Milk, Mustard, Cheese]"

        //Removing all elements
        groceries.clear();
        System.out.println(groceries); //prints "[]"

        //Checking if ArrayList is empty
        System.out.println("isEmpty = " + groceries.isEmpty()); //prints "isEmpty = true"

        //Converting a list to array
        groceries.addAll(List.of("Apples", "Milk", "Mustard"));
        var groceriesArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceriesArray)); //prints "[Apples, Milk, Mustard]"

    }
}
