package _23.Files._02.Basics;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String filename = "src/_22/Files/files/testing.csv";
        File file = new File(filename);

        //Obtaining absolute path of file
        System.out.println("Current working directory = " +
                new File("").getAbsolutePath());
        System.out.println("Absolute path: " + file.getAbsolutePath());

        if (!file.exists()) {
            System.out.println("Cannot run unless this file exists, quiting...");
            return;
        }
        System.out.println("Good to go");
        //prints "Good to go"

        for (File f : File.listRoots()) {
            System.out.println(f);
        }

        //Creating an absolute path
        String filename2 = "/files/testing.csv"; //indicated by the single forward slash as the first character
        File file2 = new File(filename2);
        System.out.println("Absolute path: " + file2.getAbsolutePath());

        //Can be done using overloaded File constructor
        String filename3 = "files/testing.csv";
        File file3 = new File("/",filename3);
        System.out.println("Absolute path: " + file3.getAbsolutePath());

        //Referencing current directory
        File file4 = new File(".","files/testing.csv");
        System.out.println("Absolute path: " + file4.getAbsolutePath());

        //Can be done like this as welll
        file4 = new File(new File("").getAbsolutePath(), "files/testing.csv");
        System.out.println("Absolute path: " + file4.getAbsolutePath());

        Path path = Paths.get("src/_22/Files/files/testing.csv");
        System.out.println("File exists: " + Files.exists(path));
    }
}
