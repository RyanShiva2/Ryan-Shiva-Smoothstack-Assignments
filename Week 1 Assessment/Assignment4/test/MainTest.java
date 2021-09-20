import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class MainTest {
    ArrayList<String> list1 = new ArrayList<>(Arrays.asList("ax", "bb", "cx"));

    @Test
    void noXTest() {
        Assertions.assertEquals(Main.noX(list1), new ArrayList<>(Arrays.asList("a", "bb", "c")));
        Assertions.assertNotEquals(Main.noX(list1), new ArrayList<>(Arrays.asList("ax", "bb", "cx")));
    }
}