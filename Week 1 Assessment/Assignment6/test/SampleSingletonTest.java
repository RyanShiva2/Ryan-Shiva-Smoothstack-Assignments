import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleSingletonTest {

    @Test
    void getInstanceTest() {
        assertNotNull(SampleSingleton.getInstance());
    }
}