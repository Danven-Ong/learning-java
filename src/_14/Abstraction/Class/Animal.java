package _14.Abstraction.Class;

//Creating an abstract class
public abstract class Animal {

    protected String type; //protected modifier allows subclasses to access field without getter method
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    //Creating abstract methods
    public abstract void move(String speed); //abstract methods cannot be declared with method body/code block

    public abstract void makeNoise(); //abstract methods cannot be private


    //Abstract class can have concrete methods
    public final String getExplicitType() { //final does not allow subclasses to override this method
        return getClass().getSimpleName() + " (" + type + ")";
    }
}

//Creating an abstract class that inherits another abstract class
abstract class Mammal extends Animal {

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) { //This class does not have to implement parent class abstract methods
        System.out.println(getExplicitType() + " " + (speed.equals("slow") ? "walks" : "runs"));
    }

    //This class can create its own abstract methods
    public abstract void shedHair();
}
