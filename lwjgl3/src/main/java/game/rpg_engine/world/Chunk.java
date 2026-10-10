package game.rpg_engine.world;
import game.rpg_engine.entity.Entity;
import game.rpg_engine.feature.Feature;

import java.util.HashMap;

public class Chunk
{
    private HashMap<RelativeCord, ? extends Entity> LOCATIONS = new HashMap<>();
    private RelativeCord start;
    private Map map;
    private final int radX;
    private final int radY;
    private Feature[][] chunk;

    Chunk(RelativeCord start, Map map, int radX, int radY){
        this.start = start;
        this.map = map;
        this.radX = radX;
        this.radY = radY;
        chunk = new Feature[2*radY + 1][2*radX + 1];
    }

    private void set(){

        for(int i = 0; i<=2*start.getY(); i++){
            for(int j = 0; j<=2*start.getX(); j++){

            }
        }
    }

}
