package _18.Collections._01.Overview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        //Example of a class with Collection interface
        Collection<String> list = new ArrayList<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));
        System.out.println(list); //prints "[Anna, Bob, Carol, David, Edna]"

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(list); //prints "[Anna, Bob, Carol, David, Edna, Fred, George, Gary, Grace]"
        System.out.println("Gary is in the list? " + list.contains("Gary")); //prints "Gary is in the list? true"

        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(list); //prints "[Anna, Bob, Carol, David, Edna, Fred]"
        System.out.println("Gary is in the list? " + list.contains("Gary")); //prints "Gary is in the list? false"

        //Other similar class with Collection interface also have the same methods
        Collection<String> treeSet = new TreeSet<>();

        treeSet.addAll(Arrays.asList(names));
        System.out.println(treeSet); //prints "[Anna, Bob, Carol, David, Edna]"

        treeSet.add("Fred");
        treeSet.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(treeSet); //prints "[Anna, Bob, Carol, David, Edna, Fred, George, Gary, Grace]"
        System.out.println("Gary is in the list? " + treeSet.contains("Gary")); //prints "Gary is in the list? true"

        treeSet.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(treeSet); //prints "[Anna, Bob, Carol, David, Edna, Fred]"
        System.out.println("Gary is in the list? " + treeSet.contains("Gary")); //prints "Gary is in the list? false"
    }
}
