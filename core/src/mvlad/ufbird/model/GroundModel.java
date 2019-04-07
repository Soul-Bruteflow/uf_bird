package mvlad.ufbird.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class GroundModel extends Model {

    private static final int GROUND_Y_OFFSET = -50;
    private Vector2 groundPos1;
    private Vector2 groundPos2;

    public GroundModel(OrthographicCamera cam, float groundWidth){
        groundPos1 = new Vector2(cam.position.x - cam.viewportWidth / 2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((cam.position.x - cam.viewportWidth / 2) + groundWidth, GROUND_Y_OFFSET);
    }

    public int getGroundYOffset() {
        return GROUND_Y_OFFSET;
    }

    public void updateGround(OrthographicCamera cam, float groundWidth){
        if (cam.position.x - (cam.viewportWidth / 2) > groundPos1.x + groundWidth)
            groundPos1.add(groundWidth * 2, 0);
        if (cam.position.x - (cam.viewportWidth / 2) > groundPos2.x + groundWidth)
            groundPos2.add(groundWidth * 2, 0);
    }

    public Vector2 getGroundPos1() {
        return groundPos1;
    }

    public Vector2 getGroundPos2() {
        return groundPos2;
    }
}
