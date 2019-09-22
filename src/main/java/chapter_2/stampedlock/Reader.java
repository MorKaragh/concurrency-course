package chapter_2.stampedlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class Reader implements Runnable {

    private Cooridnate cooridnate;
    private StampedLock lock;

    public Reader(Cooridnate cooridnate, StampedLock lock) {
        this.cooridnate = cooridnate;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            long stamp = lock.readLock();
            try {
                System.out.println(Thread.currentThread().getName() + ": читаем " + cooridnate.toString());
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
        }
    }
}
