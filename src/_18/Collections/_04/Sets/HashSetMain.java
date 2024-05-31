package _18.Collections._04.Sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        printData("Phone List", phones);
        //prints
        //"Phone List"
        //"----------------------------------------------"
        //"Charlie Brown: [] [(333) 444-5555]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Mickey Mouse: [] [(124) 748-9758]"
        //"Minnie Mouse: [] [(456) 780-5666]"
        //"Robin Hood: [] [(564) 789-3000]"
        //"Robin Hood: [] [(789) 902-8222]"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"----------------------------------------------"

        printData("Email List", emails);
        //prints
        //"Email List"
        //"----------------------------------------------"
        //"Mickey Mouse: [mckmouse@gmail.com] []"
        //Mickey Mouse: [micky1@aws.com] []"
        //"Minnie Mouse: [minnie@verizon.net] []"
        //"Robin Hood: [rhood@gmail.com] []"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Daffy Duck: [daffy@google.com] []"
        //"----------------------------------------------"


        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone Contacts", phoneContacts);
        //prints
        //"Phone Contacts"
        //"----------------------------------------------"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Charlie Brown: [] [(333) 444-5555]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Robin Hood: [] [(564) 789-3000]"
        //"Mickey Mouse: [] [(999) 888-7777]"
        //"Minnie Mouse: [] [(456) 780-5666]"
        //"----------------------------------------------"
        printData("Email Contacts", emailContacts);
        //prints
        //Email Contacts
        //"----------------------------------------------"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //Robin Hood: [rhood@gmail.com] []"
        //"Mickey Mouse: [mckmouse@gmail.com] []"
        //"Daffy Duck: [daffy@google.com] []"
        //"Minnie Mouse: [minnie@verizon.net] []"
        //"----------------------------------------------"

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        System.out.println(robinHood); //prints "Robin Hood: [rhood@gmail.com] []"

        robinHood.addEmail("Maxmega");
        System.out.println(robinHood); //prints "Robin Hood: [RHood@maxmega.com, rhood@gmail.com] []"

        robinHood.addEmail("maxmega"); //prints "Robin Hood already has email RHood@maxmega.com"
        System.out.println(robinHood); //prints "Robin Hood: [RHood@maxmega.com, rhood@gmail.com] []"

        robinHood.replaceEmailIfExist("RHood@maxmega.com", "RHood@maxmega.org");
        System.out.println(robinHood); //prints "Robin Hood: [RHood@maxmega.org, rhood@gmail.com] []"

        //Symmetric operations
        //Union set operation
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts); //returns union of unique names
        printData("(A ∪ B) Union of emails (A) with phones (B)",
                unionAB);
        //prints
        //"(A ∪ B) Union of emails (A) with phones (B)"
        //"----------------------------------------------"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Charlie Brown: [] [(333) 444-5555]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"Robin Hood: [RHood@maxmega.org, rhood@gmail.com] []"
        //"Mickey Mouse: [mckmouse@gmail.com] []"
        //"Daffy Duck: [daffy@google.com] []"
        //"Minnie Mouse: [minnie@verizon.net] []"
        //"----------------------------------------------"

        //Intersection set operation
        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts); //Duplicates from intersection will not replace existing elements in the HashSet
        printData("(A ∩ B) Intersect emails (A) and phones (B)",
                intersectAB); //returns intersection of the names in both contacts
        //prints
        //"(A ∩ B) Intersect emails (A) and phones (B)"
        //"----------------------------------------------"
        //"Robin Hood: [RHood@maxmega.org, rhood@gmail.com] []"
        //"Mickey Mouse: [mckmouse@gmail.com] []"
        //"Minnie Mouse: [minnie@verizon.net] []"
        //"----------------------------------------------"

        //Asymmetric operations
        //Subtraction set operation
        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)",
                AMinusB); //returns names that are only in email contacts and not in phone contacts
        //prints
        //"(A - B) emails (A) - phones (B)"
        //"----------------------------------------------"
        //"Linus Van Pelt: [lvpelt2015@gmail.com] []"
        //"Daffy Duck: [daffy@google.com] []"
        //"----------------------------------------------"

        Set<Contact> BMinusA = new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);
        printData("(B - A)  phones (B) - emails (A)",
                BMinusA); //returns names that are only in email contacts and not in phone contacts
        //prints
        //"(B - A)  phones (B) - emails (A)"
        //"----------------------------------------------"
        //"Lucy Van Pelt: [] [(564) 208-6852]"
        //"Charlie Brown: [] [(333) 444-5555]"
        //"Maid Marion: [] [(123) 456-7890]"
        //"----------------------------------------------"
    }


    public static void printData(String header, Collection<Contact> contacts) {

        System.out.println(header);
        System.out.println("----------------------------------------------");
        contacts.forEach(System.out::println);
        System.out.println("----------------------------------------------");
    }
}
