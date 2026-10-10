package game.rpg_engine.entity.player;

import game.rpg_engine.entity.Entity;
import game.rpg_engine.entity.Ticker;
import game.rpg_engine.entity.player.inventory.HasInventory;
import game.rpg_engine.entity.player.inventory.Inventory;
import game.rpg_engine.world.Map;
import game.rpg_engine.world.RelativeCord;

import static game.rpg_engine.entity.Entity.BASIC_MOVEMENT;

public class Player extends Entity implements Ticker, HasInventory {
    Map currentMap;
    Inventory inventory;

    public Player(RelativeCord cord, Map map, double health) {
        super('P', cord, health, 100, 10);
        this.currentMap = map;
        this.inventory  = new Inventory(5);
    }


    public Map getMap(){
        return this.currentMap;
    }

    public int getTileCost(){
        return 1;
    }

    public void tick(char ch, Player player) {
        RelativeCord newCord = (RelativeCord)BASIC_MOVEMENT.apply(ch, this.getCord());
        if (this.currentMap.canWalkTo(newCord)) {
            this.cord = newCord;
        }

    }

    public Inventory getInventory(){
        return this.inventory;
    }
}
