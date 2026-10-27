package game.rpg_engine.screen;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import game.rpg_engine.Main;
import game.rpg_engine.asset.map.MapAsset;
import game.rpg_engine.input.KeyboardController;
import game.rpg_engine.input.state.GameControllerState;
import game.rpg_engine.system.*;
import game.rpg_engine.system.render.PhysicDebugRenderSystem;
import game.rpg_engine.tiled.TiledAshleyConfigurator;
import game.rpg_engine.tiled.TiledService;

import java.util.function.Consumer;

public class GameScreen extends ScreenAdapter {
    private final Main game;
    private final Engine engine;
    private final TiledService tiledService;
    private final TiledAshleyConfigurator configurator;
    private final KeyboardController controller;
    private final World physicWorld;


    public GameScreen(Main game) {
        this.game = game;
        this.engine = new Engine();
        this.tiledService = new TiledService(game.getAssetService());
        this.physicWorld = new World(Vector2.Zero, true);
        this.physicWorld.setAutoClearForces(false);
        this.configurator = new TiledAshleyConfigurator(engine, physicWorld, game.getAssetService());
        this.controller = new KeyboardController(GameControllerState.class, engine);


        this.engine.addSystem(new ControllerSystem(game));
        this.engine.addSystem(new PhysicMoveSystem());
        this.engine.addSystem(new FsmSystem());
        this.engine.addSystem(new FacingSystem());
        this.engine.addSystem(new PhysicSystem(physicWorld, 1/60f));
        this.engine.addSystem(new AnimationSystem(game.getAssetService()));

        //frame rendered here
        this.engine.addSystem(new RenderSystem(game.getBatch(), game.getViewport(), game.getCamera()));
        this.engine.addSystem(new PhysicDebugRenderSystem(this.physicWorld, this.game.getCamera()));
    }

    @Override
    public void show(){
    game.getAssetService().load(MapAsset.MAIN);
        game.setInputProcessors(controller);
        controller.setActiveState(GameControllerState.class);
        Consumer<TiledMap> renderConsumer =  this.engine.getSystem(RenderSystem.class)::setMap;
        this.tiledService.setMapChangeConsumer(renderConsumer);
        this.tiledService.setLoadObjectConsumer(this.configurator::onLoadObject);
        this.tiledService.setLoadTileConsumer(this.configurator::onLoadTile);

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
        this.physicWorld.dispose();
//        this.mapRenderer.dispose();
    }

    @Override
    public void hide(){
        this.engine.removeAllEntities();
    }

}
