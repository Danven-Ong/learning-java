package _23.Files._01.Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String filename = "src/_22/Files/files/testing.csv";
        Path path = Paths.get(filename);
        //Assuming a file exist and throwing exception if it does not
        try {
            List<String> lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Checking if file exist
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Cannot run unless this file exists, quiting...");
            return;
        }
        System.out.println("Good to go");

        //Using FileReader class
        String filename2 = "testing2.csv";
        Path path2 = Paths.get(filename2);
        FileReader reader = null;
        try {
            reader = new FileReader(filename2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                reader.close();
            }
            System.out.println("Logging something");
        }


    }

    //Using try-with-resources
    private static void testFile(String filename) {

        //This statement can be used without finally block. as all resources are automatically closed
        //when try block completes or if it gets exception
        try (FileReader reader = new FileReader(filename)) {
        } catch (FileNotFoundException e) { //Note to declare exceptions in hierarchical order
            System.out.println("File '" + filename + "' does not exist");
            throw new RuntimeException(e);
        } catch (NullPointerException | IllegalArgumentException badData) { //Multi-catch must be disjoint (No direct relationship)
            System.out.println("User has added bad data " + badData.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something unrelated and unexpected happened");
        }
    }
}
