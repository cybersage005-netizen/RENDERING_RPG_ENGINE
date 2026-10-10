package game.rpg_engine.asset_util.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface SpriteRenderer {
    public static void render(SpriteBatch batch, String id){
        SpriteHandler.getSprite(id).getSprite().draw(batch);
    }


}
