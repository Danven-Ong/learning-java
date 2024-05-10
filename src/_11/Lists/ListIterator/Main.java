package _11.Lists.ListIterator;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        //Creating a LinkedList
        LinkedList<String> placesToVisit = new LinkedList<>();
        placesToVisit.add("Canberra");
        placesToVisit.add("Sydney");
        placesToVisit.add("Darwin");
        placesToVisit.add("Hobart");

        System.out.println(placesToVisit); //prints "[Canberra, Sydney, Darwin, Hobart]"

        //Looping through a list using ListIterator

        String previousTown = placesToVisit.getFirst();

        //Creating a ListIterator (Specifying iterator in parameter to start at index 1 onward)
        ListIterator<String> iterator = placesToVisit.listIterator(1);

        //Iterating through the list
        while (iterator.hasNext()) { //returns true if there is next element else false
            String town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        //prints
        //"--> From: Canberra to Sydney"
        //"--> From: Sydney to Darwin"
        //"--> From: Darwin to Hobart"

        //Mutating list while iterating through list
        var iterator2 = placesToVisit.listIterator();
        while (iterator2.hasNext()) {

            if (iterator2.next().equals("Darwin")) {
                iterator2.remove(); //placesToVist.remove() will not work
            }

            if (iterator2.next().equals("Hobart")) {
                iterator2.add("Brisbane");
            }
        }
        System.out.println(placesToVisit); //prints "[Canberra, Sydney, Hobart, Brisbane]"

        //Note iterator will not run after it has finished iterating previously
        System.out.println(iterator2.hasNext()); //prints "false"

        while (iterator2.hasNext()) { //condition is always false
            System.out.println("Iterating through list...");
            System.out.println(iterator2.next());
        } //No output

        //Iterating backwards in list
        while (iterator2.hasPrevious()) { //condition is always false
            System.out.println(iterator2.previous());
        }
        //prints
        //"Brisbane"
        //"Hobart"
        //"Sydney"
        //"Canberra"
    }
}
