import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 22, 93));

    @Test
    void rightDigitTest() {
        assertEquals(Main.rightDigit(list), new ArrayList<>(Arrays.asList(1, 2, 3)));

        assertNotEquals(Main.rightDigit(list), new ArrayList<>(Arrays.asList(1, 2, 4)));
    }
}