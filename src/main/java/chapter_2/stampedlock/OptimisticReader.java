package chapter_2.stampedlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class OptimisticReader implements Runnable{

    private Cooridnate cooridnate;
    private StampedLock lock;

    public OptimisticReader(Cooridnate cooridnate, StampedLock lock) {
        this.cooridnate = cooridnate;
        this.lock = lock;
    }

    @Override
    public void run() {
        long stamp;

        for (int i = 0; i < 100; i++) {
            try {

                stamp = lock.tryOptimisticRead();
                int x = cooridnate.getX();
                int y = cooridnate.getY();

                if (lock.validate(stamp)) {
                    System.out.println(Thread.currentThread().getName() + ": успешно считал " + x + "-" + y);
                } else {
                    System.out.println(Thread.currentThread().getName() + ": наткнулся на блокировку");
                }

                TimeUnit.MILLISECONDS.sleep(200);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
