package main;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Write a program that will recursively display the contents of a given directory, i.e. a directory
 * can contain files and subdirectories, which in turn can also contain files and subdirectories, etc.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        String filePath;
        System.out.println("Enter disc name");
        Scanner scanner = new Scanner(System.in);
        filePath = scanner.next() + ":\\";
        System.out.println("Enter disc directory");
        filePath += scanner.next();
        Path dir = Path.of(filePath);
        directoryPath(dir);
    }

    private void directoryPath(Path dir) {
        int index;
        try (DirectoryStream<Path> file = Files.newDirectoryStream(dir)) {
            for (Path path : file) {
                if (Files.isDirectory(path)) {
                    directoryPath(path);
                }
                index= path.getNameCount();
                while (index>0){
                    System.out.print("\t");
                    index--;
                }
                System.out.println(path.getFileName().toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
