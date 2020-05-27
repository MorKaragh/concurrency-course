package chapter_2.conditionallock_play;

public class Consumer extends Thread {

    private Storage storage;
    private int stored;
    private boolean storageEmpty;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (!storageEmpty) {
            stored += storage.get100();
            System.out.println("got 100");
        }
        System.out.println("finish consuming");
    }

    public int getStored() {
        return stored;
    }

    public Consumer setStorageEmpty(boolean storageEmpty) {
        this.storageEmpty = storageEmpty;
        return this;
    }
}
