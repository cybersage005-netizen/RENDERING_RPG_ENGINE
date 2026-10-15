package game.rpg_engine.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.utils.Disposable;

public class AssetService implements Disposable {
    private final AssetManager manager;

    public AssetService(FileHandleResolver resolver){
        this.manager = new AssetManager(resolver);
        this.manager.setLoader(TiledMap.class, new TmxMapLoader());
    }

    public <T> T load(Asset<T> asset){
        this.manager.load(asset.getDescriptor());
        this.manager.finishLoading();
        return this.manager.get(asset.getDescriptor());
    }

    public <T> void unload(Asset<T> asset) {
        this.manager.unload(asset.getDescriptor().fileName);
    }

    public <T> void queue(Asset<T> asset){
        this.manager.load(asset.getDescriptor());
    }

    public <T> T get(Asset<T> asset){
        return this.manager.get(asset.getDescriptor());
    }

    public boolean update(){
        return this.manager.update();
    }

    public void debug(){
        Gdx.app.debug("AssetService", this.manager.getDiagnostics());
    }

    @Override
    public void dispose() {
        this.manager.dispose();
    }
}
