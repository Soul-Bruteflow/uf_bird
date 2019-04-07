package mvlad.ufbird.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PipeView {
    private Texture topPipe;
    private Texture bottomPipe;

    public PipeView(){
        topPipe = new Texture("sprites/pipeTop.png");
        bottomPipe = new Texture("sprites/pipeBottom.png");
    }

    public void render(SpriteBatch sb, Vector2 botPipePos, Vector2 topPipePos) {
        sb.begin();
        sb.draw(bottomPipe, botPipePos.x, botPipePos.y);
        sb.draw(topPipe, topPipePos.x, topPipePos.y);
        sb.end();
    }

    public Texture getTopPipeTexture() {
        return topPipe;
    }

    public Texture getBottomPipeTexture() {
        return bottomPipe;
    }

    public void dispose(){
        topPipe.dispose();
        bottomPipe.dispose();
    }
}
