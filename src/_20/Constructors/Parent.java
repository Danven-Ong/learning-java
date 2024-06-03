package _20.Constructors;

public class Parent {

    //Final variables must be initialized
    private final String name;
    private final String dob;
    protected final int siblings;


    //Creating a static initializer (executed for one time when class is referenced or constructed)
    //A class can have a number of static initialization blocks and appear in the order they appear in code
    static {
       System.out.println("In Parent static initializer");
    }

    //Creating an initializer (executed before any code in class constructors is executed)
    {
        System.out.println("In Parent initializer");
    }

    public Parent(String name, String dob, int siblings) {
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        System.out.println("In Parent constructor");
    }

    public String getName() {
        return name;
    }
    public String getDob() {
        return dob;
    }


    @Override
    public String toString() {
        return "name='" + name + '\'' + ", dob='" + dob + '\'';
    }
}
