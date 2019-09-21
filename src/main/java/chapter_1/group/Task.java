package chapter_1.group;

import java.util.Random;

public class Task implements Runnable {


    public void run() {
        Random random = new Random(100);
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            int i = 1 / random.nextInt();
        }
    }

}


