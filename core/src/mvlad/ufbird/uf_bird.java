package mvlad.ufbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.xml.soap.Text;

import mvlad.ufbird.controller.GameControllerManager;
import mvlad.ufbird.controller.MainMenuController;
import mvlad.ufbird.view.MainMusic;

public class uf_bird extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "uf_bird";
	private GameControllerManager csm;
	private SpriteBatch spriteBatch;
	private MainMusic musicTheme;

	private Texture tmp;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		csm = new GameControllerManager();
		musicTheme = new MainMusic();
		Gdx.gl.glClearColor(0, 0.2f, 0, 1);
		csm.push(new MainMenuController(csm));
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		csm.update(Gdx.graphics.getDeltaTime());
		csm.render(spriteBatch);
	}

	@Override
	public void dispose() {
		super.dispose();
		//music.dispose();
	}
}
