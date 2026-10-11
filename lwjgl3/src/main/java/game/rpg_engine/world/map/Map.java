package game.rpg_engine.world.map;
import game.rpg_engine.entity.Entity;
import game.rpg_engine.entity.Ticker;
import game.rpg_engine.enums.Direction;
import game.rpg_engine.feature.BlankFeature;
import game.rpg_engine.feature.Feature;
import game.rpg_engine.feature.ObstacleFeature;
import game.rpg_engine.entity.player.Player;
import game.rpg_engine.world.coordinates.RelativeCord;
import game.rpg_engine.world.coordinates.WorldCord;

import java.util.ArrayList;
import java.util.Optional;

public class Map {
    int x;
    int y;
    WorldCord cord;
    public Feature[][] FEATURES = new Feature[0][0];
    public ArrayList<Entity> ENTITIES = new ArrayList<>();

    Map(WorldCord cord, int x, int y) {
        this.x = x;
        this.y = y;
        this.cord = cord;
        this.FEATURES = new Feature[y][x];
        this.setup();
    }

    public void setFeature(Feature feature) {
        this.FEATURES[feature.getCord().getY()][feature.getCord().getX()] = feature;
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

    public Feature getTile(Direction dir, RelativeCord cord){
        Optional<Feature> feat = this.getFeatureAt(cord.getCordBy(dir));
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
        Optional<Feature> feature = this.getFeatureAt(newCord);
        return (Boolean)feature.map(Feature::canWalkOn).orElse(true);
    }

    private void setup() {
        for(int i = 0; i < this.yBound(); ++i) {
            for(int j = 0; j < this.xBound(); ++j) {
                if (!RelativeCord.of(j, i, this).isValid()) {
                    this.setFeature(new ObstacleFeature(RelativeCord.of(j, i, this)));
                } else {
                    this.setFeature(new BlankFeature(RelativeCord.of(j, i, this)));
                }
            }
        }

    }

    public String toString(){
        String str = "";
        for(Feature[] f :  FEATURES){
            for(Feature ff : f){
                str = str.concat(Character.toString(ff.getId()));
            }
            str = str.concat("\n");
        }

        return str;
    }

    public Optional<Feature> getFeatureAt(RelativeCord cord) {
        int cx = cord.getX(), cy = cord.getY();
        if (cx < 0 || cy < 0 || cx >= x || cy >= y) return Optional.empty();
        return Optional.ofNullable(FEATURES[cy][cx]);
    }
}

