package game.rpg_engine.entity;

import game.rpg_engine.entity.player.Player;

public interface Ticker {


    void tick(char ch, Player pl);
}

