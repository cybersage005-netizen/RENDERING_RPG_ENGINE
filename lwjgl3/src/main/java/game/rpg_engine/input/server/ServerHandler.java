package game.rpg_engine.input.server;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.asset_util.sprites.BaseSprite;
import game.rpg_engine.asset_util.sprites.SpriteHandler;
import game.rpg_engine.input.InputUtils;

public class ServerHandler {
    public static void tick(SpriteBatch batch, Viewport port){
        float deltaT = Gdx.graphics.getDeltaTime();
        movePlayer(SpriteHandler.getSprite("player"), deltaT);
    }

    private static void movePlayer(BaseSprite sprite, float delta){
        float speed = 0.35f;
        if(InputUtils.isDPressed()){
            sprite.translateTo(speed*delta, 0);
        }
        if(InputUtils.isAPressed()){
            sprite.translateTo(-speed*delta, 0);
        }
        if(InputUtils.isWPressed()){
            sprite.translateTo(0, speed*delta);
        }
        if(InputUtils.isSPressed()){
            sprite.translateTo(0, -speed*delta);
        }else{
            sprite.translateTo(0,0);
        }
    }
}
