package game.rpg_engine.asset_util.tile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.rpg_engine.asset_util.identifiers.Identifier;
import game.rpg_engine.asset_util.tile.tilesets.SimpleTileSet;
import game.rpg_engine.asset_util.tile.tilesets.TileSet3x3;

public class Tile {
    private final String id;
    private final TextureRegion texture;

    public Tile(String id, TextureRegion texture) throws Exception {
        if(!Identifier.isValid(id, false)){
            throw new Exception("Wrong tile id!");
        }
        this.texture = texture;
        this.id = id;
    }

    public TextureRegion getTexture(){
        return this.texture;
    }

    public String getId(){
        return this.id;
    }

}
