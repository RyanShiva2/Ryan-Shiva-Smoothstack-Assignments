public class Main {

    /*  Assignment 3
        Write a program with one thread (the producer) that produces items (in this case, simple ints).
        Another thread (the consumer) consumes items.
        For communication purposes, both threads have access to a bounded buffer which is basically an array.*/

    // Producer adds int to linked list of size 10
    // Consumer prints the ints
    // Repeat for 100 ints
    // Print perfect squares

    public static void main(String[] args) {
        ProducerController producerController = new ProducerController();

        Runnable consumerRunnable = producerController::produce;

        Thread consumerThread = new Thread(consumerRunnable);

        Runnable producerRunnable = producerController::consume;

        Thread producerThread = new Thread(producerRunnable);

        producerThread.start();
        consumerThread.start();
    }
}