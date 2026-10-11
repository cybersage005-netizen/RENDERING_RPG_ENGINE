package game.rpg_engine.entity.slime;
import game.rpg_engine.entity.PathfindingEntity;
import game.rpg_engine.entity.player.Player;
import game.rpg_engine.util.Random;
import game.rpg_engine.world.coordinates.RelativeCord;

import java.util.List;


public class Slime extends PathfindingEntity
{
    public Slime(RelativeCord cord){
        super('S', cord, 50, 50, 4);
    }
//
    public void tick(char ch, Player player){
        List<RelativeCord> path;
//        path = this.pathFind(player.getCord());
//
//        if(path.isEmpty()){
//            return;
//        }
//
//        boolean shouldWalk = Random.randBool(80);
//        if(!shouldWalk) return;
//
//        this.cord = path.getFirst();

    }

    public int getTileCost(){
        return 10;
    }
}
