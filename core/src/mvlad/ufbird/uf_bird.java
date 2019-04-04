package mvlad.ufbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import mvlad.ufbird.states.GameStateManager;
import mvlad.ufbird.states.MenuState;

public class uf_bird extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "uf_bird";
	private GameStateManager gsm;
	private SpriteBatch spriteBatch;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(0, 0.2f, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(spriteBatch);
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
	}
}
