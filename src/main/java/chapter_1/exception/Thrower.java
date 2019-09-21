package chapter_1.exception;

public class Thrower extends Thread {

    @Override
    public void run() {
        int s = Integer.parseInt("HOOY");
    }
}
