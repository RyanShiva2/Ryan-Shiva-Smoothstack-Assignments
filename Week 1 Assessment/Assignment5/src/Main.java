import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {

    /*Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target,
    with this additional constraint: if there are numbers in the array that are adjacent and the identical value, they must either all be chosen, or none of them chosen.
    For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group.
    (one loop can be used to find the extent of the identical values).*/

    public static void main(String[] args) {
	    // Given array of ints and target
        int[] numArray = {1, 2, 4, 4, 4, 8, 1};
        int target = 14;

        // Convert array to list with duplicates added together into a single value.
        ArrayList<Integer> numList = combineDuplicates(numArray);

        // Is it possible to choose a group of ints that sum to the target given the constraints
        System.out.println(groupSumClump(numList, target, 0));

    }

    public static ArrayList<Integer> combineDuplicates(int[] numArray) {
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(numArray[0]);
        int counter = 1;
        for (int i = 1; i < numArray.length; ++i) {
            if (numArray[i - 1] == numArray[i]) {
                ++counter;
                numList.set(numList.size() - 1, numArray[i] * counter);
            } else {
                counter = 1;
                numList.add(numArray[i]);
            }
        }
        return numList;
    }

    public static boolean groupSumClump(ArrayList<Integer> numList, int target, int counter) {
        ArrayList<Integer> copyList = new ArrayList<>(numList);

        if (target == 0) {
            return true;
        }

        if (target < 0 || counter >= numList.size()) {
            return false;
        }

        ++counter;

        return groupSumClump(copyList, target, counter)
                || groupSumClump(copyList, target - numList.get(counter - 1), counter + 1);

/*        ArrayList<Integer> copyList = new ArrayList<>(numList);

        int recursionLevelCounter = 1;

        for (Integer num : copyList) {
            if (target - num == 0) {
                return true;
            } else if (target - num < 0) {
                continue;
            } else {
                copyList.remove(num);
                return groupSumClump(copyList, target - num);
            }
        }
        if
        return false;*/
    }
}
// 12, 8, 1
// 11
// false
// should be true

//1, 2, 12, 8, 1
//14