package chapter_2.syncmethod;

import java.util.concurrent.TimeUnit;

public class Store {

    private int counter;

    public void increment(){
        int newVal = counter + 1;
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
        }
        counter = newVal;
    }

    public int getCounter() {
        return counter;
    }

    public synchronized void sincrement() {
        int newVal = counter + 1;
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
        }
        counter = newVal;
    }
}
