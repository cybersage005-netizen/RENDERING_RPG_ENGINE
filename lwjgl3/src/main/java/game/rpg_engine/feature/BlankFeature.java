package game.rpg_engine.feature;


import game.rpg_engine.world.RelativeCord;

public class BlankFeature extends Feature {
    public BlankFeature(RelativeCord cord) {
        super(' ', cord);
    }

    public int getTileCost(){
        return 1;
    }
}

