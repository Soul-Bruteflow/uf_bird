package mvlad.ufbird.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import mvlad.ufbird.sprites.AnimationView;
import mvlad.ufbird.uf_bird;

public class BirdView {
    private Texture bird;
    private AnimationView birdAnimation;
    private Sound wingSound;

    public BirdView(){
        if (uf_bird.skin == 0)
            bird = new Texture("sprites/birdAnimation1.png");
        if (uf_bird.skin == 1)
            bird = new Texture("sprites/birdAnimation2.png");
        if (uf_bird.skin == 2)
            bird = new Texture("sprites/birdAnimation3.png");

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
