package mvlad.ufbird.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import mvlad.ufbird.model.MainMenuModel;
import mvlad.ufbird.view.MainMenuView;

public class MainMenuController extends Controller {

    private MainMenuModel menuModel;
    private MainMenuView menuView;
    private Vector3 touchPos;

    public  MainMenuController(GameControllerManager csm) {
        super(csm);
        this.menuModel = new MainMenuModel();
        this.menuView = new MainMenuView();

        Vector2 camSize = new Vector2(menuModel.setCamSize());
        cam.setToOrtho(false, camSize.x, camSize.y);
        touchPos = new Vector3();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touchPos);
            Vector2 tmp = menuModel.setPlayBtnPos(cam, menuView.getPlayBtn());
            if (touchPos.x > tmp.x && touchPos.x < tmp.x + menuView.getPlayBtn().getWidth()) {
                if (touchPos.y > tmp.y && touchPos.y < tmp.y + menuView.getPlayBtn().getHeight()) {
                    csm.set(new PlayController(csm));
                }
            }
            tmp = menuModel.setSkinBtnPos(cam, menuView.getSkinBtn());
            if (touchPos.x > tmp.x && touchPos.x < tmp.x + menuView.getSkinBtn().getWidth()) {
                if (touchPos.y > tmp.y && touchPos.y < tmp.y + menuView.getSkinBtn().getHeight()) {
                    csm.set(new SkinController(csm));
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
        menuView.renderBackground(sb, menuModel.setBackgroundSize());
        menuView.renderPlayBtn(sb, menuModel.setPlayBtnPos(cam, menuView.getPlayBtn()));
        menuView.renderSkinBtn(sb, menuModel.setSkinBtnPos(cam, menuView.getSkinBtn()));
        menuView.renderTitle(sb, menuModel.setTitlePos(cam, menuView.getTitle()));
        menuView.renderFooter(sb, menuModel.setFooterPos(cam));
    }

    @Override
    public void dispose() {
        menuView.disposeBackground();
        menuView.disposePlayBtn();
        menuView.disposeSkinBtn();
        menuView.disposeTitle();
        menuView.disposeFooter();
        System.out.println("Main Menu disposed");
    }
}
