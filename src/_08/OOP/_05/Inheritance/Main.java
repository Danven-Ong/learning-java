package _08.OOP._05.Inheritance;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal("Generic animal", "Large", 400);
        animalBehavior(animal, "slow");
        //prints "Generic animal moves slow",
        //"Animal{type='Generic animal', size='Large', weight=400.0}"


        //Subclasses inherits methods (eg. animal.move()) from parent class
        Dog dog = new Dog();
        animalBehavior(dog, "fast");
        //prints "Generic dog moves fast", "It was also barking", "Generic dog wants to eat",
        //"Dog{earShape='null', tailShape='null'} Animal{type='Generic dog', size='Generic size', weight=50.0}"

        Dog corgi = new Dog("Corgi", 15, "floppy", "bobbed");
        animalBehavior(corgi, "fast");
        //prints "Corgi moves fast", "It was also barking", "Corgi wants to eat",
        //"Dog{earShape='floppy', tailShape='bobbed'} Animal{type='Corgi', size='medium', weight=15.0}"

        Dog wolf = new Dog("Wolf", 45, "triangular", "bushy");
        animalBehavior(wolf, "fast");
        //prints "Wolf moves fast", "It was also howling", "Wolf wants to eat"
        //Dog{earShape='triangular', tailShape='bushy'} Animal{type='Wolf', size='large', weight=45.0}
    }

    public static void animalBehavior(Animal animal, String speed) {
        animal.move(speed);
        System.out.println(animal);
        System.out.println("---------");
    }
}
