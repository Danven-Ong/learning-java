package _23.Files._03.Methods.Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class PathMethods {
    public static void main(String[] args) {

        Path path = Path.of("src/_22/Files/files/testing.txt");

        //Printing path (returns the string literal)
        System.out.println("Path: " + path);

        //Obtaining path file name
        System.out.println("fileName = " + path.getFileName());

        //Obtaining parent from path file
        System.out.println("parent = " + path.getParent());

        //Obtaining absolute path
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute Path: = " + absolutePath);

        //Obtaining absolute path root
        System.out.println("Absolute Path Root: = " + absolutePath.getRoot());

        //Obtaining root
        System.out.println("Root = " + path.getRoot());

        //Checking if path is absolute
        System.out.println("isAbsolute " + path.isAbsolute());

        //Obtaining the depth of the directory tree using getNameCount method
        int pathParts = absolutePath.getNameCount();

        for (int i = 0; i < pathParts; i++) {
            System.out.println(".".repeat(i + 1) + " " + absolutePath.getName(i));
        }

        logStatement(path);
        extraInfo(path);
    }
    private static void logStatement(Path path) {

        try {
            Path parent = path.getParent();
            System.out.println(parent);
            System.out.println(Files.exists(parent));
            if (!Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            Files.writeString(path, Instant.now() +
                    ": hello file world\n", StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extraInfo(Path path) {

        try {
            //Obtaining attributes/information from the file
            var atts = Files.readAttributes(path, "*");
            atts.entrySet().forEach(System.out::println);
            //Determining what type of data is file using
            System.out.println(Files.probeContentType(path));
        } catch (IOException e) {
            System.out.println("Problem getting attributes");
        }
    }
}
