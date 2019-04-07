package mvlad.ufbird.controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import mvlad.ufbird.model.PlayModel;

public abstract class Controller {
    protected OrthographicCamera cam;
    protected GameControllerManager csm;

    protected Controller(GameControllerManager _csm){
        this.csm = _csm;
        cam = new OrthographicCamera();
    }

    protected abstract void handleInput();
    public abstract void update(float deltaTime);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
