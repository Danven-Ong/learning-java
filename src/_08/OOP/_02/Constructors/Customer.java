package _08.OOP._02.Constructors;

public class Customer {

    
    private String name;
    private double creditLimit;
    private String email;

    //Constructors help to initialise objects of that class
    //Apply method overloading to constructors
    public Customer() {
        //'this()' calls another constructor and must be first statement in the current constructor body
        this("Nobody", "No email");
        System.out.println("Empty constructor was called");
    }

    public Customer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public Customer(String name, String email) {
        this(name, 1000, email);
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
