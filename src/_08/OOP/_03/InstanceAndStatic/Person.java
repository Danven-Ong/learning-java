package _08.OOP._03.InstanceAndStatic;

public class Person {

    private static String staticName; //creating a static variable
    private String instanceName; //creating an instance variable

    public Person(String staticName, String instanceName) {
        Person.staticName = staticName; //Best practice to use the Class name 'Person' and not a reference variable
        this.instanceName = instanceName;
    }

    public void printName() {
        System.out.println("Static name is " + Person.staticName);
        System.out.println("Instance name is " + instanceName);
    }

    //Static method
    //Methods should be static if it does not use any fields (instance variables) or instance methods
    public static void staticMethod() {
        System.out.println("Static method is called");
    }

    //Instance method
    public void instanceMethod() {
        System.out.println("Instance method is called");
        System.out.println(instanceName);
    }
}
