package chapter_2.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class Main {

    public static void main(String[] args) {
        Cooridnate cooridnate = new Cooridnate();
        StampedLock lock = new StampedLock();

        Thread writer = new Thread(new Writer(cooridnate,lock));
        writer.setName("writer");
        Thread reader = new Thread(new Reader(cooridnate,lock));
        reader.setName("reader");
        Thread optimistic = new Thread(new OptimisticReader(cooridnate,lock));
        optimistic.setName("optimistic");

        writer.start();
        reader.start();
        optimistic.start();

    }

}
