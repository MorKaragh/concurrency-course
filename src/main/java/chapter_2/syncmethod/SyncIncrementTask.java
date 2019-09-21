package chapter_2.syncmethod;

public class SyncIncrementTask implements Runnable {

    private final Store store;

    public SyncIncrementTask(Store s) {
        this.store = s;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            store.sincrement();
        }
    }
}