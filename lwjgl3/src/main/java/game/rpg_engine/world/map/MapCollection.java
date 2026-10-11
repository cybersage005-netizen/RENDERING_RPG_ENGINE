package game.rpg_engine.world.map;

import game.rpg_engine.world.coordinates.WorldCord;

import java.util.HashMap;

public class MapCollection {
    public HashMap<WorldCord, Map> MAPS = new HashMap();

    public void register() {
        this.MAPS.put(WorldCord.of(0, 0), new Map(WorldCord.of(0, 0), 10, 10));
    }

    public HashMap<WorldCord, Map> getMaps() {
        return this.MAPS;
    }

    public Map getMap(WorldCord cord) {
        return (Map)this.getMaps().get(cord);
    }
}
