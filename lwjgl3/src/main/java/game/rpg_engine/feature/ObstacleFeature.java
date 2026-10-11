package game.rpg_engine.feature;

import game.rpg_engine.world.coordinates.RelativeCord;

public class ObstacleFeature extends Feature {
    public ObstacleFeature(RelativeCord cord) {
        super('#', "border", cord);
    }

    public boolean canWalkOn() {
        return false;
    }

    public int getTileCost(){
        return 99;
    }
}

