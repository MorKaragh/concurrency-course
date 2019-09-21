package chapter_2.syncmethod;

public class IncrementTask implements Runnable {

    private final Store store;

    public IncrementTask(Store s) {
        this.store = s;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            store.increment();
        }
    }
}
