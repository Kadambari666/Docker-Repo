package CoreJava;

import java.util.LinkedList;

class ProducerConsumer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity = 5;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() == capacity) {
                    wait();
                }
                System.out.println("Producer produced: " + value);
                buffer.add(value++);
                notify();
                Thread.sleep(1000); // Simulate some processing time
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait();
                }
                int value = buffer.removeFirst();
                System.out.println("Consumer consumed: " + value);
                notify();
                Thread.sleep(1000); // Simulate some processing time
            }
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        final ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
