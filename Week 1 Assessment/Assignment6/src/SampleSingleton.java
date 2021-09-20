import java.sql.Connection;

public class SampleSingleton {

    private static Connection conn = null;

    volatile private static SampleSingleton instance = null;

    private SampleSingleton() {}

    public static SampleSingleton getInstance() {
        synchronized (SampleSingleton.class) {
            if (instance == null) {
                instance = new SampleSingleton();
            }
            return instance;
        }
    }
}

