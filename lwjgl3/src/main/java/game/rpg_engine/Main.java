package game.rpg_engine;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.asset_util.sprites.SpriteHandler;
import game.rpg_engine.asset_util.tile.tilesets.TileSetHandler;
import game.rpg_engine.client.renderers.MainRenderer;
import game.rpg_engine.input.server.ServerHandler;
import game.rpg_engine.registries.BuiltInRegistries;
import game.rpg_engine.util.Constants;
import game.rpg_engine.world.coordinates.WorldCord;
import game.rpg_engine.world.map.Map;
import game.rpg_engine.world.map.MapCollection;

public class Main implements ApplicationListener {
    SpriteBatch spriteBatch;
    Viewport viewport;
    MapCollection maps = new MapCollection();
//    public static void main(){
//        BuiltInRegistries.callOut();
//
//
//        Map ORIGIN = Maps.getMap(WorldCord.of(0, 0));
//        ORIGIN.setFeature(new ObstacleFeature(RelativeCord.of(4, 5, ORIGIN)));
//        ORIGIN.setPlayer(new Player(RelativeCord.of(1, 1, ORIGIN), ORIGIN, 90));
//        ORIGIN.setEntity(new Slime(RelativeCord.of(5,4,ORIGIN)));
//        ClientInstance inst = new ClientInstance(Maps);
//        Player player = ORIGIN.getPlayer();
//        inst.render(WorldCord.of(0, 0), player);
//        Scanner sc = new Scanner(System.in);

//        while(true) {
//            char inp = sc.next().charAt(0);
//            if (inp == '.') {
//                return;
//            }
//
//            System.out.println(RelativeCord.of(1,1,ORIGIN).getDownBy(4));
//            player.tick(inp,player);
//            player.getInventory().addItem(Items.APPLE.asStack());
//
//            ORIGIN.movePlayer(player);
//            ORIGIN.tickEntities();
//            inst.render(WorldCord.of(0, 0), player);
//        }
//    }

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(Constants.VIEWPORT_TILES_X, Constants.VIEWPORT_TILES_Y);
        SpriteHandler.init();
        BuiltInRegistries.callOut();
        TileSetHandler.fetchAllTileSets();

        maps.register();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        MainRenderer.draw(spriteBatch, viewport, maps);
        ServerHandler.tick(spriteBatch, viewport);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}

