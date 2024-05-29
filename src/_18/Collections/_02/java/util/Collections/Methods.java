package _18.Collections._02.java.util.Collections;

import java.util.*;

public class Methods {
    public static void main(String[] args) {

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);
        //prints
        //"Aces of Hearts"
        //"A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12)"

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards); //prints "[]"
        System.out.println("cards.size() = " + cards.size()); //prints "cards.size() = 0"

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);
        //prints
        //"Aces of Hearts"
        //"A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12)"

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);
        //prints
        //"Kings of Clubs"
        //"K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11)"

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);
        //prints
        //"Card Collection with Aces added"
        //"A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12)"
        //"A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12)"

        Collections.copy(cards, kingsOfClubs); //Does not return a copy of list
        Card.printDeck(cards, "Card Collection with Kings copied", 2);
        //prints
        //"Card Collection with Kings copied"
        //"K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11)"
        //"A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12)"


        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
        //prints
        //"2♣(0) 3♣(1) 4♣(2) 5♣(3) 6♣(4) 7♣(5) 8♣(6) 9♣(7) 10♣(8) J♣(9) Q♣(10) K♣(11) A♣(12)"
        //"2♦(0) 3♦(1) 4♦(2) 5♦(3) 6♦(4) 7♦(5) 8♦(6) 9♦(7) 10♦(8) J♦(9) Q♦(10) K♦(11) A♦(12)"
        //"2♥(0) 3♥(1) 4♥(2) 5♥(3) 6♥(4) 7♥(5) 8♥(6) 9♥(7) 10♥(8) J♥(9) Q♥(10) K♥(11) A♥(12)"
        //"2♠(0) 3♠(1) 4♠(2) 5♠(3) 6♠(4) 7♠(5) 8♠(6) 9♠(7) 10♠(8) J♠(9) Q♠(10) K♠(11) A♠(12)"

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);
        //prints
        //"Shuffled Deck"
        //"9♥(7) 9♣(7) K♦(11) 8♣(6) J♣(9) J♥(9) 3♥(1) 10♦(8) 6♠(4) A♠(12) 5♣(3) K♥(11) Q♥(10)"
        //"5♠(3) 2♠(0) J♦(9) 7♥(5) 4♠(2) 4♦(2) 7♠(5) 2♣(0) 10♥(8) 4♣(2) 2♦(0) K♠(11) 5♥(3)"
        //"Q♦(10) 10♠(8) 3♣(1) 3♦(1) 8♥(6) A♥(12) 2♥(0) 3♠(1) 7♣(5) 6♣(4) 7♦(5) Q♣(10) 9♠(7)"
        //"A♣(12) 8♠(6) 6♦(4) K♣(11) 9♦(7) Q♠(10) J♠(9) 10♣(8) 4♥(2) A♦(12) 5♦(3) 8♦(6) 6♥(4)"

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck Of Cards", 4);
        //prints
        //"Reversed Deck Of Cards"
        //"6♥(4) 8♦(6) 5♦(3) A♦(12) 4♥(2) 10♣(8) J♠(9) Q♠(10) 9♦(7) K♣(11) 6♦(4) 8♠(6) A♣(12)"
        //"9♠(7) Q♣(10) 7♦(5) 6♣(4) 7♣(5) 3♠(1) 2♥(0) A♥(12) 8♥(6) 3♦(1) 3♣(1) 10♠(8) Q♦(10)"
        //"5♥(3) K♠(11) 2♦(0) 4♣(2) 10♥(8) 2♣(0) 7♠(5) 4♦(2) 4♠(2) 7♥(5) J♦(9) 2♠(0) 5♠(3)"
        //"Q♥(10) K♥(11) 5♣(3) A♠(12) 6♠(4) 10♦(8) 3♥(1) J♥(9) J♣(9) 8♣(6) K♦(11) 9♣(7) 9♥(7)"

        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);
        //prints
        //"Standard Deck sorted by rank, suit"
        //"2♣(0) 2♦(0) 2♥(0) 2♠(0)"
        //"3♣(1) 3♦(1) 3♥(1) 3♠(1)"
        //"4♣(2) 4♦(2) 4♥(2) 4♠(2)"
        //"5♣(3) 5♦(3) 5♥(3) 5♠(3)"
        //"6♣(4) 6♦(4) 6♥(4) 6♠(4)"
        //"7♣(5) 7♦(5) 7♥(5) 7♠(5)"
        //"8♣(6) 8♦(6) 8♥(6) 8♠(6)"
        //"9♣(7) 9♦(7) 9♥(7) 9♠(7)"
        //"10♣(8) 10♦(8) 10♥(8) 10♠(8)"
        //"J♣(9) J♦(9) J♥(9) J♠(9)"
        //"Q♣(10) Q♦(10) Q♥(10) Q♠(10)"
        //"K♣(11) K♦(11) K♥(11) K♠(11)"
        //"A♣(12) A♦(12) A♥(12) A♠(12)"

        Collections.reverse(deck);
        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

        //Identify index of sub-list that exist in the bigger list
        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex); //prints "sublist index for tens = 16"

        //Checking if two collections share elements (return false if they do)
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println(disjoint); //prints "false"

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println(disjoint2); //prints "true"

        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        deck.sort(sortingAlgorithm); //list must be sorted before executing binarySearch method
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println(foundIndex); //prints "34"
        System.out.println(deck.get(foundIndex)); //prints "10♥(8)"

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts); //boolean return type (true if successful)
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);
        //prints "10♥(8) 10♦(8) 10♥(8) 10♠(8)"

        //Checking for duplicates in collection
        System.out.println("Ten of Hearts Cards = " +
                Collections.frequency(deck, tenOfHearts)); //prints "Ten of Hearts Cards = 2"

        System.out.println("Best Card = " + Collections.max(deck, sortingAlgorithm));
        //prints "Best Card = A♠(12)"
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgorithm));
        //prints "Worst Card = 2♣(0"

        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);

        deck.sort(sortBySuit);
        Card.printDeck(deck);

        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 2); //moves specified positive number from end of list to start of list
        System.out.println("Unrotated: " + deck.subList(0, 13));
        //prints "Unrotated: [2♣(0), 3♣(1), 4♣(2), 5♣(3), 6♣(4), 7♣(5), 8♣(6), 9♣(7), J♣(9), Q♣(10), K♣(11), A♣(12), 2♦(0)]"
        System.out.println("Rotated: " + copied);
        //prints "Rotated: [A♣(12), 2♦(0), 2♣(0), 3♣(1), 4♣(2), 5♣(3), 6♣(4), 7♣(5), 8♣(6), 9♣(7), J♣(9), Q♣(10), K♣(11)]"

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, -2); //moves specified negative number from start of list to end of list
        System.out.println("Unrotated: " + deck.subList(0, 13));
        //prints "Unrotated: [2♣(0), 3♣(1), 4♣(2), 5♣(3), 6♣(4), 7♣(5), 8♣(6), 9♣(7), J♣(9), Q♣(10), K♣(11), A♣(12), 2♦(0)]"
        System.out.println("Rotated: " + copied);
        //prints "Rotated: [4♣(2), 5♣(3), 6♣(4), 7♣(5), 8♣(6), 9♣(7), J♣(9), Q♣(10), K♣(11), A♣(12), 2♦(0), 2♣(0), 3♣(1)]"

        copied = new ArrayList<>(deck.subList(0, 13));
        for (int i = 0; i < copied.size() / 2; i++) {
            Collections.swap(copied, i, copied.size() -1 - i); //swapping two elements in a collection
        }
        System.out.println("Manual reverse :" + copied);
        //prints "Manual reverse :[2♦(0), A♣(12), K♣(11), Q♣(10), J♣(9), 9♣(7), 8♣(6), 7♣(5), 6♣(4), 5♣(3), 4♣(2), 3♣(1), 2♣(0)]"
    }
}
