import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
    ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(6, 8, 6, 8, -1));
    ArrayList<Integer> list3 = new ArrayList<>(Collections.emptyList());

    @Test
    void doublingTest() {
        assertEquals(Main.doubling(list1), new ArrayList<>(Arrays.asList(2, 4, 6)));
        assertNotEquals(Main.doubling(list1), new ArrayList<>(Arrays.asList(2, 3, 7)));

        assertEquals(Main.doubling(list2), new ArrayList<>(Arrays.asList(12, 16, 12, 16, -2)));
        assertNotEquals(Main.doubling(list2), new ArrayList<>(Arrays.asList(12, 16, 12, 14, -2)));

        assertEquals(Main.doubling(list3), new ArrayList<>(Collections.emptyList()));
        assertNotEquals(Main.doubling(list3), new ArrayList<>(Arrays.asList(1, 5)));
    }
}