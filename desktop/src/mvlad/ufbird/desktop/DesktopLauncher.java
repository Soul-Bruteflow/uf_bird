package mvlad.ufbird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import mvlad.ufbird.uf_bird;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = uf_bird.WIDTH;
		config.height = uf_bird.HEIGHT;
		config.title = uf_bird.TITLE;
		new LwjglApplication(new uf_bird(), config);
	}
}
