package game.rpg_engine.asset_util.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import game.rpg_engine.asset_util.FileUtil;
import game.rpg_engine.asset_util.identifiers.Identifier;
import game.rpg_engine.util.Constants;

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
        Texture playerText = FileUtil.getEntity(Identifier.of("player/player", false));
        float w = playerText.getWidth() * Constants.UNIT_SCALE;
        float h = playerText.getHeight() * Constants.UNIT_SCALE;
        SpriteHandler.addSprite("player",
            new BaseSprite(SpriteId.of("player"),
                new Sprite(playerText),
                0f,0f, h, w ));
    }
}
