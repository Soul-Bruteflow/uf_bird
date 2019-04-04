package mvlad.ufbird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Pipe {
    private static final int FLUCTUATION = 130;
    private static final int PIPE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    private Texture topPipe;
    private Texture bottomPipe;
    private Vector2 posTopPipe;
    private Vector2 posBotPipe;
    private Random rand;

    public Pipe(float x){
        topPipe = new Texture("sprites/pipeTop.png");
        bottomPipe = new Texture("sprites/pipeBottom.png");
        rand = new Random();

        posTopPipe = new Vector2(x, rand.nextInt(FLUCTUATION) + PIPE_GAP + LOWEST_OPENING);
        posBotPipe = new Vector2(x, posTopPipe.y - PIPE_GAP - bottomPipe.getHeight());
    }

    public Texture getTopPipe() {
        return topPipe;
    }

    public Texture getBottomPipe() {
        return bottomPipe;
    }

    public Vector2 getPosTopPipe() {
        return posTopPipe;
    }

    public Vector2 getPosBotPipe() {
        return posBotPipe;
    }
}
