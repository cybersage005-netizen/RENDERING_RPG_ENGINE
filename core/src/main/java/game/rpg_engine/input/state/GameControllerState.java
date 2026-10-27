package game.rpg_engine.input.state;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import game.rpg_engine.component.Controller;
import game.rpg_engine.input.Command;

public class GameControllerState implements ControllerState{
    private final ImmutableArray<Entity> controllerEntities;

    public GameControllerState(Engine engine) {
        this.controllerEntities = engine.getEntitiesFor(Family.all(Controller.class).get());
    }


    @Override
    public void keyDown(Command command) {
        controllerEntities.forEach(e -> Controller.MAPPER.get(e).getPressedCommands().add(command));
    }

    @Override
    public void keyUp(Command command){
        controllerEntities.forEach(e -> Controller.MAPPER.get(e).getReleasedCommands().add(command));
    }
}
