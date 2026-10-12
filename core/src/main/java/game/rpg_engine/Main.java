package game.rpg_engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Main implements ApplicationListener {
    private SpriteBatch batch;
    private Texture image;
    private Viewport viewport;
    public static final int TILE_SIZE_PX = 16;
    public static final float UNIT_SCALE = 1f / TILE_SIZE_PX;
    public static final float VIEWPORT_TILES_X = 20f;
    public static final float VIEWPORT_TILES_Y = 11.25f; // 16:9


    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        viewport = new FitViewport(VIEWPORT_TILES_X, VIEWPORT_TILES_Y);

    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 140, 210);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
