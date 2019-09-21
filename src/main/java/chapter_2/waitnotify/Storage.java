package chapter_2.waitnotify;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;

public class Storage {

    private int maxSize = 10;
    private Queue<Date> storage = new ArrayDeque<>();

    public synchronized void set() {
        while (storage.size() == 10) {
            System.out.println("set()");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Date date = new Date();

        System.out.println("adding " + date.toString() + ", current size = " + storage.size());

        storage.add(date);
        notify();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            System.out.println("get()");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String element = storage.poll().toString();
        System.out.println("getting " + element + ", current size = " + storage.size());

        notify();
    }



}
