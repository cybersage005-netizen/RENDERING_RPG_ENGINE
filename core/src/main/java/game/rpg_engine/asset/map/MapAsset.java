package game.rpg_engine.asset.map;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.maps.tiled.BaseTiledMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import game.rpg_engine.asset.Asset;

public enum MapAsset implements Asset<TiledMap> {
    MAIN("0A_0A.tmx");

    AssetDescriptor<TiledMap> descriptor;
    MapAsset(String s) {
        BaseTiledMapLoader.Parameters parameters = new BaseTiledMapLoader.Parameters();
        parameters.projectFilePath = "maps/tiled.tiled-project";
        descriptor = new AssetDescriptor<>("maps/"+s, TiledMap.class, parameters);
    }

    @Override
    public AssetDescriptor<TiledMap> getDescriptor() {
        return descriptor;
    }
}
