package chapter_2.stampedlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class Writer implements Runnable{

    private Cooridnate cooridnate;
    private StampedLock stampedLock;

    public Writer(Cooridnate cooridnate, StampedLock stampedLock) {
        this.cooridnate = cooridnate;
        this.stampedLock = stampedLock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long stamp = stampedLock.writeLock();

            try {
                System.out.println(Thread.currentThread().getName() + ": ща поменяем...");
                cooridnate.setX(cooridnate.getX() + 1);
                cooridnate.setY(cooridnate.getY() + 1);
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stampedLock.unlockWrite(stamp);
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
