package _14.Abstraction.Interface;

interface FlightEnabled { //abstract modifier is unnecessary

    //Interfaces can have its constants (fields that are implicitly public, static and final)
    public static final double MILES_TO_KM = 1.60934; //public, static, final modifiers are unnecessary
     double KM_TO_MILES = 0.621371;

    //Interface can have its own abstract method (Implicitly declared both public and abstract)
    public abstract void takeOff(); //public and abstract is unnecessary

    abstract void land(); //abstract is unnecessary

    void fly();


    //Creating default method (JDK 8)
    //(A new added method to interface without breaking classes that already implemented those interfaces)
    //Provides a default behavior that can be overridden by classes that implement the interface but not mandatory
    default FlightStages transition(FlightStages stage) { //default methods are implicitly public
        System.out.println("transition not implemented on " + this.getClass().getName());
        return null;
    }

}

interface Trackable {

    void track();
}
public abstract class Animal implements FlightEnabled{

    public abstract void move();
}

//interface can be extended with another interface
interface OrbitalEarth extends FlightEnabled {

    void achieveOrbit();

    //Interfaces can have static methods (JDK 8) and private methods (JDK9)
    //static method in interfaces are implicitly public unless stated otherwise
    public static void log(String description) {

        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {

        description = stage + ": " + description;
        log(description);
    }

}

class Satelite implements OrbitalEarth {

    //This class has to implement abstract methods from OrbitalEarth and from its extended interface
    @Override
    public void achieveOrbit() {
        System.out.println("Orbit achieved");
    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

//record or enum types can also implement interfaces
record DragonFly(String name, String type) implements FlightEnabled {

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

enum FlightStages implements Trackable {

    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }
    }
