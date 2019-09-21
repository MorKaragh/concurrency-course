package chapter_1.daemon;

import java.util.concurrent.TimeUnit;

public class Observer extends Thread {

    private final Territory territory;

    public Observer(Territory territory) {
        this.territory = territory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(territory.toString());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("chapter_1.daemon.Observer terminated");
            }
        }
    }
}
