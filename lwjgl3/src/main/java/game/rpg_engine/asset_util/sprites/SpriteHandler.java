package game.rpg_engine.asset_util.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import game.rpg_engine.asset_util.Files;
import game.rpg_engine.asset_util.identifiers.Identifier;
import game.rpg_engine.client.CanRender;

import java.util.HashMap;
import java.util.Map;

public class SpriteHandler {
    public static Map<SpriteId, BaseSprite> INGAME_SPRITES = new HashMap<>();

    public static BaseSprite getSprite(SpriteId id){
        return INGAME_SPRITES.getOrDefault(id, null);
    }

    public static BaseSprite getSprite(String id){
        return getSprite( SpriteId.of(id));
    }

    public static void addSprite(String key, BaseSprite value){
        INGAME_SPRITES.put(SpriteId.of(key), value);
    }

    public static void clear(){
        INGAME_SPRITES.clear();
    }

    public static void init(){
        SpriteHandler.addSprite("player",
            new BaseSprite(SpriteId.of("player"),
                new Sprite(Files.getEntity(Identifier.of("player/player.png"))),
                0f,0f, 4f, 4f));
    }
}
