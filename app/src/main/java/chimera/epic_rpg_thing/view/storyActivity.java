package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import chimera.epic_rpg_thing.R;

public class storyActivity extends AppCompatActivity {

    //THIS IS NOT THE STORY ACTIVITY - This is the main story thing that has to have all of the fragments, inventory, skills, combat, & the listener. Which means this may
    //need to be a presenter instead.

    //TODO: This is going to have to have fragments of inventory, skills, combat, story & a combat listener to check if in combat to make
    //      changes to inventory and skills to allow/disallow doing things if you are/aren't in combat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
    }
}
