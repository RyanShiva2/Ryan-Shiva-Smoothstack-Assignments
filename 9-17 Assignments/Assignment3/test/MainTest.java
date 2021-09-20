import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<String> list = new ArrayList<>(Arrays.asList("abb", "bab", "abbb", "bbb"));

    @Test
    void convertListTest() {
        assertEquals(Main.convertList(list), new ArrayList<>(Collections.singletonList("abb")));
    }
}