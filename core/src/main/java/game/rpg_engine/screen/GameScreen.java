package game.rpg_engine.screen;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.Main;
import game.rpg_engine.asset.AssetService;
import game.rpg_engine.asset.map.MapAsset;
import game.rpg_engine.system.RenderSystem;
import game.rpg_engine.tiled.TiledAshleyConfigurator;
import game.rpg_engine.tiled.TiledService;

import javax.script.AbstractScriptEngine;
import javax.tools.Diagnostic;
import java.util.function.Consumer;

public class GameScreen extends ScreenAdapter {
    private final Main game;
    private final AssetService service;
    private final Batch batch;
    private final Viewport viewport;
    private final OrthographicCamera camera;
    private final Engine engine;
    private final TiledService tiledService;
    private final TiledAshleyConfigurator configurator;


    public GameScreen(Main game) {
        this.game = game;
        this.service = game.getAssetService();
        this.viewport = game.getViewport();
        this.camera = game.getCamera();
        this.batch = game.getBatch();
        this.engine = new Engine();
        this.tiledService = new TiledService(this.service);
        this.configurator = new TiledAshleyConfigurator(engine, service);

        this.engine.addSystem(new RenderSystem(this.batch, this.viewport, this.camera));
    }

    @Override
    public void show(){
    this.service.load(MapAsset.MAIN);
        Consumer<TiledMap> renderConsumer =  this.engine.getSystem(RenderSystem.class)::setMap;
        this.tiledService.setMapChangeConsumer(renderConsumer);
        this.tiledService.setLoadObjectConsumer(this.configurator::onLoadObject);

        TiledMap tiledMap = this.tiledService.loadMap(MapAsset.MAIN);
        this.tiledService.setMap(tiledMap);
    }

    @Override
    public void render(float delta){
        delta = (float) Math.min(delta, 1.0/30);
        this.engine.update(delta);

    }

    @Override
    public void dispose(){
        for(EntitySystem system : this.engine.getSystems()){
            if(system instanceof Disposable sable){
                sable.dispose();
            }
        }

//        this.mapRenderer.dispose();
    }

    @Override
    public void hide(){
        this.engine.removeAllEntities();
    }

}
