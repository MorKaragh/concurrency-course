package chapter_2.syncmethod;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Store store = new Store();

        int processors = Runtime.getRuntime().availableProcessors();

        System.out.println("running " + processors + " threads");

        Thread[] toJoin = new Thread[processors];

        for (int i = 0; i < processors; i++) {
            Thread t = new Thread(new IncrementTask(store));
            t.start();
            toJoin[i] = t;
        }

        for (Thread t : toJoin) {
            t.join();
        }

        System.out.println(store.getCounter());

        store = new Store();
        for (int i = 0; i < processors; i++) {
            Thread t = new Thread(new SyncIncrementTask(store));
            t.start();
            toJoin[i] = t;
        }

        for (Thread t : toJoin) {
            t.join();
        }

        System.out.println(store.getCounter());


    }

}
