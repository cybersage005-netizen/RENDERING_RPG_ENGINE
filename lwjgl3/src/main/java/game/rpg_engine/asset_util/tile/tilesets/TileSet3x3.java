package game.rpg_engine.asset_util.tile.tilesets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.rpg_engine.util.Constants;

public class TileSet3x3 extends SimpleTileSet {
    public TileSet3x3(Texture texture) {
        super(texture, Constants.TILE_SIZE_PX, Constants.TILE_SIZE_PX);
        if(this.getCount() != 9){
            throw new IllegalStateException("3x3 Tileset is missing tiles or extra tiles are present");
        }
    }

    public TextureRegion getBaseTexture(){
        return this.tiles[1][1];
    }
}
