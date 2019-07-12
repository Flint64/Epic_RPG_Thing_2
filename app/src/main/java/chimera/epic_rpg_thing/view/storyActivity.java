package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import chimera.epic_rpg_thing.R;

public class storyActivity extends AppCompatActivity {

    //THIS IS NOT THE STORY ACTIVITY - This is the main story thing that has to have all of the fragments, inventory, skills, combat, & the listener. Which means this may
    //need to be a presenter instead.

    //TODO: This is going to have to have fragments of inventory, skills, combat, story & a combat listener to check if in combat to make
    //      changes to inventory and skills to allow/disallow doing things if you are/aren't in combat

    private short pressed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        final Button continueButton = findViewById(R.id.continueButton);
        final TextView storyText = findViewById(R.id.storyText);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View view) {
                pressed++;

                switch(pressed){
                    case 1:
                        storyText.setText("The king's armies and their elite, the holy Knights of the Sacred Eye, forever the Watchers and Warders of evil, fought valiantly to defend the kingdom and castle, but they too, fell victim to Ichor's claws, and some became unholy servants of the night as they fell in defense of their home. There was one, however, who managed to survive this onslaught: The Princess' own personal bodyguard, apprentice Watcher Glenn. He, along with the princess herself, managed to flee the castle and retreat to safety.");
                    break;

                    case 2:
                        storyText.setText("It is here, months after the destruction of the kingdom, that we pick up our story, here, where our four valiant heroes, wanderers to our once fair land, have pledged to help Princess Joyeuse and her noble companion Sir Glenn to rid the kingdom of the scourge of the Ichor, and return peace to the land.");
                    break;

                    case 3:
                        storyText.setText("You embark on your journey together, well aware of the dangers you will face on the way, ready to fight your way to peace - and riches untold.");
                    break;

                    case 4:
                        storyText.setText("As you begin your travels, you encounter a group of enemies! Prepare yourself!");
                        continueButton.setText("Fight!");
                        break;

                    case 5:
                        startCombat();
                    break;
                }

            }});
    }

    //Starts the combat activity
    private void startCombat() {
        Intent i = new Intent(this, combatActivity.class);
        startActivity(i);
    }
}
