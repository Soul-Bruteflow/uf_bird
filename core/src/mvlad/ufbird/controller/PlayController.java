package mvlad.ufbird.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import mvlad.ufbird.model.BirdModel;
import mvlad.ufbird.model.PipeModel;
import mvlad.ufbird.view.BackgroundView;
import mvlad.ufbird.view.BirdView;
import mvlad.ufbird.view.PipeView;

public class PlayController extends Controller {


    private static final int PIPE_SPACING = 125;
    private static final int PIPE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -50;
    public static final int PIPE_WIDTH = 52;
    private BirdModel birdModel;
    private BirdView birdView;
    private BackgroundView backgroundView;

    private PipeView pipeView;
    private Array<PipeModel> pipesModel;

    public  PlayController(GameControllerManager csm) {
        super(csm);
        birdView = new BirdView();
        backgroundView = new BackgroundView();
        birdModel = new BirdModel(50, 400, birdView.getBird().getWidth(), birdView.getBird().getHeight());

        Vector2 camSize = new Vector2(birdModel.setCamSize());
        cam.setToOrtho(false, camSize.x, camSize.y);

        pipeView = new PipeView();
        pipesModel = new Array<PipeModel>();

        for(int i = 1; i <= PIPE_COUNT; i++) {
            pipesModel.add(new PipeModel(i * (PIPE_SPACING + PIPE_WIDTH),
                    new Vector2(pipeView.getBottomPipeTexture().getWidth(), pipeView.getBottomPipeTexture().getHeight()),
                    new Vector2(pipeView.getTopPipeTexture().getWidth(), pipeView.getTopPipeTexture().getHeight())));
        }

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            birdModel.jump();
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        birdModel.updatePos(deltaTime);
        birdView.updateBirdAnimation(deltaTime);
        cam.position.x = birdModel.getPosition().x + 80;

        for (int i = 0; i < pipesModel.size; i++) {
            PipeModel pipe = pipesModel.get(i);

            if (cam.position.x - (cam.viewportWidth / 2) > pipe.getPosTopPipe().x + pipeView.getTopPipeTexture().getWidth()) {
                pipe.reposition(pipe.getPosTopPipe().x + ((PIPE_WIDTH + PIPE_SPACING) * PIPE_COUNT), pipeView.getBottomPipeTexture().getHeight());
            }

            if (pipe.collides(birdModel.getBounds())){
                csm.set(new PlayController(csm));
            }
        }
        //if(birdModel.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET)
        //    gsm.set(new PlayState(gsm));

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        backgroundView.renderBackground(sb, new Vector2(cam.position.x - (cam.viewportWidth / 2), 0));
        birdView.renderBird(sb, birdModel.getPosition().x, birdModel.getPosition().y);

        for (PipeModel pipe : pipesModel){
            pipeView.render(sb, pipe.getPosBotPipe(), pipe.getPosTopPipe());
        }
    }

    @Override
    public void dispose() {

    }
}
