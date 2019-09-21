package chapter_2.conditionallock;

public class Consumer implements Runnable{

    private TwoLineBuffer buffer;

    public Consumer(TwoLineBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " достал: " + buffer.get());
        }
    }
}
