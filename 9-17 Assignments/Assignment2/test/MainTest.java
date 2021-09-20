import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 44));

    @Test
    void convertListTest() {
        assertEquals(Main.convertList(list), "o3,e44");
    }
}