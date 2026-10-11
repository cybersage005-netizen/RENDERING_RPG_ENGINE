package game.rpg_engine.asset_util;

import com.badlogic.gdx.graphics.Texture;
import game.rpg_engine.asset_util.identifiers.Identifier;

public class FileUtil {

    public static Texture getTexture(Identifier id){
        return new Texture(id.getId());
    }

    public static Texture getEntity(Identifier id){
        return getTexture(Identifier.of("textures/entity/"+id.getId() + ".png"));
    }

    public static Texture getTile(Identifier id){
        return getTexture(Identifier.of("textures/tiles/"+ id.getId()+ ".png"));

    }

    public static Texture getTile(String str){
        return getTile(Identifier.of(str, false));
    }

    public static Texture getTileSet(Identifier id){
        return getTexture(Identifier.of("textures/tiles/tilesets/"+id.getId()+".png"));
    }


}
