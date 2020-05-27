package chapter_2.conditionallock_play;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage();
        List<Consumer> consumers = new ArrayList<>();
        List<Thread> producers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            consumers.add(new Consumer(storage));
        }
        for (int i = 0; i < 3; i++) {
            producers.add(new Thread(new Producer(storage)));
        }

        for (Thread consumer : consumers) {
            consumer.start();
        }

        for (Thread producer : producers) {
            producer.start();
        }

        for (Thread producer : producers) {
            try {
                producer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Consumer consumer : consumers) {
            consumer.setStorageEmpty(true);
        }
        storage.setProducersFinished(true);

        int total = 0;
        for (Consumer consumer : consumers) {
            total += consumer.getStored();
            try {
                consumer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("in storage " + storage.counter);
        System.out.println("got total " + total);

        for (Consumer consumer : consumers) {
            System.out.println(consumer.getName() + " got " + consumer.getStored());
        }


    }

}
