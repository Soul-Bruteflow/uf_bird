package mvlad.ufbird.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

public class GameOverModel extends Model {

    public GameOverModel(){

    }

    public Vector2 setBackgroundSize(){
        Vector2 ret = new Vector2(0, 0);

        ret.x = WIDTH / 2;
        ret.y = HEIGHT / 2;

        return (ret);
    }

    public Vector2 setScoreBackgroundPos(OrthographicCamera cam, Texture texture){
        Vector2 ret = new Vector2(0, 0);

        ret.x = cam.position.x - texture.getWidth() / 2.0f;
        ret.y = cam.position.y;

        return (ret);
    }

    public Vector2 setOkBtnPos(OrthographicCamera cam, Texture texture){
        Vector2 ret = new Vector2(0, 0);

        ret.x = cam.position.x - texture.getWidth() / 2.0f;
        ret.y = cam.position.y;

        return (ret);
    }

    public Vector2 setScoreBtnPos(OrthographicCamera cam, Texture texture){
        Vector2 ret = new Vector2(0, 0);

        ret.x = cam.position.x - texture.getWidth() / 2.0f;
        ret.y = cam.position.y;

        return (ret);
    }

    public Vector2 setTitlePos(OrthographicCamera cam, Texture texture){
        Vector2 ret = new Vector2(0, 0);

        ret.x = cam.position.x - texture.getWidth() / 2.0f;
        ret.y = cam.position.y;

        return (ret);
    }

    public Vector2 setCurScorePos(OrthographicCamera cam, BitmapFont font){
        Vector2 ret = new Vector2(0, 0);

        ret.x = cam.position.x - font.getRegion().getRegionWidth() / 2.0f;
        ret.y = cam.position.y;

        return (ret);
    }

    public Vector2 setTopScorePos(OrthographicCamera cam, BitmapFont font){
        Vector2 ret = new Vector2(0, 0);

        ret.x = cam.position.x - font.getRegion().getRegionWidth() / 2.0f;
        ret.y = cam.position.y;

        return (ret);
    }

    public Vector2 setTopScoreValuePos(OrthographicCamera cam, BitmapFont font){
        Vector2 ret = new Vector2(0, 0);

        ret.x = cam.position.x - font.getRegion().getRegionWidth() / 2.0f;
        ret.y = cam.position.y;

        return (ret);
    }
}
