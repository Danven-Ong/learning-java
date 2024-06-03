package _20.Constructors;

public class Main {
    public static void main(String[] args) {

        Parent parent = new Parent("Jane", "01/01/1950", 4);
        //prints
        //"In Parent initializer"
        //"In Parent constructor"

        Child child = new Child();
        //prints
        //"In Parent initializer"
        //"In Parent constructor"
        //"In Child initializer, birthOrder = 5, birthOrderString = Middle"
        //"In Child constructor"

        System.out.println("Parent: " + parent); //prints "Parent: name='Jane', dob='01/01/1950'"
        System.out.println("Child: " + child); //prints "Child: name='Jane', dob='02/02/1920', Middle child"

        Person joe = new Person("Joe", "01-91-1950");
        System.out.println(joe); //prints "Person[name=Joe, dob=01/91/1950]"

        Person joeCopy = new Person(joe);
        System.out.println(joeCopy); //prints "Person[name=Joe, dob=01/91/1950]"

        //When enum is initialized, all its constants is initialized
        Generation g = Generation.BABY_BOOMER;
        //prints
        //"GEN_Z 2001 - 2024"
        //"-- SPECIAL FOR GEN_Z --"
        //"MILLENNIAL 1981 - 2000"
        //"GEN_X 1965 - 1980"
        //"BABY_BOOMER 1946 - 1964"
        //"SILENT_GENERATION 1927 - 1945"
        //"GREATEST_GENERATION 1901 - 1926"

    }
}
