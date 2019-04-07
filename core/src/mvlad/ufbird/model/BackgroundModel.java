package mvlad.ufbird.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class BackgroundModel {
    private static final int GROUND_Y_OFFSET = -50;
    private Vector2 backroundPos1;
    private Vector2 backroundPos2;

    public BackgroundModel(OrthographicCamera cam, float backgroundWidth){
        backroundPos1 = new Vector2(cam.position.x - cam.viewportWidth / 2, GROUND_Y_OFFSET);
        backroundPos2 = new Vector2((cam.position.x - cam.viewportWidth / 2) + backgroundWidth, GROUND_Y_OFFSET);
    }

    public int getGroundYOffset() {
        return GROUND_Y_OFFSET;
    }

    public void updateBackground(OrthographicCamera cam, float backgroundWidth){
        if (cam.position.x - (cam.viewportWidth / 2) > backroundPos1.x + backgroundWidth)
            backroundPos1.add(backgroundWidth * 2, 0);
        if (cam.position.x - (cam.viewportWidth / 2) > backroundPos2.x + backgroundWidth)
            backroundPos2.add(backgroundWidth * 2, 0);
    }

    public Vector2 getBackGroundPos1() {
        return backroundPos1;
    }

    public Vector2 getBackGroundPos2() {
        return backroundPos2;
    }
}
