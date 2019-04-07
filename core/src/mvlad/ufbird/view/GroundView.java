package mvlad.ufbird.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GroundView {

    private Texture ground;

    public GroundView() {
        ground = new Texture("sprites/ground.png");
    }

    public void render(SpriteBatch sb, Vector2 groundPos1, Vector2 groundPos2){
        sb.begin();
        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);
        sb.end();
    }

    public Texture getGroundTexture() {
        return ground;
    }

    public void dispose() {
        ground.dispose();
        System.out.println("Ground disposed.");
    }
}
