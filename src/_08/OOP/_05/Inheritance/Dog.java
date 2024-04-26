package _08.OOP._05.Inheritance;

//use of keyword "extends" to inherit parent class
public class Dog extends Animal{

    private String earShape;
    private String tailShape;

    //creating an empty constructor
    public Dog() {
        //super() calls the constructor of the parent class, similar to this()
        super("Generic dog", "Generic size", 50);
    }


    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    //Methods in parent class can be overridden by methods in subclasses
    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    //Overriding move method in Animal class
    @Override
    public void move(String speed) {
        super.move(speed);
        //field "type" is accessible due as it has protected access modifier
        if (type.equals("Wolf")) {
            makeNoise("Howling");
        } else {
            makeNoise("Barking");
        }
        //Calling method form parent class
        eat();
    }

    //Private method for Dog class
    private void makeNoise(String sound) {
        System.out.println("It was also " + sound);
    }
}
