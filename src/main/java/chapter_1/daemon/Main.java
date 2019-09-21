package chapter_1.daemon;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Territory territory = new Territory(Long.MAX_VALUE, 0L);

        Observer observer = new Observer(territory);
        AnnihilationDaemon daemon = new AnnihilationDaemon(territory);

        daemon.start();
        observer.start();

        observer.join();
        System.out.println("Finished");
    }

}
