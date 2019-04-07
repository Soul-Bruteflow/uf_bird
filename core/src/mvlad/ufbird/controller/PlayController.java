package mvlad.ufbird.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import mvlad.ufbird.model.BackgroundModel;
import mvlad.ufbird.model.BirdModel;
import mvlad.ufbird.model.GroundModel;
import mvlad.ufbird.model.PipeModel;
import mvlad.ufbird.model.PlayModel;
import mvlad.ufbird.uf_bird;
import mvlad.ufbird.view.BackgroundView;
import mvlad.ufbird.view.BirdView;
import mvlad.ufbird.view.GroundView;
import mvlad.ufbird.view.PipeView;
import mvlad.ufbird.view.PlayView;

public class PlayController extends Controller {


    private static final int PIPE_SPACING = 125;
    private static final int PIPE_COUNT = 4;
    public static final int PIPE_WIDTH = 52;

    private BirdView birdView;
    private BackgroundView backgroundView;
    private PipeView pipeView;
    private GroundView groundView;
    private PlayView playView;

    private BackgroundModel backgroundModel;
    private BirdModel birdModel;
    private Array<PipeModel> pipesModel;
    private GroundModel groundModel;
    private PlayModel playModel;

    public  PlayController(GameControllerManager csm) {
        super(csm);
        birdView = new BirdView();
        backgroundView = new BackgroundView();
        birdModel = new BirdModel(50, 350, birdView.getBird().getWidth(), birdView.getBird().getHeight());

        Vector2 camSize = new Vector2(birdModel.setCamSize());
        cam.setToOrtho(false, camSize.x, camSize.y);

        pipeView = new PipeView();
        pipesModel = new Array<PipeModel>();
        groundView = new GroundView();
        groundModel = new GroundModel(cam, groundView.getGroundTexture().getWidth());
        backgroundView = new BackgroundView();
        backgroundModel = new BackgroundModel(cam, backgroundView.getBackground().getWidth());

        for(int i = 1; i <= PIPE_COUNT; i++) {
            pipesModel.add(new PipeModel(i * (PIPE_SPACING + PIPE_WIDTH),
                    new Vector2(pipeView.getBottomPipeTexture().getWidth(), pipeView.getBottomPipeTexture().getHeight()),
                    new Vector2(pipeView.getTopPipeTexture().getWidth(), pipeView.getTopPipeTexture().getHeight())));
        }

        playView = new PlayView();
        playModel = new PlayModel(new Vector2(120, 350));

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            birdModel.jump();
            birdView.playWingSound();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        birdModel.updatePos(deltaTime);
        birdView.updateBirdAnimation(deltaTime);
        playModel.updatePos(deltaTime);
        cam.position.x = birdModel.getPosition().x + 80;
        groundModel.updateGround(cam, groundView.getGroundTexture().getWidth());
        backgroundModel.updateBackground(cam, backgroundView.getBackground().getWidth());

        for (int i = 0; i < pipesModel.size; i++) {
            PipeModel pipe = pipesModel.get(i);

            if (cam.position.x - (cam.viewportWidth / 2) > pipe.getPosTopPipe().x + pipeView.getTopPipeTexture().getWidth()) {
                pipe.reposition(pipe.getPosTopPipe().x + ((PIPE_WIDTH + PIPE_SPACING) * PIPE_COUNT), pipeView.getBottomPipeTexture().getHeight());
            }

            if (pipe.collides(birdModel.getBounds())){
                playModel.sotoreCurrentScore(10);
                csm.set(new GameOverController(csm));
            }

            if (pipe.crossPipe(birdModel.getBounds())){
                playModel.incrementScore();
            }
        }
        if(birdModel.getPosition().y <= groundView.getGroundTexture().getHeight() + groundModel.getGroundYOffset()){
            playModel.sotoreCurrentScore(5);
            csm.set(new GameOverController(csm));
        }
        if(birdModel.getPosition().y >= 390){
            playModel.sotoreCurrentScore(5);
            csm.set(new GameOverController(csm));
        }

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        backgroundView.render(sb, backgroundModel.getBackGroundPos1(), backgroundModel.getBackGroundPos2());
        birdView.renderBird(sb, birdModel.getPosition().x, birdModel.getPosition().y);

        for (PipeModel pipe : pipesModel){
            pipeView.render(sb, pipe.getPosBotPipe(), pipe.getPosTopPipe());
        }
        groundView.render(sb, groundModel.getGroundPos1(), groundModel.getGroundPos2());
        playView.renderScore(sb, playModel.getCurrentScore(), playModel.getPos());
    }

    @Override
    public void dispose() {
        pipeView.dispose();
        backgroundView.disposeBackground();
        birdView.dispose();
        groundView.dispose();
    }
}
