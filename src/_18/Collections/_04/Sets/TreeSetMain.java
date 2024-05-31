package _18.Collections._04.Sets;

import java.util.*;

public class TreeSetMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        //TreeSet must accept elements that implements Comparable interface or Comparator
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);
        //prints
        //"Charlie Brown: [] [(333) 444-5555]"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Minnie Mouse: [] [(456) 780-5666]"
        //"Robin Hood: [] [(564) 789-3000]"

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);
        //prints "[Charlie Brown, Lucy Van Pelt, Maid Marion, Mickey Mouse, Minnie Mouse, Robin Hood]"

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);
        //prints
        //"Charlie Brown: [] [(333) 444-5555]"
        //"Daffy Duck: [daffy@google.com] []"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Minnie Mouse: [] [(456) 780-5666]"
        //"Robin Hood: [] [(564) 789-3000]"

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        fullList.forEach(System.out::println);
        //prints
        //"Charlie Brown: [] [(333) 444-5555]"
        //"Daffy Duck: [daffy@google.com] []"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Mickey Mouse: [] [(124) 748-9758]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Mickey Mouse: [mckmouse@gmail.com] []"
        //"Mickey Mouse: [micky1@aws.com] []"
        //"Minnie Mouse: [] [(456) 780-5666]"
        //"Minnie Mouse: [minnie@verizon.net] []"
        //"Robin Hood: [] [(564) 789-3000]"
        //"Robin Hood: [] [(789) 902-8222]"
        //"Robin Hood: [rhood@gmail.com] []"

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.printf("min = %s, first=%s %n", min.getName(), first.getName());
        //prints "min = Charlie Brown, first=Charlie Brown "
        System.out.printf("max = %s, last=%s %n", max.getName(), last.getName());
        //prints "max = Robin Hood, last=Robin Hood "

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First element = " + copiedSet.pollFirst());
        //prints "First element = Charlie Brown: [] [(333) 444-5555]"
        System.out.println("Last element = " + copiedSet.pollLast());
        //prints "Last element = Robin Hood: [] [(564) 789-3000]"
        copiedSet.forEach(System.out::println);
        //prints
        //"Daffy Duck: [daffy@google.com] []"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Minnie Mouse: [] [(456) 780-5666]"

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        //Utilizing TreeSet ceiling and higher methods
        for (Contact c : List.of(daffy, daisy, last, snoopy)) {
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }
        //prints
        //"ceiling(Daffy Duck)=Daffy Duck: [daffy@google.com] []"
        //"higher(Daffy Duck)=Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"ceiling(Daisy Duck)=Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"higher(Daisy Duck)=Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"ceiling(Robin Hood)=Robin Hood: [] [(564) 789-3000]"
        //"higher(Robin Hood)=null"
        //"ceiling(Snoopy)=null"
        //"higher(Snoopy)=null"

        //Utilizing TreeSet floor and lower methods
        for (Contact c : List.of(daffy, daisy, first, archie)) {
            System.out.printf("floor(%s)=%s%n", c.getName(), fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));
        }
        //prints
        //"floor(Daffy Duck)=Daffy Duck: [daffy@google.com] []"
        //"lower(Daffy Duck)=Charlie Brown: [] [(333) 444-5555]"
        //"floor(Daisy Duck)=Daffy Duck: [daffy@google.com] []"
        //"lower(Daisy Duck)=Daffy Duck: [daffy@google.com] []"
        //"floor(Charlie Brown)=Charlie Brown: [] [(333) 444-5555]"
        //"lower(Charlie Brown)=null"
        //"floor(Archie)=null"
        //"floor(Archie)=null
        //lower(Archie)=null"

        //Reversing sorting order of TreeSet
        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        //prints
        //"Robin Hood: [] [(564) 789-3000]"
        //"Minnie Mouse: [] [(456) 780-5666]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Daffy Duck: [daffy@google.com] []"
        //"Charlie Brown: [] [(333) 444-5555]"

        //Utilizing pollLast method
        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed " + lastContact);

        //prints "Removed Charlie Brown: [] [(333) 444-5555]"
        descendingSet.forEach(System.out::println);
        //prints
        //"Robin Hood: [] [(564) 789-3000]"
        //"Minnie Mouse: [] [(456) 780-5666]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Daffy Duck: [daffy@google.com] []"

        fullSet.forEach(System.out::println); //Mutating descending set affects original set
        //prints
        //"Daffy Duck: [daffy@google.com] []"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Minnie Mouse: [] [(456) 780-5666]"
        //"Robin Hood: [] [(564) 789-3000]"

        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion, true);
        headSet.forEach(System.out::println);
        //prints
        //"Daffy Duck: [daffy@google.com] []"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Maid Marion: [] [(123) 456-7890]"

        var tailSet = fullSet.tailSet(marion, false);
        tailSet.forEach(System.out::println);
        //prints
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Minnie Mouse: [] [(456) 780-5666]"
        //"Robin Hood: [] [(564) 789-3000]"

        Contact linus = new Contact("Linus Van Pelt");
        var subset = fullSet.subSet(
                linus, false, marion, true);
        subset.forEach(System.out::println);
        //prints
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Maid Marion: [] [(123) 456-7890]"

    }
}
