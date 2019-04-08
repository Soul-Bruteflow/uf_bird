package mvlad.ufbird.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

public class SkinModel extends Model {

    public SkinModel(){

    }

    public Vector2 setBackgroundSize(){
        Vector2 ret = new Vector2(0, 0);

        ret.x = WIDTH / 2;
        ret.y = HEIGHT / 2;

        return (ret);
    }

    public Vector2 setOkBtnPos(OrthographicCamera cam, Texture texture){
        Vector2 ret = new Vector2(0, 0);

        ret.x = (cam.position.x - texture.getWidth() / 2.0f);
        ret.y = cam.position.y;

        return (ret);
    }

    public Vector2 setSkin1Pos(OrthographicCamera cam, Texture texture){
        Vector2 ret = new Vector2(0, 0);

        ret.x = (cam.position.x - texture.getWidth() / 2.0f) - 40;
        ret.y = cam.position.y + 50;

        return (ret);
    }

    public Vector2 setSkin2Pos(OrthographicCamera cam, Texture texture){
        Vector2 ret = new Vector2(0, 0);

        ret.x = (cam.position.x - texture.getWidth() / 2.0f);
        ret.y = cam.position.y + 50;

        return (ret);
    }

    public Vector2 setSkin3Pos(OrthographicCamera cam, Texture texture){
        Vector2 ret = new Vector2(0, 0);

        ret.x = (cam.position.x - texture.getWidth() / 2.0f) + 40;
        ret.y = cam.position.y + 50;

        return (ret);
    }

    public Vector2 setChooseYourSkinPos(OrthographicCamera cam, BitmapFont font){
        Vector2 ret = new Vector2(0, 0);

        ret.x = (cam.position.x - font.getRegion().getRegionWidth() / 2.0f) + 150;
        ret.y = cam.position.y + 130;

        return (ret);
    }

    public Vector2 increaseSkinY(OrthographicCamera cam, Vector2 curPos){
        Vector2 ret = new Vector2(curPos.x, cam.position.y - 60);

        return (ret);
    }
}
