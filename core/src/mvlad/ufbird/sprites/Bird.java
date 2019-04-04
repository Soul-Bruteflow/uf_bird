package mvlad.ufbird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


public class Bird {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;
    private Texture birdDefault;
    private Rectangle bounds;

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        birdDefault = new Texture("sprites/redbird-upflap.png");
        bounds = new Rectangle(x, y, birdDefault.getWidth(), birdDefault.getHeight());
    }

    public void update(float deltaTime){
        if (position.y > 0)
            velocity.add(0, GRAVITY, 0);
        velocity.scl(deltaTime);
        position.add(MOVEMENT * deltaTime, velocity.y, 0);
        velocity.scl(1 / deltaTime);
        if (position.y < 0)
            position.y = 0;

        bounds.setPosition(position.x, position.y);
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return birdDefault;
    }

    public void jump(){
        velocity.y = 250;
    }

    public void dispose(){
        birdDefault.dispose();
    }
}
