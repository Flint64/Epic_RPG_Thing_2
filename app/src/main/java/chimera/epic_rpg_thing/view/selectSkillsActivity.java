package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.presenter.CharacterPresenter;

public class selectSkillsActivity extends AppCompatActivity{

    int skillCount = 0;
    CharacterPresenter presenter = new CharacterPresenter();

    private String choice;
    private String name;
    private short finalIntelligence;
    private short finalDexterity;
    private short finalStrength;
    private short finalHealth;
    private double finalDamage;
    private double finalMana;
    private double finalEvasion;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_skills);

//        choice = getIntent().getStringExtra("class");
        setChoice(getIntent().getStringExtra("class"));

        choice = getChoice();

//        name = getIntent().getStringExtra("name");
//        finalIntelligence = Short.parseShort(getIntent().getStringExtra("intelligence"));
//        finalDexterity = Short.parseShort(getIntent().getStringExtra("dexterity"));
//        finalStrength = Short.parseShort(getIntent().getStringExtra("strength"));
//        finalHealth = Double.parseDouble(getIntent().getStringExtra("health"));
//        finalMana = Float.parseFloat(getIntent().getStringExtra("mana"));
//        finalDamage = Float.parseFloat(getIntent().getStringExtra("damage"));
//        finalEvasion = Double.parseDouble(getIntent().getStringExtra("evasion"));




        final CheckBox skill_1 = findViewById(R.id.selectSkill_1);
        final CheckBox skill_2 = findViewById(R.id.selectSkill_2);
        final CheckBox skill_3 = findViewById(R.id.selectSkill_3);
        final CheckBox skill_4 = findViewById(R.id.selectSkill_4);

        //TODO: Need some way to figure out which skill is which when saving this to the class

        //Set changed listener on the checkBox
        skill_1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //If you are already at max skills and you try to check a new box, don't set it.
                if (skillCount == 2 && skill_1.isChecked()){
                    skill_1.setChecked(false);
                    return;
                    //Otherwise, if you are at max skills and you un-check a box, decrease the max count
                } else if (skillCount == 2 && !skill_1.isChecked()){
                    skillCount--;
                    return;
                }

                //If you check a box and you won't go over 2 by adding it, check it and increase count
                if (skill_1.isChecked() && skillCount + 1 <= 2){
                    skillCount++;
                    Log.d("debug", Integer.toString(skillCount));
                 //Otherwise, if you uncheck a box decrease count
                } else if (!skill_1.isChecked() && skillCount - 1 >= 0){
                    skillCount--;
                    Log.d("debug", Integer.toString(skillCount));
                }
            }
        });

        skill_2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (skillCount == 2 && skill_2.isChecked()){
                    skill_2.setChecked(false);
                    return;
                } else if (skillCount == 2 && !skill_2.isChecked()){
                    skillCount--;
                    return;
                }
                if (skill_2.isChecked() && skillCount + 1 <= 2){
                    skillCount++;
                    Log.d("debug", Integer.toString(skillCount));
                } else if (!skill_2.isChecked() && skillCount - 1 >= 0){
                    skillCount--;
                    Log.d("debug", Integer.toString(skillCount));
                }
            }
        });

        skill_3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (skillCount == 2 && skill_3.isChecked()){
                    skill_3.setChecked(false);
                    return;
                } else if (skillCount == 2 && !skill_3.isChecked()){
                    skillCount--;
                    return;
                }
                if (skill_3.isChecked() && skillCount + 1 <= 2){
                    skillCount++;
                    Log.d("debug", Integer.toString(skillCount));
                } else if (!skill_3.isChecked() && skillCount - 1 >= 0){
                    skillCount--;
                    Log.d("debug", Integer.toString(skillCount));
                }
            }
        });

        skill_4.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (skillCount == 2 && skill_4.isChecked()){
                    skill_4.setChecked(false);
                    return;
                } else if (skillCount == 2 && !skill_4.isChecked()){
                    skillCount--;
                    return;
                }
                if (skill_4.isChecked() && skillCount + 1 <= 2){
                    skillCount++;
                    Log.d("debug", Integer.toString(skillCount));
                } else if (!skill_4.isChecked() && skillCount - 1 >= 0){
                    skillCount--;
                    Log.d("debug", Integer.toString(skillCount));
                }
            }
        });

        final TextView skill_1_label = findViewById(R.id.skill_1_label);
        final TextView skill_2_label = findViewById(R.id.skill_2_label);
        final TextView skill_3_label = findViewById(R.id.skill_3_label);
        final TextView skill_4_label = findViewById(R.id.skill_4_label);

        switch (choice){
            case "cleric":
                skill_1_label.setText("Heal - Heals single party member");
                skill_2_label.setText("Divine Light - Single target holy damage");
                skill_3_label.setText("Power Bash - Chance to stun enemy");
                skill_4_label.setText("Imbue Weapon - Add holy damage to target's weapon");
                break;

            case "mage":
                 skill_1_label.setText("Firebolt - Single target fire attack");
                 skill_2_label.setText("Icicle - Single target ice attack");
                 skill_3_label.setText("Meditate - Increase damage of next magic attack and regen some mana");
                 skill_4_label.setText("Magic Barrier - Increased magic defense on target");
                break;

            case "warrior":
                skill_1_label.setText("Valiant Defense - Increased physical defense on target");
                skill_2_label.setText("Shield Bash - Chance to stun enemy, can bash with anything");
                skill_3_label.setText("Power Attack - Lower hit chance, increased damage");
                skill_4_label.setText("Taunt - More likely to be targeted by enemies");
                break;

            case "rogue":
                skill_1_label.setText("Sneak Attack - High crit chance attack");
                skill_2_label.setText("Hide - Dodge a single physical attack next turn");
                skill_3_label.setText("Poison Blade - Next attack deals normal damage and poisons");
                skill_4_label.setText("Set Trap - Place trap in front of character, damages when attacked");
                break;
        }
    }

    // Saves the new character into the new character object to be created and into shared prefs
    // (until we do database at least) and then redirects you to the selectCharacter activity with
    // the list of all of your saved characters where you can select one
    public void createCharacter(View view){

        /*
             i.putExtra("class", choice);
             i.putExtra("name", name);
             i.putExtra("intelligence", finalIntelligence);
             i.putExtra("dexterity", finalDexterity);
             i.putExtra("strength", finalStrength);
             i.putExtra("health", finalHealth);
             i.putExtra("mana", finalMana);
             i.putExtra("evasion", finalEvasion);
             i.putExtra("damage", finalDamage);
         */

        presenter.createCharacter(choice, name, finalIntelligence, finalDexterity, finalStrength, finalHealth, finalMana, finalEvasion, finalDamage);
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}