package mvlad.ufbird.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import mvlad.ufbird.uf_bird;

public class BackgroundView {

    private Texture background;

    public BackgroundView(){
        background = new Texture("sprites/bckgrnd_day.png");
    }

    public Texture getBackground() {
        return background;
    }

    // Main Menu — Background
    public void renderBackground(SpriteBatch sb, Vector2 position) {
        sb.begin();
        sb.draw(background, position.x, position.y, uf_bird.WIDTH, uf_bird.HEIGHT);
        sb.end();
    }

    public void disposeBackground() {
        background.dispose();
        System.out.println("Background disposed.");
    }
}
