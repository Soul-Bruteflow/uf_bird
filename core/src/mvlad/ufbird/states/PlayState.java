package mvlad.ufbird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import mvlad.ufbird.sprites.Bird;
import mvlad.ufbird.sprites.Pipe;
import mvlad.ufbird.uf_bird;

public class PlayState extends State {

    private static final int PIPE_SPACING = 125;
    private static final int PIPE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -50;
    private Bird birdDefault;
    private Texture bg;
    private Texture ground;
    private Array<Pipe> pipes;
    private Vector2 groundPos1;
    private Vector2 groundPos2;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        birdDefault = new Bird(50, 400);
        cam.setToOrtho(false, (float)uf_bird.WIDTH / 2, (float)uf_bird.HEIGHT / 2);
        bg = new Texture("sprites/bckgrnd_day.png");
        ground = new Texture("sprites/ground.png");
        groundPos1 = new Vector2(cam.position.x - cam.viewportWidth / 2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((cam.position.x - cam.viewportWidth / 2) + ground.getWidth(), GROUND_Y_OFFSET);

        pipes = new Array<Pipe>();

        for(int i = 1; i <= PIPE_COUNT; i++) {
            pipes.add(new Pipe(i * (PIPE_SPACING + Pipe.PIPE_WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            birdDefault.jump();
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        updateGround();
        birdDefault.update(deltaTime);

        cam.position.x = birdDefault.getPosition().x + 80;

        for (int i = 0; i < pipes.size; i++) {
            Pipe pipe = pipes.get(i);

            if (cam.position.x - (cam.viewportWidth / 2) > pipe.getPosTopPipe().x + pipe.getTopPipe().getWidth()) {
                pipe.reposition(pipe.getPosTopPipe().x + ((Pipe.PIPE_WIDTH + PIPE_SPACING) * PIPE_COUNT));
            }

            if (pipe.collides(birdDefault.getBounds())){
                gsm.set(new PlayState(gsm));
            }
        }
        if(birdDefault.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET)
            gsm.set(new PlayState(gsm));
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(birdDefault.getTexture(), birdDefault.getPosition().x, birdDefault.getPosition().y);

        for (Pipe pipe : pipes){
            sb.draw(pipe.getTopPipe(), pipe.getPosTopPipe().x, pipe.getPosTopPipe().y);
            sb.draw(pipe.getBottomPipe(), pipe.getPosBotPipe().x, pipe.getPosBotPipe().y);
        }

        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        ground.dispose();
        birdDefault.dispose();
        for (Pipe pipe : pipes)
            pipe.dispose();
        System.out.println("Play State Disposed");
    }

    private void updateGround(){
        if (cam.position.x - (cam.viewportWidth / 2) > groundPos1.x + ground.getWidth())
            groundPos1.add(ground.getWidth() * 2, 0);
        if (cam.position.x - (cam.viewportWidth / 2) > groundPos2.x + ground.getWidth())
            groundPos2.add(ground.getWidth() * 2, 0);
    }
}
