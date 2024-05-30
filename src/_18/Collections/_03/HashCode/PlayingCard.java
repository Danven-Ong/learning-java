package _18.Collections._03.HashCode;

public class PlayingCard {

    private String suit;
    private String face;

    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    //equals method will be executed when both object's hashCode is the same
    @Override
    public boolean equals(Object o) {
        System.out.println("equals method is executed");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;

        if (!suit.equals(that.suit)) return false;
        return face.equals(that.face);
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + face.hashCode(); //Good practice to use small prime number (double-digit) as multiplication
        return result;
    }
}
