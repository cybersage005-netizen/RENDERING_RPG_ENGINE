package game.rpg_engine.asset_util.sprites;

import game.rpg_engine.asset_util.identifiers.Identifier;

public class SpriteId extends Identifier {
    private SpriteId(String id) throws IllegalAccessException {
        super(id, false);
    }

    public boolean equals(SpriteId spriteId){
        return this.getId().equals(spriteId.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}
