package _19.Mutability.ImmutableClass;

public class Main {
    public static void main(String[] args) {

        Person jane = new Person("Jane", "01/01/1930");
        Person jim = new Person("Jim", "02/02/1932");
        Person joe = new Person("Joe", "03/03/1934");

        Person[] johnsKids = {jane, jim, joe};
        Person john = new Person("John", "05/05/1900", johnsKids);

        System.out.println(john); //prints "John, dob = 05/05/1900, kids = Jane,Jim,Joe"

        Person[] kids = john.getKids();
        kids[0] = jim;
        kids[1] = new Person("Ann", "04/04/1936");
        System.out.println(john); //prints "John, dob = 05/05/1900, kids = Jane,Jim,Joe"

        johnsKids[0] = new Person("Ann", "04/04/1936");
        System.out.println(john); //prints "John, dob = 05/05/1900, kids = Jane,Jim,Joe"

        LivingPerson johnLiving = new LivingPerson(john.getName(), john.getKids());
        System.out.println(johnLiving); //prints "John, dob = null, kids = Jane,Jim,Joe,,,,,,,"

        LivingPerson ann = new LivingPerson("Ann", null);
        johnLiving.addKid(ann);
        System.out.println(johnLiving); //prints "John, dob = null, kids = Jane,Jim,Joe,Ann,,,,,,"

        PersonOfInterest johnCopy = new PersonOfInterest(john);
        System.out.println(johnCopy); //prints "John, dob = 05/05/1900, kids = Jane,Jim,Joe"

        kids = johnCopy.getKids();
        kids[1] = ann;
        System.out.println(johnCopy); //prints "John, dob = 05/05/1900, kids = Jane,Jim,Joe"
        System.out.println(john); //prints "John, dob = 05/05/1900, kids = Jane,Jim,Joe"
    }
}
