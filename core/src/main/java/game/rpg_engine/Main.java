package game.rpg_engine;

import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;



import javax.swing.*;
import javax.swing.ButtonGroup;

import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.table;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Texture menuBackground;
    private Viewport viewport;
    private Stage stage;
    private Skin skin;
    private Table table;


    @Override
    public void create() {
        batch = new SpriteBatch();
        viewport = new FitViewport(20, 12);

        image = new Texture("img.png");
        menuBackground = new Texture(
            Gdx.files.internal("menu/menu_background_image.jpg")
        );


        // Scene2D UI setup will go here next.

        stage = new Stage(new ScreenViewport(), batch);
        Gdx.input.setInputProcessor(stage);

        skin = new Skin();

        BitmapFont font = new BitmapFont();
        skin.add("default-font", font);

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        Texture buttonTexture = new Texture(pixmap);
        pixmap.dispose();

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();

        buttonStyle.font = font;
        buttonStyle.fontColor = Color.WHITE;
        buttonStyle.up = new TextureRegionDrawable(
            new com.badlogic.gdx.graphics.g2d.TextureRegion(buttonTexture)
        );

        skin.add("default", buttonStyle);
    }


    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        batch.begin();

        batch.draw(
            menuBackground,
            0,
            0,
            Gdx.graphics.getWidth(),
            Gdx.graphics.getHeight()
        );

        batch.end();
    }
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }


    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        menuBackground.dispose();
    }
}
