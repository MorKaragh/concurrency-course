package chapter_1.daemon;

public class AnnihilationDaemon extends Thread {

    private Territory territory;

    public AnnihilationDaemon(Territory territory) {
        this.territory = territory;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            territory.setMatter(territory.getMatter() - 1);
            territory.setEnergy(territory.getEnergy() + 1);
        }
    }
}
