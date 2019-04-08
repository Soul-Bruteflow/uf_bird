package mvlad.ufbird.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import mvlad.ufbird.model.GameOverModel;
import mvlad.ufbird.uf_bird;
import mvlad.ufbird.view.GameOverView;

public class TopScoreController extends Controller {
    private GameOverModel gameOverModel;
    private GameOverView gameOverView;
    private Vector3 touchPos;

    public  TopScoreController(GameControllerManager csm) {
        super(csm);
        this.gameOverModel = new GameOverModel();
        this.gameOverView = new GameOverView();

        Vector2 camSize = new Vector2(gameOverModel.setCamSize());
        cam.setToOrtho(false, camSize.x, camSize.y);
        touchPos = new Vector3();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touchPos);
            Vector2 tmp = gameOverModel.setOkBtnPosLong(cam, gameOverView.getOkBtn());
            if (touchPos.x > tmp.x && touchPos.x < tmp.x + gameOverView.getOkBtn().getWidth()) {
                if (touchPos.y > tmp.y && touchPos.y < tmp.y + gameOverView.getOkBtn().getHeight()) {
                    csm.set(new GameOverController(csm));
                }
            }
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
        gameOverView.renderOkBtn(sb, gameOverModel.setOkBtnPosLong(cam, gameOverView.getOkBtn()));
        gameOverView.renderTopScore(sb, gameOverModel.setTopScorePosLong(cam, gameOverView.getFont()));
        gameOverView.renderTopScoreValueLong(sb, gameOverModel.setTopScoreValuePosLong(cam, gameOverView.getFont()));
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
