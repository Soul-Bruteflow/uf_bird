package mvlad.ufbird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import mvlad.ufbird.sprites.Bird;
import mvlad.ufbird.sprites.Pipe;
import mvlad.ufbird.uf_bird;

public class PlayState extends State {

    private Bird birdDefault;
    private Texture bg;
    private Pipe pipe;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        birdDefault = new Bird(50, 100);
        cam.setToOrtho(false, (float)uf_bird.WIDTH / 2, (float)uf_bird.HEIGHT / 2);
        bg = new Texture("sprites/bckgrnd_day.png");
        pipe = new Pipe(100);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            birdDefault.jump();
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        birdDefault.update(deltaTime);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(birdDefault.getTexture(), birdDefault.getPosition().x, birdDefault.getPosition().y);
        sb.draw(pipe.getTopPipe(), pipe.getPosTopPipe().x, pipe.getPosTopPipe().y);
        sb.draw(pipe.getBottomPipe(), pipe.getPosBotPipe().x, pipe.getPosBotPipe().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
