package game.rpg_engine.world.coordinates;

import game.rpg_engine.world.Coordinates;

public class WorldCord extends Coordinates<WorldCord> {
    private WorldCord(int x, int y) {
        super(x, y);
    }

    public static WorldCord of(int x, int y) {
        return new WorldCord(x, y);
    }

    public boolean equals(Object e) {
        WorldCord cord = (WorldCord)e;
        return cord.getX() == this.getX() && cord.getY() == this.getY();
    }
}

