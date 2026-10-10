package game.rpg_engine.registries;
import game.rpg_engine.entity.Entity;
import game.rpg_engine.registries.item.Item;

import java.util.LinkedHashMap;
import java.util.HashMap;

public final class BuiltInRegistries {
    private static final HashMap<String, Registry<?>> REGISTRIES = new LinkedHashMap<>();

    private BuiltInRegistries() {}

    public static final Registry<Item> ITEMS = bootstrap(new Registry<>("items"));
    public static final Registry<? extends Entity> ENTITES = bootstrap(new Registry<>("entities"));

    public static void callOut(){
        System.out.println("Registring Registries...");
    }

    private static <T> Registry<T> bootstrap(Registry<T> registry) {
        if (REGISTRIES.putIfAbsent(registry.getName(), registry) != null) {
            throw new IllegalArgumentException(
                    "'" + registry.getName() + "' is already registered as a registry");
        }
        return registry;
    }
}
