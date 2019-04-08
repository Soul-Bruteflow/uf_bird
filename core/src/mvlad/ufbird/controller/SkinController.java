package mvlad.ufbird.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import mvlad.ufbird.model.SkinModel;
import mvlad.ufbird.uf_bird;
import mvlad.ufbird.view.SkinView;

public class SkinController extends Controller {

        private SkinModel skinModel;
        private SkinView skinView;
        private Vector3 touchPos;
        private static int skin;

        public  SkinController(GameControllerManager csm) {
            super(csm);
            skin = 3;
            this.skinModel = new SkinModel();
            this.skinView = new SkinView();

            Vector2 camSize = new Vector2(skinModel.setCamSize());
            cam.setToOrtho(false, camSize.x, camSize.y);
            touchPos = new Vector3();
        }

        @Override
        public void handleInput() {
            if (Gdx.input.justTouched()){
                touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                cam.unproject(touchPos);
                Vector2 tmp = skinModel.setOkBtnPos(cam, skinView.getOkBtn());
                if (touchPos.x > tmp.x && touchPos.x < tmp.x + skinView.getOkBtn().getWidth()) {
                    if (touchPos.y > tmp.y && touchPos.y < tmp.y + skinView.getOkBtn().getHeight()) {
                        csm.set(new MainMenuController(csm));
                    }
                }
                tmp = skinModel.setSkin1Pos(cam, skinView.getSkin1());
                if (touchPos.x > tmp.x && touchPos.x < tmp.x + skinView.getSkin1().getWidth()) {
                    if (touchPos.y > tmp.y && touchPos.y < tmp.y + skinView.getSkin1().getHeight()) {
                        //
                        skin = 0;
                        uf_bird.skin = 0;
                    }
                }

                tmp = skinModel.setSkin2Pos(cam, skinView.getSkin2());
                if (touchPos.x > tmp.x && touchPos.x < tmp.x + skinView.getSkin2().getWidth()) {
                    if (touchPos.y > tmp.y && touchPos.y < tmp.y + skinView.getSkin2().getHeight()) {
                        //
                        skin = 1;
                        uf_bird.skin = 1;
                    }
                }

                tmp = skinModel.setSkin3Pos(cam, skinView.getSkin3());
                if (touchPos.x > tmp.x && touchPos.x < tmp.x + skinView.getSkin3().getWidth()) {
                    if (touchPos.y > tmp.y && touchPos.y < tmp.y + skinView.getSkin3().getHeight()) {
                        //
                        skin = 2;
                        uf_bird.skin = 2;
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
            skinView.renderBackground(sb, skinModel.setBackgroundSize());
            skinView.renderOkBtn(sb, skinModel.setOkBtnPos(cam, skinView.getOkBtn()));
            if (skin == 0)
                skinView.renderSkin1(sb, skinModel.setSkin1Pos(cam, skinView.getSkin1()).add(0, 15));
            else
                skinView.renderSkin1(sb, skinModel.setSkin1Pos(cam, skinView.getSkin1()));

            if (skin == 1)
                skinView.renderSkin2(sb, skinModel.setSkin2Pos(cam, skinView.getSkin2()).add(0, 15));
            else
                skinView.renderSkin2(sb, skinModel.setSkin2Pos(cam, skinView.getSkin2()));
            if (skin == 2)
                skinView.renderSkin3(sb, skinModel.setSkin3Pos(cam, skinView.getSkin3()).add(0, 15));
            else
                skinView.renderSkin3(sb, skinModel.setSkin3Pos(cam, skinView.getSkin3()));
            skinView.renderChooseYourSkin(sb, skinModel.setChooseYourSkinPos(cam, skinView.getFont()));
        }

        @Override
        public void dispose() {
            skinView.disposeBackground();
            skinView.disposeOkBtn();
            skinView.disposeSkin1();
            skinView.disposeSkin2();
            skinView.disposeSkin3();
            skinView.disposeFont();
            System.out.println("Main Menu disposed");
        }
}
