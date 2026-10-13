package game.rpg_engine.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.Main;
import game.rpg_engine.asset.AssetService;
import game.rpg_engine.asset.map.MapAsset;

public class GameScreen extends ScreenAdapter {
    private final Main game;
    private final AssetService service;
    private final Batch batch;
    private final Viewport viewport;
    private final OrthographicCamera camera;
    private final OrthogonalTiledMapRenderer mapRenderer;

    public GameScreen(Main game) {
        this.game = game;
        this.service = game.getAssetService();
        this.viewport = game.getViewport();
        this.camera = game.getCamera();
        this.batch = game.getBatch();
        this.mapRenderer = new OrthogonalTiledMapRenderer(this.service.load(MapAsset.MAIN), Main.UNIT_SCALE, this.batch);
    }

    @Override
    public void show(){
        this.mapRenderer.setMap(this.service.get(MapAsset.MAIN));
    }

    @Override
    public void render(float delta){
        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);
        this.viewport.apply();
        this.camera.update();
        this.batch.setColor(Color.WHITE);
        this.mapRenderer.setView(this.camera);
        this.mapRenderer.render();
    }

    @Override
    public void dispose(){
        this.mapRenderer.dispose();
    }


}
