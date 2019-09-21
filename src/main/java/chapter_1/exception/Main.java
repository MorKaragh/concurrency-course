package chapter_1.exception;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thrower = new Thrower();
        thrower.setUncaughtExceptionHandler(new Handler());
        thrower.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("finished");
    }

}
