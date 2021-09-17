import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {

    Line line1 = new Line(5, 2, 1, 6);
    Line line2 = new Line(5, 0, 5, 8);
    Line line3 = new Line(5, 0, 1, 4);
    Line line4 = new Line(-2, 12, 8, -4);

    @Test
    void getSlopeTest() {
        // Test Undefined Slope Exception
        Assertions.assertThrows(ArithmeticException.class, () -> line2.getSlope());
        Assertions.assertDoesNotThrow(() -> line1.getSlope());

        // Test Slope calculation
        Assertions.assertEquals(-1.0, line1.getSlope(), .0001);
    }

    @Test
    void getDistanceTest() {
        // Test distance calculation
        Assertions.assertEquals(5.656854, line1.getDistance(), .0001);
    }

    @Test
    void parallelToTest() {
        // Test parallel lines
        Assertions.assertTrue(line1.parallelTo(line3));

        // Test intersecting lines
        Assertions.assertFalse(line1.parallelTo(line4));
    }
}