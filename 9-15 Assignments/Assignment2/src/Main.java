import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {

    /*  Assignment 2
        Write a Java program to append text to an existing file.*/

    public static void main(String[] args) {
        // Get text to append
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the text to append to output.txt:");
        String textToAppend = scanner.nextLine();

        // Append text to output.txt
        String path = "resources/output.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            Files.write(Paths.get(path), textToAppend.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
