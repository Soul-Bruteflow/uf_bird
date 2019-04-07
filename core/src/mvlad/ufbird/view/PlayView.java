package mvlad.ufbird.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PlayView {

    private BitmapFont font;

    public PlayView(){
        font = new BitmapFont(Gdx.files.internal("fonts/mainFont.fnt"));
        font.getData().setScale(1);
        font.setUseIntegerPositions(false);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public void renderScore(SpriteBatch sb, int score, Vector2 pos){
        sb.begin();
        font.draw(sb, Integer.toString(score), pos.x, pos.y);
        sb.end();
    }
}
