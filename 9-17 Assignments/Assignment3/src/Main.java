import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    /*  Assignment 3
     *  Given a list of Strings, write a method that returns a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters.*/

    public static void main(String[] args) {
	    // Given list of strings
        ArrayList<String> list = new ArrayList<>(Arrays.asList("aws", "and", "you", "are", "aren't", "animal", "alive", "yam"));

        // Convert List to a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters
        ArrayList<String> convertedList = convertList(list);

        // Print converted list
        convertedList.forEach(System.out::println);
    }

    public static ArrayList<String> convertList(ArrayList<String> list) {
        ArrayList<String> convertedList = new ArrayList<>();
        convertedList.addAll(list.stream().filter(string -> string.length() == 3 && string.charAt(0) == 'a')
                .collect(Collectors.toList()));
        return convertedList;
    }
}
