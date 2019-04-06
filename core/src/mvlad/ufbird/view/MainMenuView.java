package mvlad.ufbird.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import mvlad.ufbird.uf_bird;

public class MainMenuView {
    private Texture playBtn;
    private Texture background;
    private Texture title;
    private Texture footer;

    public MainMenuView(){
        playBtn = new Texture("sprites/btn_play.png");
        background = new Texture("sprites/bckgrnd_day.png");
        title = new Texture("sprites/title.png");
        footer = new Texture("sprites/footer.png");
    }

    // Main Menu — Play button
    public void renderPlayBtn(SpriteBatch sb, Vector2 position) {
        sb.begin();
        sb.draw(playBtn, position.x, position.y);
        sb.end();
    }

    public void disposePlayBtn() {
        playBtn.dispose();
        System.out.println("Play button disposed.");
    }


    // Main Menu — Background
    public void renderBackground(SpriteBatch sb, Vector2 position) {
        sb.begin();
        sb.draw(background, 0, 0, position.x, position.y);
        sb.end();
    }

    public void disposeBackground() {
        background.dispose();
        System.out.println("Background disposed.");
    }


    // Main Menu — Title
    public void renderTitle(SpriteBatch sb, Vector2 position) {
        sb.begin();
        sb.draw(title, position.x, position.y);
        sb.end();
    }

    public void disposeTitle() {
        title.dispose();
        System.out.println("Title disposed.");
    }

    // Main Menu — Footer
    public void renderFooter(SpriteBatch sb, Vector2 position) {
        sb.begin();
        sb.draw(footer, position.x, position.y);
        sb.end();
    }

    public void disposeFooter() {
        title.dispose();
        System.out.println("Footer disposed.");
    }


    // Getters
    public Texture getPlayBtn() {
        return playBtn;
    }

    public Texture getFooter() {
        return background;
    }

    public Texture getTitle() {
        return title;
    }
}
