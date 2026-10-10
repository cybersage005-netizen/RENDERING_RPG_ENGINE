package game.rpg_engine.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.lwjgl.system.windows.INPUT;

public class InputUtils {
    public static boolean isWPressed(){
        return Gdx.input.isKeyPressed(Input.Keys.W);
    }
    public static boolean isSPressed(){
        return Gdx.input.isKeyPressed(Input.Keys.S);
    }
    public static boolean isDPressed(){
        return Gdx.input.isKeyPressed(Input.Keys.D);
    }
    public static boolean isAPressed(){
        return Gdx.input.isKeyPressed(Input.Keys.A);
    }



}
