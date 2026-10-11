package game.rpg_engine.client.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.rpg_engine.asset_util.sprites.SpriteHandler;

public class SpriteRenderer extends Renderer {
    public static void render(SpriteBatch batch, String id){
        SpriteHandler.getSprite(id).getSprite().draw(batch);
    }


}
