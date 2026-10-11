package game.rpg_engine.asset_util.tile.tilesets;

import game.rpg_engine.asset_util.identifiers.Identifier;

public class TileSetId extends Identifier {
    protected TileSetId(String id) throws IllegalAccessException {
        super(id, false);
    }

    public static TileSetId of(String str)  {
      try{
          return new TileSetId(str);
      }
      catch (IllegalAccessException e){
          throw new IllegalStateException(e);
      }
    }

    public int hashCode(){
        return this.getId().hashCode();
    }
}
