package game.rpg_engine.entity.player;


import game.rpg_engine.entity.player.inventory.Inventory;

public record PlayerStatus(double health, Inventory inventory)
{
    public void printHealth(){
        System.out.print(" Health: " + health);
    }

    public void printInven(){
        System.out.print(" Inventory: " + inventory);
    }
}
