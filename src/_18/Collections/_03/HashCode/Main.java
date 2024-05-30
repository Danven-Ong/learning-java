package _18.Collections._03.HashCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //both aText and bText have the same object memory address
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l","He","lo");
        String dText = "He".concat("llo");
        //All these variables above have same hashcode

        String eText = "hello";


        List<String> hellos =
                Arrays.asList(aText, bText, cText, dText, eText);

        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));
        //prints
        //"Hello: 69609650"
        //"Hello: 69609650"
        //"Hello: 69609650"
        //"Hello: 69609650"
        //"hello: 99162322"

        Set<String> mySet = new HashSet<>(hellos);

        System.out.println("mySet = " + mySet); //prints "mySet = [Hello, hello]"
        System.out.println("# of elements = " + mySet.size()); //prints "# of elements = 2"

        for (String setValue : mySet) {
            System.out.print(setValue + ": ");
            for (int i = 0; i < hellos.size(); i++) {
                if (setValue == hellos.get(i)) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println(" ");
        }
        //prints
        //"Hello: 0, 1,"
        //"hello: 4,"

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");
        PlayingCard aceHeartsDupe = new PlayingCard("Hearts", "Ace");


        List<PlayingCard> cards =
                Arrays.asList(aceHearts, kingClubs, queenSpades, aceHeartsDupe);
        cards.forEach(s -> System.out.println(s + ": " + s.hashCode()));
        //prints
        //"Ace of Hearts: -1834509066"
        //"King of Clubs: 2023815418"
        //"Queen of Spades: -269088580"
        //"Ace of Hearts: -1834509066"

        Set<PlayingCard> deck = new HashSet<>();
        for (PlayingCard c : cards) {
            if (!deck.add(c)) {
                System.out.println("Found a duplicate for " + c);
            }
        }
        //prints
        //"equals method is executed"
        //"Found a duplicate for Ace of Hearts"
        System.out.println(deck); //prints "[Ace of Hearts, King of Clubs, Queen of Spades]"
    }
}
