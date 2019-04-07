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
    public void render(SpriteBatch sb, Vector2 groundPos1, Vector2 groundPos2){
        sb.begin();
        sb.draw(background, groundPos1.x, groundPos1.y);
        sb.draw(background, groundPos2.x, groundPos2.y);
        sb.end();
    }

    public void disposeBackground() {
        background.dispose();
        System.out.println("Background disposed.");
    }
}
