package mvlad.ufbird.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import mvlad.ufbird.sprites.AnimationView;

public class BirdView {
    private Texture bird;
    private AnimationView birdAnimation;

    public BirdView(){
        bird = new Texture("sprites/birdAnimation.png");
        birdAnimation = new AnimationView(new TextureRegion(bird), 3, 0.5f);
    }

    public void updateBirdAnimation(float deltaTime){
        birdAnimation.update(deltaTime);
    }

    public void renderBird(SpriteBatch sb, float x, float y){
        sb.begin();
        sb.draw(this.getTexture(), x, y);
        sb.end();
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    public Texture getBird() {
        return bird;
    }
}
