package _19.Mutability.Copies;

import java.util.Arrays;

record Person (String name, String dob, Person[] kids) {

    public Person(Person p) {
        this(p.name, p.dob,
                p.kids == null ? null : Arrays.copyOf(p.kids, p.kids.length));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {

        Person joe = new Person("Joe", "01/01/1961", null);
        Person jim = new Person("Jim", "02/02/1962", null);
        Person jack = new Person("Jack", "03/03/1963",
                new Person[] {joe, jim});
        Person jane = new Person("Jane", "04/04/1964", null);
        Person jill = new Person("Jill", "05/05/1965",
                new Person[] {joe, jim});

        Person[] persons = {joe, jim, jack, jane, jill};

        //Creating a shallow copy
        Person[] personsCopy = Arrays.copyOf(persons, persons.length);

        var jillsKids = personsCopy[4].kids();
        jillsKids[1] = jane;

        for (int i = 0; i < 5; i++) {
            if (persons[i] == personsCopy[i]) {
                System.out.println("Equal References " + persons[i]);
            }
        }
        //prints
        //"Equal References Person{name='Joe', dob='01/01/1961', kids=null}"
        //"Equal References Person{name='Jim', dob='02/02/1962', kids=null}"
        //"Equal References Person{name='Jack', dob='03/03/1963', kids=[Person{name='Joe', dob='01/01/1961', kids=null}, Person{name='Jim', dob='02/02/1962', kids=null}]}"
        //"Equal References Person{name='Jane', dob='04/04/1964', kids=null}"
        //"Equal References Person{name='Jill', dob='05/05/1965', kids=[Person{name='Joe', dob='01/01/1961', kids=null}, Person{name='Jane', dob='04/04/1964', kids=null}]}"

        System.out.println();
        jillsKids[1] = jim;
        for (int i = 0; i < 5; i++) {
            if (persons[i] == personsCopy[i]) {
                System.out.println("Equal References " + persons[i]);
            }
        }
        System.out.println();
        //Creating a deep copy
        Person[] personsDeepCopy = new Person[5];

        //Method one
//        for (int i = 0; i < 5; i++) {
//            Person current = persons[i];
//            var kids = current.kids() == null ? null :
//                    Arrays.copyOf(current.kids(), current.kids().length); //Creating a defensive copy
//            personsDeepCopy[i] = new Person(current.name(), current.dob(), kids);
//        }
        //Method two
//        for (int i = 0; i < 5; i++) {
//            personsDeepCopy[i] = new Person(persons[i]);
//        }

        //Method three
        Arrays.setAll(personsDeepCopy, i -> new Person(persons[i]));

        var jillsKids2 = personsDeepCopy[4].kids();
        jillsKids2[1] = jane;

        for (int i = 0; i < 5; i++) {
            if (persons[i] == personsDeepCopy[i]) {
                System.out.println("Equal References " + persons[i]);
            }
        } //prints ""

        System.out.println(personsDeepCopy[4]);
        //prints "Person{name='Jill', dob='05/05/1965', kids=[Person{name='Joe', dob='01/01/1961', kids=null}, Person{name='Jane', dob='04/04/1964', kids=null}]}"
        System.out.println(persons[4]);
        //prints "Person{name='Jill', dob='05/05/1965', kids=[Person{name='Joe', dob='01/01/1961', kids=null}, Person{name='Jim', dob='02/02/1962', kids=null}]}"
    }
}
