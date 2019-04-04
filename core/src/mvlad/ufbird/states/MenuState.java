package mvlad.ufbird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import mvlad.ufbird.uf_bird;

public class MenuState extends State{

    private Texture backgroundDay;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        backgroundDay = new Texture("sprites/bckgrnd_day.png");
        playBtn = new Texture("sprites/btn_play.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw(backgroundDay, 0, 0, uf_bird.WIDTH, uf_bird.HEIGHT);
        sb.draw(playBtn, (float)uf_bird.WIDTH / 2 - (float)playBtn.getWidth() / 2, (float)uf_bird.HEIGHT / 2);
        sb.end();
    }

    @Override
    public void dispose() {
        backgroundDay.dispose();
        playBtn.dispose();
    }
}