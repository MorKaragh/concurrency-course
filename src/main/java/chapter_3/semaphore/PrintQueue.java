package chapter_3.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private Semaphore semaphore;
    private boolean[] freePrinters;
    private Lock lock;

    public PrintQueue() {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        lock = new ReentrantLock();
    }

    public void job() {
        try {
            semaphore.acquire();

            int printer = getPrinter();

            Long duration = (long) (Math.random() * 10);
            System.out.println(Thread.currentThread().getName() + ": печатаем на " + printer + " за " + duration);
            TimeUnit.SECONDS.sleep(duration);

            freePrinters[printer] = true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int getPrinter() {
        lock.lock();
        try {
            for (int i = 0; i < 3; i++) {
                if (freePrinters[i]) {
                    freePrinters[i] = false;
                    return i;
                }
            }
        } finally {
            lock.unlock();
        }

        return -1;
    }
}
