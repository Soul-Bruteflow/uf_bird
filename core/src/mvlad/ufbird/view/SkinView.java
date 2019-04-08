package mvlad.ufbird.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class SkinView {

    private Texture background;
    private Texture skin1;
    private Texture skin2;
    private Texture skin3;
    private Texture okBtn;
    private BitmapFont font;

    public SkinView(){
        font = new BitmapFont(Gdx.files.internal("fonts/mainFont.fnt"));
        font.getData().setScale(1);
        font.setUseIntegerPositions(false);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        background = new Texture("sprites/bckgrnd_day.png");
        skin1 = new Texture("sprites/redbird-downflap.png");
        skin2 = new Texture("sprites/bluebird-downflap.png");
        skin3 = new Texture("sprites/yellowbird-downflap.png");
        okBtn = new Texture("sprites/okBtn.png");
    }

    public void renderBackground(SpriteBatch sb, Vector2 position) {
        sb.begin();
        sb.draw(background, 0, 0, position.x, position.y);
        sb.end();
    }

    public void disposeBackground() {
        background.dispose();
        System.out.println("Background disposed.");
    }

    public void renderChooseYourSkin(SpriteBatch sb, Vector2 pos){
        sb.begin();
        font.draw(sb, "CHOOSE YOUR SKIN", pos.x, pos.y);
        sb.end();
    }

    public void disposeFont() {
        font.dispose();
        System.out.println("Font disposed.");
    }

    public void renderOkBtn(SpriteBatch sb, Vector2 position){
        sb.begin();
        sb.draw(okBtn, position.x, position.y);
        sb.end();
    }

    public void disposeOkBtn() {
        okBtn.dispose();
        System.out.println("Ok button disposed.");
    }

    public void renderSkin1(SpriteBatch sb, Vector2 position){
        sb.begin();
        sb.draw(skin1, position.x, position.y);
        sb.end();
    }

    public void disposeSkin1() {
        skin1.dispose();
        System.out.println("Skin1 disposed.");
    }

    public void renderSkin2(SpriteBatch sb, Vector2 position){
        sb.begin();
        sb.draw(skin2, position.x, position.y);
        sb.end();
    }

    public void disposeSkin2() {
        skin2.dispose();
        System.out.println("Skin2 disposed.");
    }

    public void renderSkin3(SpriteBatch sb, Vector2 position){
        sb.begin();
        sb.draw(skin3, position.x, position.y);
        sb.end();
    }

    public void disposeSkin3() {
        skin3.dispose();
        System.out.println("Skin3 disposed.");
    }

    public Texture getSkin1() {
        return skin1;
    }

    public Texture getSkin2() {
        return skin2;
    }

    public Texture getSkin3() {
        return skin3;
    }

    public Texture getOkBtn() {
        return okBtn;
    }

    public BitmapFont getFont() {
        return font;
    }
}
