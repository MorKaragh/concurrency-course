package chapter_2.conditionallock_play;

public class Producer implements Runnable {

    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            storage.addOne();
        }
    }
}
