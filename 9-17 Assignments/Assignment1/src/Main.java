import Comparators.ContainEComparator;
import Comparators.FirstCharComparator;
import Comparators.LengthComparator;
import Comparators.ReverseLengthComparator;

import java.util.Arrays;
import java.util.List;

public class Main {

    /*  Assignment 1
     *   Basic lambdas. Make an array containing a few Strings. Sort it*/

    public static void main(String[] args) {
        // Make array containing strings
        String[] array = {"Tom", "Michael", "Nick", "Jenny", "Kyle", "Samantha", "Tim"};
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(array));
        System.out.println();


        // Sort array by length (shortest to longest)
        SortArray sortByLength = arrayToSort -> {
            LengthComparator comparator = new LengthComparator();
            List<String> sortedList = Arrays.asList(arrayToSort);
            sortedList.sort(comparator);
            String[] sortedArray = new String[sortedList.size()];
            sortedList.toArray(sortedArray);
            return sortedArray;
        };
        System.out.println("Array sorted by length (shortest to longest): ");
        System.out.println(Arrays.toString(sortByLength.sortStringArray(array)));
        System.out.println();

        // Sort array by reverse length (longest to shortest)
        SortArray sortByReverseLength = arrayToSort -> {
            ReverseLengthComparator comparator = new ReverseLengthComparator();
            List<String> sortedList = Arrays.asList(arrayToSort);
            sortedList.sort(comparator);
            String[] sortedArray = new String[sortedList.size()];
            sortedList.toArray(sortedArray);
            return sortedArray;
        };
        System.out.println("Array sorted by reverse length (longest to shortest): ");
        System.out.println(Arrays.toString(sortByReverseLength.sortStringArray(array)));
        System.out.println();

        // Sort array alphabetically by first character only
        SortArray sortByFirstChar = arrayToSort -> {
            FirstCharComparator comparator = new FirstCharComparator();
            List<String> sortedList = Arrays.asList(arrayToSort);
            sortedList.sort(comparator);
            String[] sortedArray = new String[sortedList.size()];
            sortedList.toArray(sortedArray);
            return sortedArray;
        };
        System.out.println("Array sorted alphabetically by first character only: ");
        System.out.println(Arrays.toString(sortByFirstChar.sortStringArray(array)));
        System.out.println();

        // Sort array with strings containing 'e' first
        SortArray sortByContainE = arrayToSort -> {
            ContainEComparator comparator = new ContainEComparator();
            List<String> sortedList = Arrays.asList(arrayToSort);
            sortedList.sort(comparator);
            String[] sortedArray = new String[sortedList.size()];
            sortedList.toArray(sortedArray);
            return sortedArray;
        };
        System.out.println("Array sorted with strings containing 'e' first: ");
        System.out.println(Arrays.toString(sortByContainE.sortStringArray(array)));
        System.out.println();
    }
}
