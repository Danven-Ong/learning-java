package _23.Files._02.Basics;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main2 {
    public static void main(String[] args) {

        useFile("src/_22/Files/files/testfile.txt");

        usePath("src/_22/Files/files/pathfile.txt");
    }

    //Creating a file and deleting a file
    private static void useFile(String fileName) {

        File file = new File(fileName);
        boolean fileExists = file.exists();

        System.out.printf("File '%s' %s%n", fileName,
                fileExists ? "exists." : "does not exist.");

        //Deleting file
        if (fileExists) {
            fileExists = !file.delete();
            System.out.println("Deleted File: " + fileName);
        }

        if (!fileExists) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
            System.out.println("Created File: " + fileName);
            if (file.canWrite()) {
                System.out.println("Would write to file here");
            }
        }
    }

    //Using paths to do the same thing
    private static void usePath(String fileName) {

        Path path = Path.of(fileName);

        boolean fileExists = Files.exists(path);

        System.out.printf("File '%s' %s%n", fileName,
                fileExists ? "exists." : "does not exist.");

        //Deleting file
        if (fileExists) {
            try {
                Files.delete(path);
                fileExists = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Deleted File: " + fileName);
        }

        if (!fileExists) {
            try {
                Files.createFile(path);
                System.out.println("Created File: " + fileName);
                if (Files.isWritable(path)) {
                    System.out.println("Would write to file here");
                    Files.writeString(path, """
                            Here is some data
                            """);
                }
                System.out.println("Reading file:");
                Files.readAllLines(path).forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
    }
}
