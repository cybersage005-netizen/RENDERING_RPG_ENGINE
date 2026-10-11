
package game.rpg_engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture image;
    private Texture menuBackground;
    private Texture buttonTexture;
    private Stage stage;
    private Skin skin;
    private Table table;

    @Override
    public void create() {
        batch = new SpriteBatch();

        // Load the existing images.
        image = new Texture(Gdx.files.internal("img.png"));
        menuBackground = new Texture(
            Gdx.files.internal("menu/menu_background_image.jpg")
        );

        // Create the UI skin and font BEFORE creating buttons.
        skin = new Skin();

        BitmapFont font = new BitmapFont();

        Pixmap pixmap = new Pixmap(
            1, 1, Pixmap.Format.RGBA8888
        );
        pixmap.setColor(Color.WHITE);
        pixmap.fill();

        buttonTexture = new Texture(pixmap);
        pixmap.dispose();

        TextButton.TextButtonStyle buttonStyle =
            new TextButton.TextButtonStyle();

        buttonStyle.font = font;
        buttonStyle.fontColor = Color.WHITE;
        buttonStyle.up = new TextureRegionDrawable(
            new TextureRegion(buttonTexture)
        );

        // Register the style before constructing TextButtons.
        skin.add("default-font", font);
        skin.add("default", buttonStyle);

        // Create the Scene2D stage.
        stage = new Stage(new ScreenViewport(), batch);
        Gdx.input.setInputProcessor(stage);

        // Create the menu table.
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Create exactly three buttons.
        TextButton playButton = new TextButton("PLAY", skin);
        TextButton settingsButton =
            new TextButton("SETTINGS", skin);
        TextButton exitButton = new TextButton("EXIT", skin);

        // PLAY centered above the other two buttons.
        table.add(playButton)
            .colspan(2)
            .center()
            .width(250)
            .height(70);

        table.row().padTop(20);

        // SETTINGS on the left, EXIT on the right.
        table.add(settingsButton)
            .width(180)
            .height(55)
            .padRight(20);

        table.add(exitButton)
            .width(180)
            .height(55)
            .padLeft(20);

        // PLAY click action.
        playButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(
                InputEvent event,
                float x, float y, int pointer, int button
            ) {
                return true;
            }

            @Override
            public void touchUp(
                InputEvent event,
                float x, float y, int pointer, int button
            ) {
                Gdx.app.log("Menu", "PLAY clicked!");
            }
        });

        // SETTINGS click action.
        settingsButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(
                InputEvent event,
                float x, float y, int pointer, int button
            ) {
                return true;
            }

            @Override
            public void touchUp(
                InputEvent event,
                float x, float y, int pointer, int button
            ) {
                Gdx.app.log("Menu", "SETTINGS clicked!");
            }
        });

        // EXIT click action.
        exitButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(
                InputEvent event,
                float x, float y, int pointer, int button
            ) {
                return true;
            }

            @Override
            public void touchUp(
                InputEvent event,
                float x, float y, int pointer, int button
            ) {
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        // Draw the background first.
        batch.begin();
        batch.draw(
            menuBackground,
            0,
            0,
            Gdx.graphics.getWidth(),
            Gdx.graphics.getHeight()
        );
        batch.end();

        // Draw the UI over the background.
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        if (stage != null) {
            stage.getViewport().update(width, height, true);
        }
    }

    @Override
    public void dispose() {
        if (stage != null) {
            stage.dispose();
        }

        if (skin != null) {
            skin.dispose();
        }

        if (batch != null) {
            batch.dispose();
        }

        if (image != null) {
            image.dispose();
        }

        if (menuBackground != null) {
            menuBackground.dispose();
        }

        if (buttonTexture != null) {
            buttonTexture.dispose();
        }
    }
}
