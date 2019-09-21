package chapter_2.conditionallock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TwoLineBuffer {

    private LinkedList<String> content = new LinkedList<>();
    private int maxSize;
    private ReentrantLock lock = new ReentrantLock();
    private Condition lines = lock.newCondition();
    private Condition size = lock.newCondition();

    public TwoLineBuffer(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(String line) {
        lock.lock();
        try {
            while (content.size() == maxSize) {
                size.await();
            }
            System.out.println("добавляем строчку");
            content.add(line);
            size.signalAll();
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get(){
        lock.lock();
        String result = null;
        try {
            while (content.size() < 2) {
                lines.await();
            }
            result = content.poll() + content.poll();
            lines.signalAll();
            System.out.println("отдаем 2 строчки");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

}
