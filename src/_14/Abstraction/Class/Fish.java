package _14.Abstraction.Class;

public class Fish extends Animal{


    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    //subclass that inherits from abstract class must implement abstract methods from parent class
    @Override
    public void move(String speed) {

        if (speed.equals("slow")) {
            System.out.println(getExplicitType() + " swimming");
        } else {
            System.out.println(getExplicitType() + " darting frantically");
        }
    }

    @Override
    public void makeNoise() {

        if (type.equals("Goldfish")) {
            System.out.println("Swish!");
        } else {
            System.out.println("Splash!");
        }

    }
}
