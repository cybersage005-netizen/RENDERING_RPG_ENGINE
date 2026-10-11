package game.rpg_engine.asset_util.tile.tilesets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.rpg_engine.util.Constants;


public class SimpleTileSet {
    protected final TextureRegion[][] tiles;
    protected final int maxTiles;

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
