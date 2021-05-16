package model.block;

import java.util.Objects;

public class Brick {
    private int x;
    private int y;

    public Brick(int x, int y) {
        setX(x);
        setY(y);
    }

    public Brick() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    private void setX(int x) {
        this.x = x;

    }

    public int getY() {
        return y;
    }

    private void setY(int y) {
        this.y = y;

    }

    public void setBrick(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brick brick = (Brick) o;
        return x == brick.x && y == brick.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
