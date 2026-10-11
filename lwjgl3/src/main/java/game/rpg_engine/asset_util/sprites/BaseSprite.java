package game.rpg_engine.asset_util.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class BaseSprite {
    private final SpriteId id;
    private Sprite sprite;
    private float x;
    private float y;
    private float height;
    private float width;
    public BaseSprite(SpriteId id, Sprite sprite, float x, float y, float h, float w){
        this.id = id;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.height = h;
        this.width = w;

        this.sprite.setBounds(x,y,w,h);
    }

    public BaseSprite(SpriteId id, Sprite sprite){
        this(id, sprite, 0, 0, 1, 1);
    }

    public void translateTo(float x, float y){
        this.sprite.translate(x,y);
        this.x = sprite.getX();
        this.y = sprite.getY();
    }

    public void translateTo(Vector2 vector2){
        this.translateTo(vector2.x, vector2.y);
    }


    public float getHeight(){
        return this.height;
    }

    public float getWidth(){
        return this.width;
    }

    public SpriteId getId(){
        return this.id;
    }

    public Sprite getSprite(){

        return this.sprite;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

}
