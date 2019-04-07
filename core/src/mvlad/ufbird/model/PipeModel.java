package mvlad.ufbird.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


import java.util.Random;

import mvlad.ufbird.view.PipeView;

public class PipeModel extends Model {
    private static final int FLUCTUATION = 130;
    private static final int PIPE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    private Vector2 posTopPipe;
    private Vector2 posBotPipe;
    private Random rand;
    private Rectangle boundsTop;
    private Rectangle boundsBot;
    private Rectangle boundsCenter;

    public PipeModel(float x, Vector2 botPipeSize, Vector2 topPipeSize){
        rand = new Random();

        posTopPipe = new Vector2(x, rand.nextInt(FLUCTUATION) + PIPE_GAP + LOWEST_OPENING);
        posBotPipe = new Vector2(x, posTopPipe.y - PIPE_GAP - botPipeSize.y);

        boundsTop = new Rectangle(x, posTopPipe.y, topPipeSize.x, topPipeSize.y);
        boundsBot = new Rectangle(x, posBotPipe.y, botPipeSize.x, botPipeSize.y);
        boundsCenter = new Rectangle(x, posBotPipe.y, 1, 800);
    }

    public Vector2 getPosTopPipe() {
        return posTopPipe;
    }

    public Vector2 getPosBotPipe() {
        return posBotPipe;
    }

    public void reposition(float x,  float botPipeHeight){
        posTopPipe.set(x, rand.nextInt(FLUCTUATION) + PIPE_GAP + LOWEST_OPENING);
        posBotPipe.set(x, posTopPipe.y - PIPE_GAP - botPipeHeight);
        boundsTop.setPosition(x, posTopPipe.y);
        boundsBot.setPosition(x, posBotPipe.y);
        boundsCenter.setPosition(x, posBotPipe.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public boolean crossPipe(Rectangle player){

        boolean tmp;
        tmp = player.overlaps(boundsCenter);
        if (tmp)
            boundsCenter.setPosition(400, 800);

        return tmp;
    }
}
