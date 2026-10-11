package game.rpg_engine.asset_util.tile.tilesets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.rpg_engine.asset_util.FileUtil;
import game.rpg_engine.asset_util.identifiers.Identifier;
import game.rpg_engine.asset_util.tile.Tile;
import game.rpg_engine.registries.BuiltInRegistries;
import game.rpg_engine.util.StrictMap;


public class TileSetHandler {


    public static void register3x3(TileSetId id, SimpleTileSet set)  {
        String refinedId = id.getId().replace("_set", "");
        BuiltInRegistries.TILESETS.register(id.getId(),set );
        for(String prefixes : SimpleTileSet.PREFIXES){
            try{
                BuiltInRegistries.TILES.register(refinedId.concat("_".concat(prefixes)), new Tile(refinedId.concat("_".concat(prefixes)), set.getTiles()[SimpleTileSet.PREFIX_TO_TILESET_CORD.get(prefixes).getKey()][SimpleTileSet.PREFIX_TO_TILESET_CORD.get(prefixes).getValue()]));
            }catch (Exception e){
                System.out.println(e);
                System.exit(0);
            }
        }
    }
    public static Tile getTile(String id){
        return BuiltInRegistries.TILES.get(id);
    }

    public static SimpleTileSet getSet(TileSetId id){
        return BuiltInRegistries.TILESETS.get(id.getId());
    }

    public static void fetchAllTileSets(){
        register3x3(TileSetId.of("grass_set"), new TileSet3x3(FileUtil.getTileSet(Identifier.of("grass_set", false))));
    }
}
