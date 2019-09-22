package chapter_2.stampedlock;

public class Cooridnate {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public Cooridnate setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Cooridnate setY(int y) {
        this.y = y;
        return this;
    }

    @Override
    public String toString() {
        return "Cooridnate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
