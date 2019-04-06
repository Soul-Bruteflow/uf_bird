package mvlad.ufbird.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class MainMenuModel extends Model {

    public MainMenuModel(){
    }

    public Vector2 setCamSize(){

        Vector2 ret = new Vector2(0, 0);

        ret.x = WIDTH / 2.0f;
        ret.y = HEIGHT / 2.0f;

        return (ret);
    }

    public Vector2 setPlayBtnPos(OrthographicCamera cam, Texture texture){

        Vector2 ret = new Vector2(0, 0);

        ret.x = cam.position.x - texture.getWidth() / 2.0f;
        ret.y = cam.position.y;

        return (ret);
    }

    public Vector2 setBackgroundSize(){

        Vector2 ret = new Vector2(0, 0);

        ret.x = WIDTH / 2;
        ret.y = HEIGHT / 2;

        return (ret);
    }

    public Vector2 setTitlePos(OrthographicCamera cam, Texture texture){

        Vector2 ret = new Vector2(0, 0);

        ret.x = cam.position.x - texture.getWidth() / 2.0f;
        ret.y = cam.position.y + 35;

        return (ret);
    }

    public Vector2 setFooterPos(OrthographicCamera cam){

        Vector2 ret = new Vector2(0, 0);

        ret.x =  cam.position.x - cam.viewportWidth / 2.0f;
        ret.y = 0;

        return (ret);
    }
}
