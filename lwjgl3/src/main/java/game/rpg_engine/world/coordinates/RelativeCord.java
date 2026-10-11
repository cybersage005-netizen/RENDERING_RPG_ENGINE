package game.rpg_engine.world.coordinates;

import game.rpg_engine.enums.Direction;
import game.rpg_engine.world.Coordinates;
import game.rpg_engine.world.map.Map;

public class RelativeCord extends Coordinates<RelativeCord> {
    private Map map;

    private RelativeCord(int x, int y, Map map) {
        super(x, y);
        this.map = map;
    }

    public Map getMap() {
        return this.map;
    }

    public static RelativeCord of(int x, int y, Map map) {
        return new RelativeCord(x, y, map);
    }

    public boolean isValid() {
        return this.getX() != 0 && this.getX() != this.map.xBound() - 1 && this.getY() != 0 && this.getY() != this.map.yBound() - 1;
    }

    public RelativeCord getUpBy(int amt) {
        return !this.isValid() ? this : new RelativeCord(this.getX(), this.getY() - amt, this.getMap());
    }

    public RelativeCord getDownBy(int amt) {
        return !this.isValid() ? this : new RelativeCord(this.getX(), this.getY() + amt, this.getMap());
    }

    public RelativeCord getLeftBy(int amt) {
        return !this.isValid() ? this : new RelativeCord(this.getX() - amt, this.getY(), this.getMap());
    }

    public RelativeCord getRightBy(int amt) {
        return !this.isValid() ? this : new RelativeCord(this.getX() + amt, this.getY(), this.getMap());
    }

    public boolean isTopRight(){
        return this.x == this.map.xBound()-1 && this.y == 0;
    }
    public boolean isTopLeft(){
        return this.x == 0 && this.y == 0;
    }
    public boolean isBottomRight(){
        return this.x == this.map.xBound() - 1 && this.y == this.map.yBound() - 1;
    }
    public boolean isBottomLeft(){
        return this.x ==0 && this.y == this.map.yBound() - 1;
    }

    public boolean isTopCorner() {
        return isTopLeft() || isTopRight();
    }

    public boolean isBottomCorner() {
        return isBottomLeft() || isBottomRight();
    }

    public boolean isCorner() {
        return isTopCorner() || isBottomCorner();
    }

    public boolean isTopEdge() {
        return y == 0 && !isCorner();
    }

    public boolean isBottomEdge() {
        return y == map.yBound() - 1 && !isCorner();
    }

    public boolean isLeftEdge() {
        return x == 0 && !isCorner();
    }

    public boolean isRightEdge() {
        return x == map.xBound() - 1 && !isCorner();
    }

    public static int manhattenDist(RelativeCord cord1, RelativeCord cord2){
        int x = Math.abs(cord1.getX() - cord2.getX());
        int y = Math.abs(cord1.getY() - cord2.getY());
        return x+y;
    }

    public RelativeCord getCordBy(Direction dir){
        return switch(dir){
            case Direction.UP -> getUpBy(1);
            case Direction.DOWN -> getDownBy(1);
            case Direction.LEFT -> getLeftBy(1);
            case Direction.RIGHT -> getRightBy(1);
        };
    }

    public int hashCode(){
        return 31 * this.x + this.y;
    }

    public String toString(){
        return "Cord at X:" + getX() + " Y: " + getY() + " Map: " + getMap();
    }

    @Override
    public boolean equals(Object e) {
        if(e instanceof RelativeCord cord){
            return cord.getX() == this.getX() && cord.getY() == this.getY() && this.getMap() == cord.getMap();
        }
        return false;
    }
}

