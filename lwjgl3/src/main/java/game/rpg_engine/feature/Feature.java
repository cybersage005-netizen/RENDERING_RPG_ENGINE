package game.rpg_engine.feature;


import game.rpg_engine.client.CanRender;
import game.rpg_engine.world.RelativeCord;

public abstract class Feature implements CanRender {
    char id = '*';
    RelativeCord cord;

    public Feature(char id, RelativeCord cord) {
        this.id = id;
        this.cord = cord;
    }

    public char getId() {
        return this.id;
    }

    public RelativeCord getCord() {
        return this.cord;
    }

    public boolean canWalkOn() {
        return true;
    }

    public boolean canRender(){
        return true;
    }
}

