import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    /*  Assignment 2
     *  Using Java 8 features write a method that returns a comma separated string based on a given list of integers.*/

    public static void main(String[] args) {
	    // Given list of integers
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(23, 52, 12, 75, 17, 2, 91, 43));

        // Convert List
        String string = convertList(list);

        // Print string
        System.out.println(string);
    }

    public static String convertList(ArrayList<Integer> list) {
        StringBuffer output = new StringBuffer("");
        list.stream().map(num -> {
            if (num % 2 == 0) {
                return "e" + num + ",";
            } else {
                return "o" + num + ",";
            }
        })
                .collect(Collectors.toList()).forEach(output::append);
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }
}
