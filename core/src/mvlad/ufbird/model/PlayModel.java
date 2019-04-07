package mvlad.ufbird.model;

import com.badlogic.gdx.math.Vector2;

import mvlad.ufbird.uf_bird;

public class PlayModel extends Model {


    private static final int MOVEMENT = 90;
    private int currentScore;
    private Vector2 position;

    public PlayModel(Vector2 scorePos) {
        position = scorePos;
        currentScore = 0;
    }

    public void incrementScore(){
        currentScore++;
    }

    public int getCurrentScore(){
        return currentScore;
    }

    public void updatePos(float deltaTime){
        position.add(MOVEMENT * deltaTime, 0);
    }

    public Vector2 getPos(){
        return position;
    }

    public void sotoreCurrentScore(int scoreSlots){
        for (int i = 0; i < scoreSlots; i++){
            if (currentScore > uf_bird.topScore[i]){
                for (int j = (scoreSlots - 1); j > i; j--){
                    uf_bird.topScore[j] = uf_bird.topScore[j - 1];
                }
                uf_bird.topScore[i] = currentScore;
                break;
            }
        }
        uf_bird.currentScore = currentScore;
    }
}
