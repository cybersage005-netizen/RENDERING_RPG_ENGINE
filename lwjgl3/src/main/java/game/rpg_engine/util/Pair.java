package game.rpg_engine.util;

public class Pair<T, V> {
    private T key;
    private V value;

    protected Pair(T key, V value){
        this.key = key;
        this.value = value;
    }

    public static <T, V> Pair<T, V> of(T key, V value){
        return new Pair<>(key, value);
    }

    public T getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }

    public void setKey(T val){
        this.key = val;
    }

    public void setValue(V val){
        this.value = val;
    }
}
