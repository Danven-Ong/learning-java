package _14.Abstraction.Class;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Abstract classes cannot be instantiated

        //Instantiating the subclass that inherits from abstract class
        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise(); //prints "Howling!"

        doAnimalStuff(dog);
        //prints
        //"Howling!"
        //"Dog (Wolf) walking"

        //List accepts abstract class types
        ArrayList<Animal> animals = new ArrayList<>(); //ArrayList of abstracted type
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 150));
        animals.add(new Horse("Clydesdale", "large", 1000));

        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal) {
                currentMammal.shedHair();
            }
            System.out.println("-".repeat(20));
        }
        //prints
        //"Howling!"
        //"Dog (Wolf) walking"
        //"--------------------"
        //"Woof!"
        //"Dog (German Shepard) walking"
        //"--------------------"
        //"Swish!"
        //"Fish (Goldfish) swimming"
        //"--------------------"
        //"Horse (Clydesdale) walks"
        //"Horse (Clydesdale) sheds in the spring"
        //"--------------------"
    }


    //Methods can accept abstract class types as an argument
    private static void doAnimalStuff(Animal animal) {

        animal.makeNoise();
        animal.move("slow");
    }
}
