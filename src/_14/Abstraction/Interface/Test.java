package _14.Abstraction.Interface;

public class Test {
    public static void main(String[] args) {

        Jet jet = new Jet();
        jet.transition(FlightStages.LAUNCH);
        //prints "transition not implemented on _14.Abstraction.Interface.Jet"

        //To call a static method from an interface, the interface name must be used
        OrbitalEarth.log("Some description"); //prints "Wed May 15 22:28:55 SGT 2024: Some description"
    }
}
