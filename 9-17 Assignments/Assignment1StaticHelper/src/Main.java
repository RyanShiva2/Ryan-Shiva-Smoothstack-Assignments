import java.util.Arrays;

public class Main {

    /*  Assignment 1 with Static Helper Method
     *  Redo the previous problem, but use a static helper method*/

    public static void main(String[] args) {
        // Make array containing strings
        String[] array = {"Tom", "Michael", "Nick", "Jenny", "Kyle", "Samantha", "Tim"};
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(array));
        System.out.println();

        // Sort array by length (shortest to longest)
        SortArray sortByLength = arrayToSort -> {
            Arrays.sort(arrayToSort, (s1, s2) -> Utils.compareByLength(s1, s2));
            return arrayToSort;
        };
        System.out.println("Array sorted by length (shortest to longest): ");
        System.out.println(Arrays.toString(sortByLength.sortStringArray(array)));
        System.out.println();

        // Sort array by reverse length (longest to shortest)
        SortArray sortByReverseLength = arrayToSort -> {
            Arrays.sort(arrayToSort, (s1, s2) -> Utils.compareByReverseLength(s1, s2));
            return arrayToSort;
        };
        System.out.println("Array sorted by reverse length (longest to shortest): ");
        System.out.println(Arrays.toString(sortByReverseLength.sortStringArray(array)));
        System.out.println();

        // Sort array alphabetically by first character only
        SortArray sortByFirstChar = arrayToSort -> {
            Arrays.sort(arrayToSort, (s1, s2) -> Utils.compareByFirstChar(s1, s2));
            return arrayToSort;
        };
        System.out.println("Array sorted by first character: ");
        System.out.println(Arrays.toString(sortByFirstChar.sortStringArray(array)));
        System.out.println();

        // Sort array with strings containing 'e' first
        SortArray sortByContainE = arrayToSort -> {
            Arrays.sort(arrayToSort, (s1, s2) -> Utils.compareByContainE(s1, s2));
            return arrayToSort;
        };
        System.out.println("Array sorted with strings containing 'e' first: ");
        System.out.println(Arrays.toString(sortByContainE.sortStringArray(array)));
        System.out.println();
    }
}
