import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /*  Assignment 4
        Given a list of strings, return a list where each string has all its "x" removed. */

    public static void main(String[] args) {
        // Given list of strings
        ArrayList<String> list = new ArrayList<>(Arrays.asList("axcas", "xxx", "xwe", "xow", "xasdawdxw", "xxxxxxxd", "xeweee", "xxwwxx", "xoxoxox", "jfkals"));

        // Return list with removed "x"
        list = noX(list);

        // Output the list
        list.forEach(System.out::println);
    }

    public static ArrayList<String> noX(ArrayList<String> list) {
        ArrayList<String> noXList = new ArrayList<>();
        list.forEach(string -> {
            StringBuffer newString = new StringBuffer();
            for (int i = 0; i < string.length(); ++ i) {
                char c = string.charAt(i);
                if (c != 'x') {
                    newString.append(c);
                }
            }
            noXList.add(newString.toString());
        });
        return noXList;
    }
}
