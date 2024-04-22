package _08.OOP._03.InstanceAndStatic;

public class Main {
    public static void main(String[] args) {

        Person tim = new Person("Tim", "Tim");
        Person alex = new Person("Alex", "Alex");

        tim.printName(); //prints "Static name is Alex", "Instance name is Tim"
        alex.printName(); //prints "Static name is Alex", "Instance name is Alex"

        //static methods are called as ClassName.methodName() or methodName if in same class
        Person.staticMethod(); //prints "Static method is called"
        staticMethodTwo(); //prints "Second Static method is called"

        //instance methods are called as InstanceName.methodName()
        tim.instanceMethod(); //prints "Instance method is called", "Tim"
        alex.instanceMethod(); //prints "Instance method is called", "Alex"
    }

    public static void staticMethodTwo() {
        System.out.println("Second Static method is called");
    }
}
