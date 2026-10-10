package game.rpg_engine.registries;
import java.util.LinkedHashMap;
import java.util.*;

public class Registry<T>
{
    private final String name;
    private final HashMap<String, T> entries = new LinkedHashMap<>();

    public Registry(String name) {
        this.name = name;
    }

    public void register(String id, T elem) {
        if(elem ==null || !isValid(id)){
            throw new IllegalArgumentException("Provided null to be registered");
        }
        if (entries.putIfAbsent(id, elem) != null) {
            throw new IllegalArgumentException(
                    "'" + id + "' is already registered in registry " + name);
        }
    }

    public boolean isValid(String id){
        for(Character ch : id.toCharArray()){
            if(Character.isDigit(ch) || Character.isUpperCase(ch)){
                return false;
            }
        }
        return true;
    }

    public T get(String id) {
        return entries.get(id);
    }

    public Optional<T> find(String id) {
        return Optional.ofNullable(entries.get(id));
    }

    public boolean contains(String id) {
        return entries.containsKey(id);
    }

    public Collection<T> values() {
        return Collections.unmodifiableCollection(entries.values());
    }

    public Set<String> ids() {
        return Collections.unmodifiableSet(entries.keySet());
    }

    public int size() {
        return entries.size();
    }

    public String getName() {
        return name;
    }

}
