public class Main {

    /*  Assignment 1
        Implement a Singleton with double checked locking.*/

    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            DoubleCheckedSingleton instance1 = DoubleCheckedSingleton.getInstance();
            instance1.printMessage("Thread 1 created a new instance of DoubleCheckedSingleton.");
        };
        Thread thread1 = new Thread(runnable1);

        Runnable runnable2 = () -> {
            DoubleCheckedSingleton instance2 = DoubleCheckedSingleton.getInstance();
            instance2.printMessage("Thread 2 created a new instance of DoubleCheckedSingleton.");
        };
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}