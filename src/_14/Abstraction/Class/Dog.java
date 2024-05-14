package _14.Abstraction.Class;

public class Dog extends Animal{

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    //subclass that inherits from abstract class must implement abstract methods from parent class
    @Override
    public void move(String speed) {

        if (speed.equals("slow")) {
            System.out.println(getExplicitType() + " walking");
        } else {
            System.out.println(getExplicitType() + " running");
        }
    }

    @Override
    public void makeNoise() {

        if (type.equals("Wolf")) {
            System.out.println("Howling!");
        } else {
            System.out.println("Woof!");
        }

    }
}
