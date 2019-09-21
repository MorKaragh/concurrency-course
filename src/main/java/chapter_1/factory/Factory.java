package chapter_1.factory;

import java.util.concurrent.ThreadFactory;

public class Factory implements ThreadFactory {

    private int counter;

    public Thread newThread(Runnable r) {
        counter++;
        return new Thread(r);
    }

    public int getCounter() {
        return counter;
    }
}
