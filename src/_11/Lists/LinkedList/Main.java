package _11.Lists.LinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        //Declaring and instantiating a LinkedList
        LinkedList<String>  placesToVisit = new LinkedList<>();
        //or
        var placesToVisit2 = new LinkedList<String>();

        //Adding elements to LinkedList
        placesToVisit.add("Sydney");
        //Specifying index position to add element
        placesToVisit.add(0, "Canberra");

        //Printing LinkedList
        System.out.println(placesToVisit); //prints "[Canberra, Sydney]"

        //Other add methods
        placesToVisit.addFirst("Darwin"); //add element to first position
        placesToVisit.addLast("Hobart"); //add element to last position
        System.out.println(placesToVisit); //prints "[Darwin, Canberra, Sydney, Hobart]"

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);
        //prints "[Alice Springs, Brisbane, Darwin, Canberra, Sydney, Hobart, Melbourne, Toowoomba]"

        //Size of LinkedList
        System.out.println("Size of list = " + placesToVisit.size()); //prints "Size of list = 8"

        //Retrieving elements from LinkedList
        System.out.println("Retrieved element = " + placesToVisit.get(4)); //retrieve element from index position 4
        //prints "Retrieved element = Sydney"
        System.out.println("Retrieved first element = " + placesToVisit.getFirst());
        //prints "Retrieved first element = Alice Springs"
        System.out.println("Retrieved last element = " + placesToVisit.getLast());
        //prints "Retrieved last element = Toowoomba"

        //Retrieving index of elements from LinkedList
        System.out.println("Darwin is at position " + placesToVisit.indexOf("Darwin"));
        //prints "Darwin is at position 2"
        System.out.println("Melbourne is at position " + placesToVisit.indexOf("Melbourne"));
        //prints "Melbourne is at position 6"

        //other retrieval methods
        retrieveElements(placesToVisit);
        //prints
        //"Element from element() = Alice Springs"
        //"Element from peek() = Alice Springs"
        //"Element from peekFirst() = Alice Springs"
        //"Element from peekLast() = Toowoomba"

        //Removing elements
        placesToVisit.remove(4); //Removes element by their index no.
        placesToVisit.remove("Brisbane"); //Removes specified element
        System.out.println(placesToVisit); //prints "[Alice Springs, Darwin, Canberra, Hobart, Melbourne, Toowoomba]"

        String removed = placesToVisit.remove(); //removes first element and returns the removed element
        System.out.println("Removed element is " + removed); //prints "Removed element is Alice Springs"

        String removed2 = placesToVisit.removeFirst(); //removes first element and returns the removed element
        System.out.println("Removed element is " + removed2); //prints "Removed element is Darwin"

        String removed3 = placesToVisit.removeLast(); //removes last element and returns the removed element
        System.out.println("Removed element is " + removed3); //prints "Removed element is Toowoomba"

        //Other remove methods
        removeElements(placesToVisit);
        System.out.println(placesToVisit); //prints "[Brisbane, Sydney]"
    }

    private static void addMoreElements(LinkedList<String> list) {

        //Queue methods
        list.offer("Melbourne"); //add element to end of queue/list
        list.offerFirst("Brisbane"); //add element to start of queue/list
        list.offerLast("Toowoomba"); //add element to end of queue/list

        //Stack methods
        list.push("Alice Springs"); //add element to beginning of list
    }

    private static void retrieveElements(LinkedList<String> list) {

        //Queue retrieval method
        System.out.println("Element from element() = " + list.element()); //retrieve first element and returns it

        //Stack retrieval method
        System.out.println("Element from peek() = " + list.peek()); //retrieve first element and returns it
        System.out.println("Element from peekFirst() = " + list.peekFirst()); //retrieve first element and returns it
        System.out.println("Element from peekLast() = " + list.peekLast()); //retrieve last element and returns it

    }

    private static void removeElements(LinkedList<String> list) {

        //Queue/Deque poll methods
        String p1 = list.poll(); //removes first element and returns the removed element
        System.out.println("Removed element is " + p1);

        String p2 = list.pollFirst(); //removes first element and returns the removed element
        System.out.println("Removed element is " + p2);

        String p3 = list.pollLast(); //removes first element and returns the removed element
        System.out.println("Removed element is " + p3);

        //Stack pop method
        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        String p4 = list.pop(); //removes first element
    }
}
