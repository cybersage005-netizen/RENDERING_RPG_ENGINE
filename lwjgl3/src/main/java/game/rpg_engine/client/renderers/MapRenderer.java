package game.rpg_engine.client.renderers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.rpg_engine.asset_util.FileUtil;
import game.rpg_engine.asset_util.identifiers.Identifier;
import game.rpg_engine.asset_util.tile.Tile;
import game.rpg_engine.asset_util.tile.tilesets.TileSet3x3;
import game.rpg_engine.asset_util.tile.tilesets.TileSetHandler;
import game.rpg_engine.asset_util.tile.tilesets.TileSetId;
import game.rpg_engine.feature.Feature;
import game.rpg_engine.registries.BuiltInRegistries;
import game.rpg_engine.world.map.Map;
import game.rpg_engine.world.map.MapCollection;
import game.rpg_engine.world.coordinates.WorldCord;

import java.sql.BatchUpdateException;

public class MapRenderer extends Renderer{
public static void drawMap(MapCollection collection, WorldCord cord, SpriteBatch batch, Viewport port){
        Map map = collection.getMap(cord);
        Tile[][] feature = map.TILEGRID;

        int rows = feature.length;
        for (int row = 0; row < rows; row++) {
            for (int x = 0; x < feature[row].length; x++) {
                batch.draw(feature[row][x].getTexture(), x, rows - 1 - row, 1, 1);
            }
        }

    }
}
