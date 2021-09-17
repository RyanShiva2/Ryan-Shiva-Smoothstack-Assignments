import java.util.LinkedList;

public class ProducerController {
    LinkedList<Integer> numbers = new LinkedList<>();
    int capacity = 10;

    public void produce() {
        for (int i = 1; i <= 100; ++i) {
            synchronized (this) {
                try {
                    while (numbers.size() == capacity) {
                        wait();
                    }

                    int value = i * i;

                    System.out.println("Integer produced: " + value);

                    numbers.add(value);

                    notify();

                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consume() {
        for (int i = 1; i <= 100; ++i) {
            synchronized (this) {
                try {
                    while (numbers.size() == 0) {
                        wait();
                    }

                    int value = numbers.removeFirst();

                    System.out.println("Integer consumed: " + value);

                    notify();

                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
