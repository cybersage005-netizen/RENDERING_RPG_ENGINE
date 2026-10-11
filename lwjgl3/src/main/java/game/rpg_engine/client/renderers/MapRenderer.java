package game.rpg_engine.client.renderers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.asset_util.FileUtil;
import game.rpg_engine.asset_util.identifiers.Identifier;
import game.rpg_engine.asset_util.tile.tilesets.TileSet3x3;
import game.rpg_engine.asset_util.tile.tilesets.TileSetHandler;
import game.rpg_engine.asset_util.tile.tilesets.TileSetId;
import game.rpg_engine.feature.Feature;
import game.rpg_engine.world.map.Map;
import game.rpg_engine.world.map.MapCollection;
import game.rpg_engine.world.coordinates.WorldCord;

public class MapRenderer extends Renderer{
public static void drawMap(MapCollection collection, WorldCord cord, SpriteBatch batch, Viewport port){
        Map map = collection.getMap(cord);
        Feature[][] feature = map.FEATURES;

        Texture grass = FileUtil.getTile("grass");
        TileSet3x3 grassSet = (TileSet3x3) TileSetHandler.getSet(TileSetId.of("grass_set"));

        for (int y = 0; y < feature.length; y++) {
            for (int x = 0; x < feature[y].length; x++) {
                batch.draw(grassSet.getTiles()[0][0], x, y, 1, 1);
            }
        }

    }
}
