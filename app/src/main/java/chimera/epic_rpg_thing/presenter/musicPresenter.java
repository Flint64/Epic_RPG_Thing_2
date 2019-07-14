package chimera.epic_rpg_thing.presenter;

import android.content.Context;
import android.media.MediaPlayer;

import static chimera.epic_rpg_thing.R.raw.warcraft;
import static chimera.epic_rpg_thing.R.raw.combat_music;

public class musicPresenter {

    MediaPlayer warcraftMusic = new MediaPlayer();
    MediaPlayer combatMusic = new MediaPlayer();

    public void backgroundPlayer(Context c){
        warcraftMusic = MediaPlayer.create(c, warcraft);
        warcraftMusic.start();
    }

    public void combatPlayer(Context c){
        warcraftMusic = MediaPlayer.create(c, combat_music);
        warcraftMusic.start();
    }

    public void stopBackgroundMusic(){
        warcraftMusic.stop();
    }

    public void stopCombatMusic(){
        combatMusic.stop();
    }
}
