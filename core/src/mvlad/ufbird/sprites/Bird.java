package mvlad.ufbird.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


public class Bird {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private Rectangle bounds;
    private Animation birdAnimation;
    private Sound wing;

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bird = new Texture("sprites/birdAnimation.png");
        birdAnimation = new Animation(new TextureRegion(bird), 3, 0.5f);
        bounds = new Rectangle(x, y, bird.getWidth() / 3.0f, bird.getHeight());
        wing = Gdx.audio.newSound(Gdx.files.internal("audio/wing.wav"));
    }

    public void update(float deltaTime){
        birdAnimation.update(deltaTime);
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

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    public void jump(){
        velocity.y = 250;
        wing.play(0.5f);
    }

    public void dispose(){
        bird.dispose();
        wing.dispose();
    }
}
