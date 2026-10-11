package game.rpg_engine.feature;


import game.rpg_engine.entity.Entity;
import game.rpg_engine.world.coordinates.RelativeCord;
import game.rpg_engine.enums.ActionResult;
import game.rpg_engine.registries.item.Item;

public class AppleFeature extends Collectible
{
    public AppleFeature(RelativeCord cord){
        super('A', "apple", cord);
    }

    public static Item getItem(){
        return new Item('A', "item_apple", 64);
    }

    @Override
    public ActionResult onCollect(Entity entity){
        if(entity == null && !entity.canHeal()){
            return ActionResult.FAIL;
        }
        entity.healHealth(10);
        return ActionResult.SUCCESS;
    }

    public int getTileCost(){
        return 2;
    }
}
