package chapter_1.threadlocal;

public class CrazyTask implements Runnable{

    private StringBuilder text = new StringBuilder();

    public void run() {
        for (int i = 0; i < 5; i++) {
            text.append(i);
        }
        System.out.println("Crazy: " + text.toString());
    }
}
