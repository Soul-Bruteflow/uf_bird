package mvlad.ufbird.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import mvlad.ufbird.uf_bird;

public class GameOverView {

    private Texture background;
    private Texture scoreBackground;
    private Texture title;
    private Texture okBtn;
    private Texture scoreBtn;
    private BitmapFont font;

    public Texture getBackground() {
        return background;
    }

    public Texture getScoreBackground() {
        return scoreBackground;
    }

    public Texture getTitle() {
        return title;
    }

    public Texture getOkBtn() {
        return okBtn;
    }

    public Texture getScoreBtn() {
        return scoreBtn;
    }

    public BitmapFont getFont() {
        return font;
    }

    public GameOverView(){
        font = new BitmapFont(Gdx.files.internal("fonts/mainFont.fnt"));
        //font.getData().setScale(1);
        font.setUseIntegerPositions(false);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        background = new Texture("sprites/bckgrnd_night.png");
        scoreBackground = new Texture("sprites/scoreBackground.png");
        title = new Texture("sprites/gameover.png");
        okBtn = new Texture("sprites/okBtn.png");
        scoreBtn = new Texture("sprites/scoreBtn.png");
    }

    public void renderBackground(SpriteBatch sb, Vector2 position){
        sb.begin();
        sb.draw(background, 0, 0, position.x, position.y);
        sb.end();
    }

    public void disposeBackground() {
        background.dispose();
        System.out.println("Background disposed.");
    }

    public void renderTitle(SpriteBatch sb, Vector2 position){
        sb.begin();
        sb.draw(title, position.x, position.y);
        sb.end();
    }

    public void disposeTitle() {
        title.dispose();
        System.out.println("Title disposed.");
    }

    public void renderOkBtn(SpriteBatch sb, Vector2 position){
        sb.begin();
        sb.draw(okBtn, position.x, position.y);
        sb.end();
    }

    public void disposeOkBtn() {
        okBtn.dispose();
        System.out.println("OkBtn disposed.");
    }

    public void renderScoreBtn(SpriteBatch sb, Vector2 position){
        sb.begin();
        sb.draw(scoreBtn, position.x, position.y);
        sb.end();
    }

    public void disposeScoreBtn() {
        scoreBtn.dispose();
        System.out.println("ScoreBtn disposed.");
    }

    public void renderCurScore(SpriteBatch sb, int score, Vector2 pos){
        sb.begin();
        font.draw(sb, "Current Score: " + Integer.toString(score), pos.x, pos.y);
        sb.end();
    }
    public void disposeFont() {
        font.dispose();
        System.out.println("Font disposed.");
    }

    public void renderTopScore(SpriteBatch sb, Vector2 pos){
        sb.begin();
        font.draw(sb, "TOP SCORE", pos.x, pos.y);
        sb.end();
    }

    public void renderTopScoreValue(SpriteBatch sb, Vector2 pos){
        sb.begin();
        for (int i = 0; i < 3; i++) {
            font.draw(sb, Integer.toString(i) + ". ", pos.x, pos.y - (i + 1) * 35);
            font.draw(sb, Integer.toString(uf_bird.topScore[i]), pos.x + 35, pos.y - (i + 1) * 35);
        }
        sb.end();
    }

    public void renderTopScoreValueLong(SpriteBatch sb, Vector2 pos){
        sb.begin();
        for (int i = 0; i < 10; i++) {
            font.draw(sb, Integer.toString(i) + ". ", pos.x, pos.y - (i + 1) * 25);
            font.draw(sb, Integer.toString(uf_bird.topScore[i]), pos.x + 35, pos.y - (i + 1) * 25);
        }
        sb.end();
    }
}
