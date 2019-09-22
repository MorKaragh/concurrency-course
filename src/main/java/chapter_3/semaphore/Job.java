package chapter_3.semaphore;

public class Job implements Runnable {

    private PrintQueue queue;

    public Job(PrintQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            queue.job();
        }
    }

}
