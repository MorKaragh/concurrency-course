package chapter_1.exception;

public class Handler implements Thread.UncaughtExceptionHandler {

    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Thread " + t.getName() + " threw an chapter_1.exception: " + e.getMessage());
        e.printStackTrace();
    }

}
