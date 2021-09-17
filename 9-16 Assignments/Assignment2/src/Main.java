public class Main {

    /*  Assignment 2
        Write a program to create a deadlock between two threads.*/

    public static void main(String[] args) {

        Integer mathStudyHours = 5;
        Integer scienceStudyHours = 7;

        Runnable runnable1 = () -> {
            try {
                synchronized (mathStudyHours) {
                    Thread.sleep(100);
                    synchronized (scienceStudyHours) {
                        System.out.println("I have studied math for " + mathStudyHours + " hours and science for " + scienceStudyHours + " hours.");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable runnable2 = () -> {
            try {
                synchronized (scienceStudyHours) {
                    Thread.sleep(100);
                    synchronized (mathStudyHours) {
                        System.out.println("I have studied for a total of " + mathStudyHours + scienceStudyHours + " hours.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        System.out.println("Thread 1 and Thread 2 have deadlocked.");
    }
}
