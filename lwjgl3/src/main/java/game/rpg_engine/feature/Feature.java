package game.rpg_engine.feature;


import com.badlogic.gdx.graphics.Texture;
import game.rpg_engine.asset_util.identifiers.Identifier;
import game.rpg_engine.client.CanRender;
import game.rpg_engine.world.coordinates.RelativeCord;

public abstract class Feature implements CanRender {
    protected char id = '*';
    protected RelativeCord cord;
    protected Identifier texture;

    public Feature(char id, String texture, RelativeCord cord) {
        this.id = id;
        this.cord = cord;
        this.texture = Identifier.of(texture, false);
    }

    public char getId() {
        return this.id;
    }

    public Identifier getTexture(){
        return this.texture;
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

