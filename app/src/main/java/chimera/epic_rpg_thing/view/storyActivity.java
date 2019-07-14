package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Classes.CharacterClass;

public class storyActivity extends AppCompatActivity {

    //THIS IS NOT THE STORY ACTIVITY - This is the main story thing that has to have all of the fragments, inventory, skills, combat, & the listener. Which means this may
    //need to be a presenter instead.

    //TODO: This is going to have to have fragments of inventory, skills, combat, story & a combat listener to check if in combat to make
    //      changes to inventory and skills to allow/disallow doing things if you are/aren't in combat

    private short pressed = 0;
    private String choice;
    private String name;
    private int finalIntelligence;
    private int finalDexterity;
    private int finalStrength;
    private int finalHealth;
    private double finalDamage;
    private double finalMana;
    private double finalEvasion;
    private CharacterClass characterClass;
    private ArrayList<BaseSkill> currentSkills = new ArrayList<>();
    private int choice1;
    private int choice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_story);

        final Button continueButton = findViewById(R.id.continueButton);
        final TextView storyText = findViewById(R.id.storyText);
        name = getIntent().getStringExtra("name");
        choice = getIntent().getStringExtra("class");
        choice1 = getIntent().getIntExtra("choice1", 1);
        choice2 = getIntent().getIntExtra("choice2", 1);
        finalIntelligence = getIntent().getIntExtra("intelligence", 0);
        finalDexterity = getIntent().getIntExtra("dexterity", 0);
        finalStrength = getIntent().getIntExtra("strength",  0);
        finalHealth = getIntent().getIntExtra("health", 0);
        finalMana = getIntent().getDoubleExtra("mana", (double) 0);
        finalDamage = getIntent().getDoubleExtra("damage", (double) 0);
        finalEvasion = getIntent().getDoubleExtra("evasion", (double) 0);

        storyText.setOnClickListener(new View.OnClickListener() {
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
        i.putExtra("class", choice);
        i.putExtra("name", name);
        i.putExtra("choice1", choice1);
        i.putExtra("choice2", choice2);
        i.putExtra("intelligence", finalIntelligence);
        i.putExtra("dexterity", finalDexterity);
        i.putExtra("strength", finalStrength);
        i.putExtra("health", finalHealth);
        i.putExtra("mana", finalMana);
        i.putExtra("evasion", finalEvasion);
        i.putExtra("damage", finalDamage);

        startActivity(i);
        startActivity(i);
    }
}
