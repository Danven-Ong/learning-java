package _19.Mutability.ImmutableClass;

import java.util.Arrays;

//Creating an immutable class
public class Person {

    //Make all instance fields private and final
    private final String name;
    private final String dob;
    protected final Person[] kids;

    //Create defensive copies in constructors
    public Person(String name, String dob, Person[] kids) {
        this.name = name;
        this.dob = dob;
        //Ensure array returned is copy and original array is not altered
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    public Person(String name, String dob) {
        this(name, dob, null);
    }

    //This protected constructor allows subclass to construct a new copy of person
    protected Person(Person person) {
        this(person.getName(), person.getDob(), person.getKids()); //Ensure original constructor with defensive copy is called
    }

    //No setter methods

    public String getName() {
        return name;
    }


    public String getDob() {
        return dob;
    }

    //Create defensive copies in any getters
    //Ensure method cannot be overridden
    public final Person[] getKids() { //This getter returns an array which is mutable
        //Ensure array returned is copy and original array is not altered
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    @Override
    public String toString() {

        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(",", names);
        }
        return name + ", dob = " + getDob() + ", kids = " + kidString;
    }
}
