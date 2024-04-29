package _08.OOP._07.Polymorphism;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Movie theMovie = new Movie("Toy Story");
        theMovie.watchMovie();
        //prints "Toy Story is a Movie film"

        //Adventure is a subclass of Movie, able to assign the adventure object to Movie variable (Upcasting)
        Movie secondMovie = new Adventure("Jaws");
        secondMovie.watchMovie(); //method that gets run is determined by the runtime object not the variable type
        //prints
        //"Jaws is a Adventure film",
        //".. Pleasant Scene",
        //".. Scary Music",
        //".. Something Bad Happens"

        //Calling code does not need to know about each subclass
        //Right object type is instantiated but assigned to Movie type
        Movie thirdMovie = Movie.getMovie("Science", "Star Wars");
        thirdMovie.watchMovie();
        //prints
        //"Star Wars is a ScienceFiction film"
        //".. Aliens Do Bad stuff",
        //".. Space Guy Chase Aliens",
        //".. Planet Blows Up"



        //Polymorphism in action (compiled code does not need to know anything about the subclasses)
        //Method will get called according to the runtime object
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Type (A for Adventure, C for Comedy, S for Science Fiction" +
                    " or Q to quit): ");
            String type = s.nextLine();
            if ("Qq".contains(type)) {
                break;
            }
            System.out.print("Enter Movie Title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
