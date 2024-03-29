package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;

import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.presenter.musicPresenter;


public class MainActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    public static musicPresenter mp = new musicPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //Starts music
//        audioPlayer();

//        musicPresenter mp = new musicPresenter();
        Context c = getApplicationContext();
        mp.backgroundPlayer(c);


    }



    /***********************************************************************************
     *   NEW GAME - Simply goes to the new game screen that has the option to create a
     *   new character or load an old one before selecting a story to play
     ************************************************************************************/
    public void selectNewGame(View view){
        Intent intent = new Intent(this, newGameActivity.class);
        startActivity(intent);
    }

    /***********************************************************************************
     *   LOAD GAME - Currently does nothing, as we have no data to load. But should
     *   eventually bring up a list of games you can load with which character was tied
     *   to which game and allow you to load that game
     *
     *   Will need to figure out networking for all of this so that everyone is on the
     *   same page and all that. Probably have to have one person be the "host"/GM that
     *   picks the story to load once the players have queued up, and if a player in the
     *   queue doesn't have a save slot within the picked story, they should have to make
     *   a character or load one before the game resumes the story with the party.
     ************************************************************************************/
    public void selectContinue(View view){

        //TODO: Add functionality to be able to load a saved game

        mp.stopBackgroundMusic();

        //Simply displays "No saved games found", as this has no functionality as of yet
        Context context = getApplicationContext();
        CharSequence text = "No saved games found";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
