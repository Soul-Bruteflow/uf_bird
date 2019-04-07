package mvlad.ufbird.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import mvlad.ufbird.model.GameOverModel;
import mvlad.ufbird.uf_bird;
import mvlad.ufbird.view.GameOverView;

public class GameOverController extends Controller {
    private GameOverModel gameOverModel;
    private GameOverView gameOverView;

    public  GameOverController(GameControllerManager csm) {
        super(csm);
        this.gameOverModel = new GameOverModel();
        this.gameOverView = new GameOverView();

        Vector2 camSize = new Vector2(gameOverModel.setCamSize());
        cam.setToOrtho(false, camSize.x, camSize.y);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            csm.set(new MainMenuController(csm));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        gameOverView.renderBackground(sb, gameOverModel.setBackgroundSize());
        gameOverView.renderScoreBackground(sb, gameOverModel.setScoreBackgroundPos(cam, gameOverView.getScoreBackground()));
        gameOverView.renderTitle(sb, gameOverModel.setTitlePos(cam, gameOverView.getTitle()));

        gameOverView.renderOkBtn(sb, gameOverModel.setOkBtnPos(cam, gameOverView.getOkBtn()));
        gameOverView.renderScoreBtn(sb, gameOverModel.setScoreBtnPos(cam, gameOverView.getScoreBtn()));
        gameOverView.renderCurScore(sb, uf_bird.currentScore, gameOverModel.setCurScorePos(cam, gameOverView.getFont()));
        gameOverView.renderTopScore(sb, gameOverModel.setTopScorePos(cam, gameOverView.getFont()));
        gameOverView.renderTopScoreValue(sb, gameOverModel.setTopScoreValuePos(cam, gameOverView.getFont()));
    }

    @Override
    public void dispose() {
        //gameOverView.disposeBackground();
        //gameOverView.disposePlayBtn();
        //gameOverView.disposeTitle();
        //gameOverView.disposeFooter();
        System.out.println("Main Menu disposed");
    }
}
