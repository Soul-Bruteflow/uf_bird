package mvlad.ufbird.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import mvlad.ufbird.model.MainMenuModel;
import mvlad.ufbird.view.MainMenuView;

//public class MenuState extends State{
//
//    private Texture backgroundDay;
//    private Texture playBtn;
//
//    public MenuState(GameStateManager gsm) {
//        super(gsm);
//        cam.setToOrtho(false, (float)uf_bird.WIDTH / 2, (float)uf_bird.HEIGHT / 2);
//        backgroundDay = new Texture("sprites/bckgrnd_day.png");
//        playBtn = new Texture("sprites/btn_play.png");
//    }

public class MainMenuController extends Controller {

    private MainMenuModel menuModel;
    private MainMenuView menuView;

    public  MainMenuController(GameControllerManager csm) {
        super(csm);
        this.menuModel = new MainMenuModel();
        this.menuView = new MainMenuView();

        Vector2 camSize = new Vector2(menuModel.setCamSize());
        cam.setToOrtho(false, camSize.x, camSize.y);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            System.out.println("Touch Event");
            //csm.set(new PlayController(csm));
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
        menuView.renderTitle(sb, menuModel.setTitlePos(cam, menuView.getTitle()));
        menuView.renderFooter(sb, menuModel.setFooterPos(cam));
    }

    @Override
    public void dispose() {
        menuView.disposeBackground();
        menuView.disposePlayBtn();
        menuView.disposeTitle();
        menuView.disposeFooter();
        System.out.println("Main Menu disposed");
    }
}
