package game.rpg_engine;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.asset_util.Files;
import game.rpg_engine.asset_util.identifiers.Identifier;
import game.rpg_engine.asset_util.sprites.SpriteHandler;
import game.rpg_engine.client.ClientInstance;
import game.rpg_engine.client.Renderer;
import game.rpg_engine.entity.player.Player;
import game.rpg_engine.entity.slime.Slime;
import game.rpg_engine.feature.ObstacleFeature;
import game.rpg_engine.input.server.ServerHandler;
import game.rpg_engine.registries.BuiltInRegistries;
import game.rpg_engine.registries.Items;
import game.rpg_engine.world.Map;
import game.rpg_engine.world.MapCollection;
import game.rpg_engine.world.RelativeCord;
import game.rpg_engine.world.WorldCord;

import java.util.Scanner;

public class Main implements ApplicationListener {
    SpriteBatch spriteBatch;
    Viewport viewport;
//    public static void main(){
//        BuiltInRegistries.callOut();
//
//        MapCollection Maps = new MapCollection();
//        Maps.register();
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
        viewport = new FitViewport(8, 5);
        SpriteHandler.init();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        Renderer.draw(spriteBatch, viewport);
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

