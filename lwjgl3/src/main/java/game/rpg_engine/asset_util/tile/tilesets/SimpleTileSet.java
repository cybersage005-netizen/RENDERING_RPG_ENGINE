package game.rpg_engine.asset_util.tile.tilesets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.rpg_engine.util.Constants;
import game.rpg_engine.util.Pair;

import java.util.HashMap;


public class SimpleTileSet {
    protected final TextureRegion[][] tiles;
    protected final int maxTiles;
    public static final String[] PREFIXES = {"top", "left", "right", "bottom", "top_right", "top_left", "bottom_right", "bottom_left", "centre"};
    public static HashMap<String, Pair<Integer, Integer>> PREFIX_TO_TILESET_CORD = new HashMap<>();

    static{
        PREFIX_TO_TILESET_CORD.put("top", Pair.of(0,1));
        PREFIX_TO_TILESET_CORD.put("top_right", Pair.of(0,2));
        PREFIX_TO_TILESET_CORD.put("top_left", Pair.of(0,0));
        PREFIX_TO_TILESET_CORD.put("bottom", Pair.of(2,1));
        PREFIX_TO_TILESET_CORD.put("left", Pair.of(1,0));
        PREFIX_TO_TILESET_CORD.put("right", Pair.of(1,2));
        PREFIX_TO_TILESET_CORD.put("bottom_right", Pair.of(2,2));
        PREFIX_TO_TILESET_CORD.put("bottom_left", Pair.of(2,0));
        PREFIX_TO_TILESET_CORD.put("centre", Pair.of(1,1));
    }

    public SimpleTileSet(Texture texture, int tileWidth, int tileHeight){
        tiles = TextureRegion.split(texture, tileWidth, tileHeight);

        int count = 0;
        for (TextureRegion[] row : tiles) {
            count += row.length;
        }
        this.maxTiles = count;
    }

    public int hashCode(){
        int code = 0;
        for(TextureRegion[] region : tiles){
            for(TextureRegion text : region){
                code += text.hashCode();
            }
        }
        return code;
    }

    public SimpleTileSet(Texture parentTexture){
        this(parentTexture, Constants.TILE_SIZE_PX, Constants.TILE_SIZE_PX);
    }

    public TextureRegion[][] getTiles(){
        return this.tiles;
    }

    public int getCount(){
        return this.maxTiles;
    }

}
