package game.rpg_engine.client;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.asset_util.sprites.SpriteRenderer;

public class Renderer {
    public static void drawBG(SpriteBatch spriteBatch, Viewport viewport){
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
    }

    public static void draw(SpriteBatch spriteBatch, Viewport viewport){
        spriteBatch.begin();
        drawBG(spriteBatch, viewport);
        SpriteRenderer.render(spriteBatch, "player");
        spriteBatch.end();
    }
}
