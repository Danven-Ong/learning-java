package _20.Constructors;

public record Person(String name, String dob) {


    //Creating a canonical constructor, declaring this explicitly would mean that a compact constructor cannot be called
//    public Person(String name, String dob) {
//        this.name = name;
//        this.dob = dob.replace("-", "/");
//    }

    //Non-canonical record constructor must be delegated to another constructor
    public Person(Person p) {
        this(p.name, p.dob);
    }

    //Creating a compact constructor (has access to named argument of the canonical constructor implicitly)
    public Person {
        if (dob == null) throw new IllegalArgumentException("Bad data");
        dob = dob.replace('-', '/');
    }
}
