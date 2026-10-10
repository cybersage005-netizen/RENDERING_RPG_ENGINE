package game.rpg_engine.asset_util.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import game.rpg_engine.client.CanRender;

import java.util.HashMap;

public class SpriteHandler {
    public static HashMap<SpriteId, Sprite> INGAME_SPRITES = new HashMap<>();

    public static Sprite getSprite(SpriteId id){
        return INGAME_SPRITES.getOrDefault(id, null);
    }
}
