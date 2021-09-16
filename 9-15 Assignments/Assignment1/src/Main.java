import java.io.File;
import java.util.Scanner;

public class Main {

/*    Assignment 1
      Write a Java program to get a list of all file/directory names (including in subdirectories) under a given directory.*/

    public static void main(String[] args) {
        // Get directory from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the directory:");
        String fileDirectory = scanner.nextLine();

        // Create array of file and folder names
        File file = new File(fileDirectory);
        String[] fileNames = file.list();

        // Print the file and folder names
        if (fileNames == null) {
            System.out.println("Invalid file directory");
        } else if (fileNames.length == 0) {
            System.out.println("Empty file directory");
        } else {
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        }
    }
}