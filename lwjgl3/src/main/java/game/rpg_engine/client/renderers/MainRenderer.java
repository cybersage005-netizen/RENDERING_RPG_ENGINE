package game.rpg_engine.client.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.world.coordinates.WorldCord;
import game.rpg_engine.world.map.MapCollection;

public class MainRenderer extends Renderer {
    public static void drawBG(SpriteBatch spriteBatch, Viewport viewport){
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
    }

    public static void drawMap(SpriteBatch batch, Viewport port, MapCollection collection, WorldCord cord){
        MapRenderer.drawMap(collection, cord, batch, port);
    }

    public static void draw(SpriteBatch spriteBatch, Viewport viewport, MapCollection collection){
        spriteBatch.begin();
        drawBG(spriteBatch, viewport);
        drawMap(spriteBatch, viewport, collection, WorldCord.of(0,0));
        SpriteRenderer.render(spriteBatch, "player");
        spriteBatch.end();
    }
}
