package mvlad.ufbird.model;

import com.badlogic.gdx.math.Vector2;

class Model {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    public Vector2 setCamSize(){

        Vector2 ret = new Vector2(0, 0);

        ret.x = WIDTH / 2.0f;
        ret.y = HEIGHT / 2.0f;

        return (ret);
    }
}
