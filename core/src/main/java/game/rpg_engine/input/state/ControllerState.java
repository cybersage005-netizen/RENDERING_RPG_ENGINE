package game.rpg_engine.input.state;

import game.rpg_engine.input.Command;

public interface ControllerState {
    void keyDown(Command command);

    default void keyUp(Command command){

    }
}
