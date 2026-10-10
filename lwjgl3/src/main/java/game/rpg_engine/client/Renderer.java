package game.rpg_engine.client;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.asset_util.Files;
import game.rpg_engine.asset_util.identifiers.Identifier;

public class Renderer {
    public static void draw(SpriteBatch spriteBatch, Viewport viewport){
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        spriteBatch.draw(Files.getEntity(Identifier.of("player/player.png")), 0, 0, 4, 4); // draw the bucket with width/height of 1 meter

        spriteBatch.end();
    }
}
