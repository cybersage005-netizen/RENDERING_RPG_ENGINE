package game.rpg_engine.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Graphic implements Component {
    public static final ComponentMapper<Graphic> MAPPER = ComponentMapper.getFor(Graphic.class);

    private TextureRegion region;
    private final Color color;

    public Graphic(Color color, TextureRegion region) {
        this.region = region;
        this.color = color;
    }

    public void setRegion(TextureRegion newRegion){
        this.region = newRegion;
    }

    public Color getColor(){
        return this.color;
    }

    public TextureRegion getRegion(){
        return this.region;
    }
}
