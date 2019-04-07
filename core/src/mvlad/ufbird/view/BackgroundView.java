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
    public void render(SpriteBatch sb, Vector2 backgroundPos1, Vector2 backgroundPos2){
        sb.begin();
        sb.draw(background, backgroundPos1.x, backgroundPos1.y);
        sb.draw(background, backgroundPos2.x, backgroundPos2.y);
        sb.end();
    }

    public void disposeBackground() {
        background.dispose();
        System.out.println("Background disposed.");
    }
}
