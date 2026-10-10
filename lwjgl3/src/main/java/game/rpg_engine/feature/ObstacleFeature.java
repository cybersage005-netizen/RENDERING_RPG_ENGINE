package game.rpg_engine.feature;

import game.rpg_engine.world.RelativeCord;

public class ObstacleFeature extends Feature {
    public ObstacleFeature(RelativeCord cord) {
        super('#', cord);
    }

    public boolean canWalkOn() {
        return false;
    }

    public int getTileCost(){
        return 99;
    }
}

