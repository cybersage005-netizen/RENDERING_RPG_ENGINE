package game.rpg_engine.world.map;
import game.rpg_engine.asset_util.tile.Tile;
import game.rpg_engine.entity.Entity;
import game.rpg_engine.entity.Ticker;
import game.rpg_engine.enums.Direction;
import game.rpg_engine.feature.BlankFeature;
import game.rpg_engine.feature.Feature;
import game.rpg_engine.feature.ObstacleFeature;
import game.rpg_engine.entity.player.Player;
import game.rpg_engine.registries.BuiltInRegistries;
import game.rpg_engine.world.coordinates.RelativeCord;
import game.rpg_engine.world.coordinates.WorldCord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Map {
    int x;
    int y;
    WorldCord cord;
    public Tile[][] TILEGRID = new Tile[0][0];
    public ArrayList<Entity> ENTITIES = new ArrayList<>();
    public HashMap<String, RelativeCord> CORNER_EDGES = new HashMap<>();

    Map(WorldCord cord, int x, int y) {
        this.x = x;
        this.y = y;
        this.cord = cord;
        this.TILEGRID = new Tile[y][x];
        this.setup();


    }

    private void populateMapCorners(){
        for(int i = 0; i<this.yBound(); i++){
            for(int j = 0; j<this.xBound(); j++){
                RelativeCord cord = RelativeCord.of(j, i, this);
                if(this.isCorner(cord)){

                }
            }
        }
    }

    public void setFeature(Tile tile, int y, int x) {
        this.TILEGRID[y][x] = tile;
    }

    public void setEntity(Entity entity) {
        this.ENTITIES.add(entity);
    }

    public Optional<Entity> getEntityAt(RelativeCord cord){
        return Optional.of(ENTITIES.stream().filter(e -> e.getCord().equals(cord)).toList().getFirst());
    }

    public void tickEntities(){
        for(Entity entity : ENTITIES){
            if(entity instanceof Ticker ticker){
                ticker.tick('c', getPlayer());

            }
        }
    }

    public Tile getTile(Direction dir, RelativeCord cord){
        Optional<Tile> feat = this.getFeatureAt(cord.getCordBy(dir));
        return feat.get();
    }

    public void movePlayer(Player newPlayer) {
        if (this.canWalkTo(newPlayer.getCord())) {
            this.ENTITIES.remove(this.getPlayer());
            this.ENTITIES.add(newPlayer);
        }
    }

    public void setPlayer(Player player) {
        this.setEntity(player);
    }

    public Player getPlayer() {
        for(Entity entity : this.ENTITIES) {
            if (entity instanceof Player player) {
                return player;
            }
        }

        return null;
    }

    public int xBound() {
        return this.x;
    }

    public int yBound() {
        return this.y;
    }

    public boolean canWalkTo(RelativeCord newCord) {
        Optional<Tile> feature = this.getFeatureAt(newCord);
        return true;
    }

    private void setup() {
        for(int i = 0; i < this.yBound(); ++i) {
            for(int j = 0; j < this.xBound(); ++j) {
                RelativeCord cord = RelativeCord.of(j, i, this);
                String tile = "";
                if (!cord.isValid()) {
                    if(cord.isBottomLeft()){

                        tile = "grass_bottom_left";
                    }else if(cord.isTopRight()){
                        tile = "grass_top_right";
                    }
                    else if(cord.isTopLeft()){
                        tile = "grass_top_left";
                    }else if(cord.isBottomRight()){
                        tile = "grass_bottom_right";
                    }else if(cord.isLeftEdge()){
                        tile = "grass_left";
                    }else if(cord.isTopEdge()){
                        tile = "grass_top";
                    }else if(cord.isBottomEdge()){
                        tile = "grass_bottom";
                    }
                    else if(cord.isRightEdge()){
                        tile = "grass_right";
                    }

                    this.setFeature(BuiltInRegistries.TILES.get(tile), i, j);
                } else {
                    this.setFeature(BuiltInRegistries.TILES.get("grass_centre"), i, j);
                }
            }
        }

    }



    public boolean isBoundary(RelativeCord cord){
        if(cord.getY() == 0 || cord.getX() == 0 || cord.getY() == this.y -1 || cord.getX() == this.x-1)return true;
        return false;
    }

    public boolean isCorner(RelativeCord cord){
        if(cord.getX() == 0 && cord.getY() == 0)return true;
        if(cord.getX() == 0 && cord.getY() == this.y-1) return true;
        if(cord.getX() == this.x -1 && cord.getY() == 0) return true;
        if(cord.getX() == this.x -1 && cord.getY() == this.y - 1)return true;
        return false;
    }

    public Optional<Tile> getFeatureAt(RelativeCord cord) {
        int cx = cord.getX(), cy = cord.getY();
        if (cx < 0 || cy < 0 || cx >= x || cy >= y) return Optional.empty();
        return Optional.ofNullable(TILEGRID[cy][cx]);
    }
}

