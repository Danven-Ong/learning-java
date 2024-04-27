package _08.OOP._05.Inheritance.javalangObject;

public class Main extends Object{ //every class extends 'java.lang.Object' class by default
    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main);
        //Default toString() implementation from Object class
        System.out.println(main); //prints "_08.OOP._05.Inheritance.javalangObject.Main@65ab7765"

        Parent parent = new Parent("Tim", 34);
        System.out.println(parent); //prints "Tim is 34"

        Child child = new Child("Tim", "Alex", 8);
        //Since Parent class overrode the toString() method from Object class,
        //Child class cannot call toString() implementation from Object class, only from Parent class
        System.out.println(child); //prints "Alex is 8"
    }
}

class Parent {

    private String name;
    private int age;

    Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Overriding the toString() method that is in Object class
    @Override
    public String toString() {
        return name + " is " + age;
    }
}

//Child class inherits functionality from Parent class but it also inherits functionality from Object class indirectly
class Child extends Parent{

    private String parentName;

    Child(String parentName, String name, int age) {
        super(name, age);
        this.parentName = parentName;
    }

}
