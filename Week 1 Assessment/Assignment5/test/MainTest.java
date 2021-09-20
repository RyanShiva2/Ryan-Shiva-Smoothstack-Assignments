import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int[] array = {2, 4, 4, 8};
    ArrayList<Integer> list1 = new ArrayList(Arrays.asList(2, 4, 8));
    ArrayList<Integer> list2 = new ArrayList(Arrays.asList(1, 2, 4, 8, 1));
    ArrayList<Integer> list3 = new ArrayList(Arrays.asList(2, 8, 8));

    @Test
    void combineDuplicatesTest() {
        assertEquals(new ArrayList(Arrays.asList(2, 8, 8)), Main.combineDuplicates(array));
    }

    @Test
    void groupSumClumpTest() {
        assertTrue(Main.groupSumClump(list1, 10));
        assertTrue(Main.groupSumClump(list2, 14));
        assertFalse(Main.groupSumClump(list3, 14));
    }
}