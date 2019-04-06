package mvlad.ufbird.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameControllerManager {

    private Stack<Controller> controllers;

    public GameControllerManager(){
        controllers = new Stack<Controller>();
    }

    public void push(Controller controller){
        controllers.push(controller);
    }

    public void pop(){

        controllers.pop().dispose();
    }

    public void set(Controller controller){
        controllers.pop().dispose();
        controllers.push(controller);
    }

    public void update(float deltaTime){
        controllers.peek().update(deltaTime);
    }

    public void render(SpriteBatch sb){
        controllers.peek().render(sb);
    }
}
