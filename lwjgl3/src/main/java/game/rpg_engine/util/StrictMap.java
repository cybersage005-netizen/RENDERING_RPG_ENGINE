package game.rpg_engine.util;

import java.util.Collection;
import java.util.HashMap;

public class StrictMap<T, V> {
    private HashMap<String, Pair<T, V>> MAP = new HashMap<>();

    public void add(String id,T key, V value){
        if(!MAP.containsKey(id)){
            MAP.put(id, Pair.of(key, value));
        }else{
            throw new IllegalArgumentException("ID in strict map already exists!");
        }
    }

    public Collection<Pair<T, V>> getMapOfValues(){
        return this.MAP.values();
    }

    public Collection<String> getKeys(){
        return this.MAP.keySet();
    }

    public HashMap<String, Pair<T, V>> getMap(){
        return this.MAP;
    }
}
