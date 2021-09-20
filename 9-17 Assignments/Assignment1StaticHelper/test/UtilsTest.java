import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    String string1 = "Hello";
    String string2 = "Goodbye";
    String string3 = "Perhaps";
    String string4 = "Pardon";
    String string5 = "NoFifthLttr";

    @Test
    void compareByLengthTest() {
        // First String Longer
        assertTrue(Utils.compareByLength(string1, string2) < 0);

        // Second String Longer
        assertTrue(Utils.compareByLength(string2, string1) > 0);

        // Equal Length Strings
        assertEquals(Utils.compareByLength(string3, string2), 0);
    }

    @Test
    void compareByReverseLengthTest() {
        // First String Longer
        assertTrue(Utils.compareByReverseLength(string1, string2) > 0);

        // Second String Longer
        assertTrue(Utils.compareByReverseLength(string2, string1) < 0);

        // Equal Length Strings
        assertEquals(Utils.compareByReverseLength(string3, string2), 0);
    }

    @Test
    void compareByFirstCharTest() {
        // First String Before
        assertTrue(Utils.compareByFirstChar(string1, string3) < 0);

        // Second String Before
        assertTrue(Utils.compareByFirstChar(string3, string1) > 0);

        // Same First Char
        assertEquals(Utils.compareByFirstChar(string3, string4), 0);
    }

    @Test
    void compareByContainETest() {
        // Only First Contains e
        assertTrue(Utils.compareByContainE(string1, string4) < 0);

        // Only Second Contains e
        assertTrue(Utils.compareByContainE(string4, string1) > 0);

        // Both contain e
        assertEquals(Utils.compareByContainE(string1, string2), 0);

        // Neither contain e
        assertEquals(Utils.compareByContainE(string4, string5), 0);
    }
}