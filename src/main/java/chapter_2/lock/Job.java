package chapter_2.lock;

import java.util.Date;

public class Job implements Runnable {

    private PrintQueue queue;

    public Job(PrintQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.printf("%s: хочеть выполнить хрень \n", Thread.currentThread().getName());
        queue.print(new Date());
        System.out.printf("%s: выполнил всю хрень \n", Thread.currentThread().getName());
    }
}
