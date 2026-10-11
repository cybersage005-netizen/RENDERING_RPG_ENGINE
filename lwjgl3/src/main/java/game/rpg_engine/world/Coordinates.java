package game.rpg_engine.world;

import java.util.Objects;

public class Coordinates<T extends Coordinates> {
    protected int x;
    protected int y;

    protected Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.x, this.y});
    }

    public T getUpBy(int amt) {
        return (T)(new Coordinates(this.getX(), this.getY() - amt));
    }

    public T getDownBy(int amt) {
        return (T)(new Coordinates(this.getX(), this.getY() + amt));
    }

    public T getLeftBy(int amt) {
        return (T)(new Coordinates(this.getX() - amt, this.getY()));
    }

    public T getRightBy(int amt) {
        return (T)(new Coordinates(this.getX() + amt, this.getY()));
    }

    public boolean equals(Object e) {
        Coordinates cord = (Coordinates)e;
        return cord.getX() == this.getX() && cord.getY() == this.getY();
    }
}

