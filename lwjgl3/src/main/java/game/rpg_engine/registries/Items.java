package game.rpg_engine.registries;

import game.rpg_engine.feature.AppleFeature;
import game.rpg_engine.registries.item.Item;

public class Items
{
    public static final Item APPLE = register(AppleFeature.getItem());

    public static Item register(Item item){
        return register(item.getId(), item.getName(), item.getMaxCount());
    }

    public static Item register(char id, String name, int maxCount){
        Item item = new Item(id, name, maxCount);
        BuiltInRegistries.ITEMS.register(name ,item);
        return item;
    }
}
