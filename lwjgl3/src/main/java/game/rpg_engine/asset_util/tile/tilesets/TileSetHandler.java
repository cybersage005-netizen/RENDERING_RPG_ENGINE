package game.rpg_engine.asset_util.tile.tilesets;

import game.rpg_engine.asset_util.FileUtil;
import game.rpg_engine.util.StrictMap;


public class TileSetHandler {
    public static StrictMap<TileSetId,SimpleTileSet> TILESETS = new StrictMap<>();

    public static void registerSimple(TileSetId id){
        TILESETS.add(id.getId(), id, new SimpleTileSet(FileUtil.getTileSet(id)));
    }

    public static void register3x3(TileSetId id){
        TILESETS.add(id.getId(), id, new TileSet3x3(FileUtil.getTileSet(id)));
    }

    public static SimpleTileSet getSet(TileSetId id){
        return TILESETS.getMapOfValues().stream().filter(pair -> pair.getKey().getId().equals(id.getId())).findFirst().get().getValue();
    }

    public static void fetchAllTileSets(){
        register3x3(TileSetId.of("grass_set"));
    }
}
