package game.rpg_engine;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.asset.AssetService;
import game.rpg_engine.screen.GameScreen;
import game.rpg_engine.tiled.TiledService;

import javax.swing.text.View;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceConfigurationError;

public class Main extends Game {
    private SpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera camera;
    private AssetService assetService;

    private final Map<Class<? extends Screen>, Screen> SCREEN_CACHE = new HashMap<>();

    public static final int TILE_SIZE_PX = 16;
    public static final float UNIT_SCALE = 1f / TILE_SIZE_PX;
    public static final float VIEWPORT_TILES_X = 16f;
    public static final float VIEWPORT_TILES_Y = 9f;

    public Viewport getViewport(){
        return this.viewport;
    }

    public Batch getBatch(){
        return this.batch;
    }

    public OrthographicCamera getCamera(){
        return this.camera;
    }

    public AssetService getAssetService(){
        return this.assetService;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        viewport = new FitViewport(VIEWPORT_TILES_X, VIEWPORT_TILES_Y, camera);
        assetService = new AssetService(new InternalFileHandleResolver());
        addScreen(new GameScreen(this));
        setScreen(GameScreen.class);
    }

    public void addScreen(Screen sc){
        SCREEN_CACHE.put(sc.getClass(), sc);
    }

    public void resize(int width, int height){
        viewport.update(width, height, true);
        super.resize(width, height);
    }

    public void setScreen(Class<? extends Screen> sc){
        Screen scene = SCREEN_CACHE.get(sc);
        if(scene == null){
            throw new GdxRuntimeException("No scene exists in the cache memory");
        }
        super.setScreen(scene);
    }

    @Override
    public void dispose(){
        SCREEN_CACHE.values().stream().forEach(Screen::dispose);
        SCREEN_CACHE.clear();

        this.batch.dispose();
        this.assetService.debug();
        super.dispose();
    }

}
