package game.rpg_engine.tiled;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Vector2;
import game.rpg_engine.Main;
import game.rpg_engine.asset.AssetService;
import game.rpg_engine.component.Graphic;
import game.rpg_engine.component.Transform;

public class TiledAshleyConfigurator {
    private final Engine engine;
    private final AssetService service;


    public TiledAshleyConfigurator(Engine engine, AssetService service) {
        this.engine = engine;
        this.service = service;
    }

    public void onLoadObject(TiledMapTileMapObject object){
        Entity entity = this.engine.createEntity();
        TiledMapTile tile = object.getTile();
        TextureRegion textureRegion = getTextureRegion(tile);
        int z = tile.getProperties().get("z", 1, Integer.class);

        entity.add(new Graphic(Color.WHITE.cpy(), textureRegion));
        addEntityTransform(
            object.getX(), object.getY(), z,
            textureRegion.getRegionWidth(), textureRegion.getRegionHeight(),
            object.getScaleX(),object.getScaleY(),
            entity);

        this.engine.addEntity(entity);
    }

    private static void addEntityTransform(
        float x, float y, int z,
        float w, float h,
        float scaleX, float scaleY,

        Entity entity
    ) {
        Vector2 position = new Vector2(x, y);
        Vector2 size = new Vector2(w, h);
        Vector2 scaling = new Vector2(scaleX, scaleY);

        position.scl(Main.UNIT_SCALE);
        size.scl(Main.UNIT_SCALE);

        entity.add(new Transform(position, z, size, scaling, 0f));
    }

    private TextureRegion getTextureRegion(TiledMapTile tile) {
        return tile.getTextureRegion();
    }
}
