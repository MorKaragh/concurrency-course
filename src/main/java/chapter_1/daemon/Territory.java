package chapter_1.daemon;

public class Territory {

    private long matter;
    private long energy;

    public Territory(long matter, long energy) {
        this.matter = matter;
        this.energy = energy;
    }

    public long getEnergy() {
        return energy;
    }

    public Territory setEnergy(long energy) {
        this.energy = energy;
        return this;
    }

    public long getMatter() {
        return matter;
    }

    public Territory setMatter(long matter) {
        this.matter = matter;
        return this;
    }

    @Override
    public String toString() {
        return "chapter_1.daemon.Territory{" +
                "matter=" + matter +
                ", energy=" + energy +
                '}';
    }
}
