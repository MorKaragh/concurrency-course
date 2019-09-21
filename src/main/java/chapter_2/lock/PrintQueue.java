package chapter_2.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private Lock lock;

    public PrintQueue(boolean fair) {
        this.lock = new ReentrantLock(fair);
    }

    public void print(Object doc) {
        lock.lock();
        try {
            long duration = (long) (Math.random() * 1000);
            System.out.printf("%s: выполняем первую хрень за %d \n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        lock.lock();
        try {
            long duration = (long) (Math.random() * 1000);
            System.out.printf("%s: опять выполняем хрень за %d \n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
