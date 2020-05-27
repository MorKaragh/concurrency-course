package chapter_2.conditionallock_play;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

    Lock lock = new ReentrantLock();
    Condition fullCondition = lock.newCondition();
    Condition notFullCondition = lock.newCondition();

    int counter;
    private boolean producersFinished;

    public void addOne() {
        lock.lock();
        try {
            while (counter == 100)
                fullCondition.await();
            counter++;
            System.out.println("counter = " + counter);
            notFullCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int get100() {
        lock.lock();
        try {
            while (counter < 100 && !producersFinished)
                notFullCondition.await();
            fullCondition.signalAll();
            int toReturn = counter;
            counter-=counter;
            return toReturn;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return counter;
        } finally {
            lock.unlock();
        }
    }

    public Storage setProducersFinished(boolean producersFinished) {
        lock.lock();
        try {
            this.producersFinished = producersFinished;
            notFullCondition.signalAll();
            return this;
        } finally {
            lock.unlock();
        }
    }
}
