package chapter_2.conditionallock;

public class Producer implements Runnable {

    private FileMock fileMock;
    private TwoLineBuffer buffer;

    public Producer(FileMock fileMock, TwoLineBuffer buffer) {
        this.fileMock = fileMock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (fileMock.hasNext()) {
            try {
                buffer.add(fileMock.getLine());
                System.out.println(Thread.currentThread().getName() + " положил строчку");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
