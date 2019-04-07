package mvlad.ufbird.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import mvlad.ufbird.sprites.AnimationView;

public class BirdView {
    private Texture bird;
    private AnimationView birdAnimation;
    private Sound wingSound;

    public BirdView(){
        bird = new Texture("sprites/birdAnimation.png");
        wingSound = Gdx.audio.newSound(Gdx.files.internal("audio/wing.wav"));
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

    public void playWingSound(){
        wingSound.play(0.5f);
    }

    public void dispose() {
        bird.dispose();
        wingSound.dispose();
        System.out.println("Bird disposed.");
    }
}
