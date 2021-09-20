import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /*  Assignment 3
        Given a list of integers, return a list where each integer is multiplied by 2. */

    public static void main(String[] args) {
        // Given list of integers
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 45, 34, 6, 23, 12, 52, 91, 23, 49));

        // Return list of doubled numbers
        list = doubling(list);

        // Output the list
        list.forEach(System.out::println);
    }

    public static ArrayList<Integer> doubling(ArrayList<Integer> list) {
        ArrayList<Integer> doubledNumList = new ArrayList<>();
        list.forEach(num -> doubledNumList.add(num * 2));
        return doubledNumList;
    }
}
