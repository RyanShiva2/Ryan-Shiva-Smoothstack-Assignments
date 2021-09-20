import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /*  Assignment 2
        Given a list of non-negative integers, return an integer list of the rightmost digits. */

    public static void main(String[] args) {
        // Given list of integers
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 45, 34, 6, 23, 12, 52, 91, 23, 49));

        // Return list of rightmost digits
        list = rightDigit(list);

        // Output the list
        list.forEach(System.out::println);
    }

    public static ArrayList<Integer> rightDigit(ArrayList<Integer> list) {
        ArrayList<Integer> rightNumList = new ArrayList<>();
        list.forEach(num -> rightNumList.add(num % 10));
        return rightNumList;
    }
}
