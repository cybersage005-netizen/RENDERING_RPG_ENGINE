package game.rpg_engine.asset_util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.rpg_engine.asset_util.identifiers.Identifier;

public class Files {

    public static Texture getTexture(Identifier id){
        return new Texture(id.getId());
    }

    public static Texture getEntity(Identifier id){
        return getTexture(Identifier.of("textures/entity/"+id.getId()));
    }


}
