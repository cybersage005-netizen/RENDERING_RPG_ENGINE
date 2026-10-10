package game.rpg_engine.asset_util.sprites;

import game.rpg_engine.asset_util.identifiers.Identifier;

public class SpriteId extends Identifier {
    private SpriteId(String id) throws IllegalAccessException {
        super(id, false);
    }

    public boolean equals(Object spriteId){
        if(spriteId instanceof SpriteId sprite){
            return this.getId().equals(sprite.getId());
        }
       return false;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public static SpriteId of(String id){
        try{
            return new SpriteId(id);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
