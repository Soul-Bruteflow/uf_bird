package mvlad.ufbird.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MainMusic {
    private Music music;

    public MainMusic(){
        music = Gdx.audio.newMusic(Gdx.files.internal("audio/mainTheme.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
    }

    public void dispose(){
        music.dispose();
    }
}
