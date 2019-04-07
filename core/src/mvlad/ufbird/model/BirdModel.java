package mvlad.ufbird.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class BirdModel extends Model {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 90;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;

    public BirdModel(float x, float y, float width, float height){
        this.bounds = new Rectangle(x, y, width / 3.0f, height);
        this.position = new Vector3(x, y, 0);
        this.velocity = new Vector3(0, 0, 0);
    }

    public void updatePos(float deltaTime){
        if (position.y > 0)
            velocity.add(0, GRAVITY, 0);
        velocity.scl(deltaTime);
        position.add(MOVEMENT * deltaTime, velocity.y, 0);
        velocity.scl(1 / deltaTime);
        if (position.y < 0)
            position.y = 0;

        bounds.setPosition(position.x, position.y);
    }

    public void jump(){
        velocity.y = 250;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }
}
