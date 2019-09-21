package chapter_2.waitnotify;

public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage();

        int availableProcessors = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < availableProcessors; i++) {
            Thread producer = new Thread(new Producer(storage));
            Thread consumer = new Thread(new Consumer(storage));
            producer.start();
            consumer.start();
        }

    }

}
