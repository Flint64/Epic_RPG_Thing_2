package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import chimera.epic_rpg_thing.R;

public class storyActivity extends AppCompatActivity {

    //TODO: This is going to have to have fragments of inventory, skills, combat & a combat listener to check if in combat to make
    //      changes to inventory and skills to allow/disallow doing things if you are/aren't in combat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //TODO: onCreate here should probably read in from the database all of the story stuff

    }
}
