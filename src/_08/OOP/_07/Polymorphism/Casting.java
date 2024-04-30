package _08.OOP._07.Polymorphism;

public class Casting {
    public static void main(String[] args) {
        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        //Downcasting (From Movie to Adventure)
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");

        Object comedy = Movie.getMovie("C", "Airplane");
        //comedy cannot run watchMovie method as it is not accessible in the Object class
        //Casting to a more specific type (Movie)
        Movie comedyMovie = (Movie) comedy;
        comedyMovie.watchMovie();

        //Using var keyword (telling Java to figure out compile-time type (not runtime))
        var airplane = Movie.getMovie("C", "Airplane"); //variable assigned to Movie type (not Comedy)
        airplane.watchMovie();

        var plane = new Comedy("Airplane"); //variable assigned to Comedy type
        plane.watchComedy(); //prints "Watching Comedy"

        //Testing runtime with instanceof operator
        Object unknownObject = Movie.getMovie("C", "Airplane");
        //test type of object
        if (unknownObject instanceof Comedy) {
            //Casting before calling method that is unique to Comedy type without assigning it to local variable
            ((Comedy) unknownObject).watchComedy(); //prints "Watching Comedy"
        }

        //Patten matching for instanceof operator (JDK 16)
        if (unknownObject instanceof Comedy com) {
            //Casting before calling method that is unique to Comedy type without assigning it to local variable
            com.watchComedy(); //prints "Watching Comedy"
        }

    }
}
