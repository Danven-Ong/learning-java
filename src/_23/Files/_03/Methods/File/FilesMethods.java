package _23.Files._03.Methods.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FilesMethods {
    public static void main(String[] args) {

        Path path = Path.of("");
        System.out.println("cwd = " + path.toAbsolutePath());

        try (var paths = Files.list(path)) {
            paths
                    .map(FilesMethods::listDir)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var paths = Files.walk(path, 2)) {
            paths
                    .filter((Files::isRegularFile))
                    .map(FilesMethods::listDir)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var paths = Files.find(path, 2,
                (p, attr) -> Files.isRegularFile(p))) {
            paths
                    .map(FilesMethods::listDir)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var dirs = Files.newDirectoryStream(path)) {
            dirs.forEach(d -> System.out.println(FilesMethods.listDir(d)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String listDir(Path path) {

        try{
            boolean isDir = Files.isDirectory(path);
            FileTime dateField = Files.getLastModifiedTime(path);
            LocalDateTime modDT = LocalDateTime.ofInstant(
                    dateField.toInstant(), ZoneId.systemDefault());
            return "%tD %tT %-5s %12s %s"
                    .formatted( modDT, modDT, (isDir ? "<DIR>" : ""),
                            (isDir ? "" : Files.size(path)), path);
        } catch (IOException e) {
            System.out.println("Something went wrong");
            return path.toString();
        }
    }
}
