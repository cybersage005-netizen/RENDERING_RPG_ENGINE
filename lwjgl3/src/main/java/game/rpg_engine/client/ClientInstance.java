package game.rpg_engine.client;

import game.rpg_engine.entity.Entity;
import game.rpg_engine.entity.player.Player;
import game.rpg_engine.entity.player.PlayerStatus;
import game.rpg_engine.feature.Feature;
import game.rpg_engine.world.map.Map;
import game.rpg_engine.world.map.MapCollection;
import game.rpg_engine.world.coordinates.WorldCord;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ClientInstance {
    MapCollection maps;
    Queue<Feature> FEATURES = new ArrayDeque();
    Queue<Entity> ENTITIES = new ArrayDeque();

    public ClientInstance(MapCollection collection) {
        this.maps = collection;
    }

    public void render(WorldCord cord, Player player) {
        Map map = this.maps.getMap(cord);
        char[][] current = new char[map.yBound()][map.xBound()];
        List<Feature[]> setFeature = Arrays.stream(map.FEATURES).toList();
        setFeature.forEach((e) -> this.FEATURES.addAll(Arrays.stream(e).toList()));
        this.ENTITIES.addAll(map.ENTITIES);
        boolean renderedInventory = false;
        boolean renderedHealth =false;

        PlayerStatus status = new PlayerStatus(player.getHealth(), player.getInventory());

        for(Feature feature : this.FEATURES) {
            if(!feature.canRender()){
                this.FEATURES.remove();
                continue;
            }
            current[feature.getCord().getY()][feature.getCord().getX()] = feature.getId();
            this.FEATURES.remove();
        }

        for(Entity entity : this.ENTITIES) {
            current[entity.getCord().getY()][entity.getCord().getX()] = entity.getId();
            this.ENTITIES.remove();
        }

        for(char[] row : current) {
            for(char ch : row) {
                System.out.print(ch);
            }
            if(!renderedHealth){
                status.printHealth();
                renderedHealth = true;
                System.out.println();
                continue;
            }
            if(!renderedInventory && renderedHealth){
                status.printInven();
                renderedInventory = true;
            }
            System.out.println();
        }

    }
}
