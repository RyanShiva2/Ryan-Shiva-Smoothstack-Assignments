public class DoubleCheckedSingleton {

    volatile public static DoubleCheckedSingleton instance = null;

    private DoubleCheckedSingleton() {

    }

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}