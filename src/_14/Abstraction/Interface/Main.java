package _14.Abstraction.Interface;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird();
        //bird object can have many reference type
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        //Only variables with their specific reference type can access their method
        animal.move(); //prints "Flaps wings" (flier.move() or tracked.move() will not work)
        flier.takeOff(); //prints "Bird is taking off"
        flier.fly(); //prints "Bird is flying"
        tracked.track(); //prints "Bird's coordinates recorded"
        flier.land(); //prints "Bird is landing"

        //instanceof keyword supports testing interface type
        if (flier instanceof Trackable track) {
            track.track();
        } //prints "Bird's coordinates recorded"

        if (bird instanceof FlightEnabled) {
            System.out.println("Bird can fly!");
        } else {
            System.out.println("Bird cannot fly!");
        }

        inFlight(new Jet());
        //prints
        //"Jet is taking off"
        //"Jet is flying"
        //"Jet's coordinates recorded"
        //"Jet is landing"

        double kmsTravelled = 100;
        double milesTravelled = kmsTravelled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The jet travelled %.2f km or %.2f miles%n",
                kmsTravelled, milesTravelled);
        //prints "The jet travelled 100.00 km or 62.14 miles"
    }

    //This method accepts classes that implement FlightEnabled
    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }
}
