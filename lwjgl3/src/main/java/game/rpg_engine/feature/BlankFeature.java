package game.rpg_engine.feature;


import game.rpg_engine.asset_util.identifiers.Identifier;
import game.rpg_engine.world.coordinates.RelativeCord;

public class BlankFeature extends Feature {
    public BlankFeature(RelativeCord cord) {
        super(' ', "grass",cord);
    }

    public int getTileCost(){
        return 1;
    }
}

