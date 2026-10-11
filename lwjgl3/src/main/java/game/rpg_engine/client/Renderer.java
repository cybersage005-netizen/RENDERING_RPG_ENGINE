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

         // draw the bucket with width/height of 1 meter
        // Draw the background first
        spriteBatch.draw(
            Files.getEntity(
                Identifier.of("menu/menu_background_image.jpg")
            ),
            0, 0, 20, 12
        );
// Draw the player afterward
        spriteBatch.draw(
            Files.getEntity(Identifier.of("menu/menu_background_image.jpg")),
            0, 0, 8, 5
        );
        spriteBatch.end();
    }
}
