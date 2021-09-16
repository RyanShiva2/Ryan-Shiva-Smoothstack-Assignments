import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    /*Assignment 3
    Write a Java program that counts the number of times a particular character, such as 'e', appears in a file.
    The character can be specified at the command line.*/

    public static void main(String[] args) {
        // Get character from command line
        if (args[0].length() != 1) {
            System.out.println("Error: Command Line Argument must be a single character.");
        }
        Character character = args[0].charAt(0);

        // Create a character frequency map for the file
        String path = "resources/alice30.txt";
        Map<Character, Integer> charCount = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            int charVal = bufferedReader.read();
            char c = '*';
            while (charVal != -1) {
                c = (char) charVal;
                Integer count = charCount.get(c);

                if (count == null) {
                    count = 1;
                } else {
                    ++count;
                }

                charCount.put(c, count);
                charVal = bufferedReader.read();
            }

            // Display number of times the character appears in the file
            System.out.println("The character '" + character + "' appears in the file " + charCount.get(character) + " times.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
