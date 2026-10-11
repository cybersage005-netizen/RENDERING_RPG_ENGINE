package game.rpg_engine.feature;

import game.rpg_engine.entity.Entity;
import game.rpg_engine.enums.ActionResult;
import game.rpg_engine.world.coordinates.RelativeCord;

public abstract class Collectible extends Feature
{
    boolean canRender;

    public Collectible(char ch, String id, RelativeCord cord){
        super(ch, id, cord);
        canRender = true;
    }

    @Override
    public boolean canRender(){
        return this.canRender;
    }

    public void hide(){
        this.canRender = false;
    }

    public abstract ActionResult onCollect(Entity entity);
}
