package game.rpg_engine.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.lwjgl.system.windows.INPUT;

public class InputUtils {
    public boolean isWPressed(){
        return Gdx.input.isButtonPressed(Input.Keys.W);
    }
    public boolean isSPressed(){
        return Gdx.input.isButtonPressed(Input.Keys.S);
    }
    public boolean isDPressed(){
        return Gdx.input.isButtonPressed(Input.Keys.D);
    }
    public boolean isAPressed(){
        return Gdx.input.isButtonPressed(Input.Keys.A);
    }



}
