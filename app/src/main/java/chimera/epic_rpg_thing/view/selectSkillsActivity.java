package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.PlayerCharacter;
import chimera.epic_rpg_thing.model.Classes.CharacterClass;
import chimera.epic_rpg_thing.model.Classes.ClericClass;
import chimera.epic_rpg_thing.model.Classes.MageClass;
import chimera.epic_rpg_thing.model.Classes.RogueClass;
import chimera.epic_rpg_thing.model.Classes.WarriorClass;
import chimera.epic_rpg_thing.presenter.CharacterPresenter;

public class selectSkillsActivity extends AppCompatActivity{

    int skillCount = 0;
    int elementCount = 0;
    int fireCount = 1;
    int earthCount = 1;
    int iceCount = 1;
    int lightningCount = 1;
    CharacterPresenter presenter = new CharacterPresenter();

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
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select_skills);

        //    choice = getIntent().getStringExtra("class");
        setChoice(getIntent().getStringExtra("class"));

        choice = getChoice();
        Log.d("debug", getChoice());

        name = getIntent().getStringExtra("name");
        finalIntelligence = getIntent().getIntExtra("intelligence", (int) 0);
        finalDexterity = getIntent().getIntExtra("dexterity", (int) 0);
        finalStrength = getIntent().getIntExtra("strength", (int) 0);
        finalHealth = getIntent().getIntExtra("health", (int) 0);
        finalMana = getIntent().getDoubleExtra("mana", (double) 0);
        finalDamage = getIntent().getDoubleExtra("damage", (double) 0);
        finalEvasion = getIntent().getDoubleExtra("evasion", (double) 0);




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
                    switch(choice){
                        case "Cleric":
                            currentSkills.add(characterClass.getClassSkill("DivineBandAid"));
                            break;
                        case "Mage":
                            currentSkills.add(characterClass.getClassSkill("Bolt"));
                        case "Warrior":
                            currentSkills.add(characterClass.getClassSkill("BerserkerScream"));
                            break;
                        case "Rogue":
                            currentSkills.add(characterClass.getClassSkill("StabbyStab"));
                    }
                    Log.d("debug", Integer.toString(skillCount));
                    //Otherwise, if you uncheck a box decrease count
                } else if (!skill_1.isChecked() && skillCount - 1 >= 0){
                    skillCount--;
                    switch(choice){
                        case "Cleric":
                            currentSkills.remove(characterClass.getClassSkill("DivineBandAid"));
                            break;
                        case "Mage":
                            currentSkills.remove(characterClass.getClassSkill("Bolt"));
                        case "Warrior":
                            currentSkills.remove(characterClass.getClassSkill("BerserkerScream"));
                            break;
                        case "Rogue":
                            currentSkills.remove(characterClass.getClassSkill("StabbyStab"));
                    }
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
                    switch(choice){
                        case "Cleric":
                            currentSkills.add(characterClass.getClassSkill("DivineLight"));
                            break;
                        case "Mage":
                            currentSkills.add(characterClass.getClassSkill("Orb"));
                        case "Warrior":
                            currentSkills.add(characterClass.getClassSkill("PrecisionStabby"));
                            break;
                        case "Rogue":
                            currentSkills.add(characterClass.getClassSkill("DarkSlash"));
                    }
                    Log.d("debug", Integer.toString(skillCount));
                } else if (!skill_2.isChecked() && skillCount - 1 >= 0){
                    skillCount--;
                    switch(choice){
                        case "Cleric":
                            currentSkills.remove(characterClass.getClassSkill("DivineLight"));
                            break;
                        case "Mage":
                            currentSkills.remove(characterClass.getClassSkill("Orb"));
                        case "Warrior":
                            currentSkills.remove(characterClass.getClassSkill("PrecisionStabby"));
                            break;
                        case "Rogue":
                            currentSkills.remove(characterClass.getClassSkill("DarkSlash"));
                    }
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
                    switch(choice){
                        case "Cleric":
                            currentSkills.add(characterClass.getClassSkill("DivineHandShake"));
                            break;
                        case "Mage":
                            currentSkills.add(characterClass.getClassSkill("Meditate"));
                        case "Warrior":
                            currentSkills.add(characterClass.getClassSkill("ShieldBreaker"));
                            break;
                        case "Rogue":
                            currentSkills.add(characterClass.getClassSkill("RoguishStealth"));
                    }
                    Log.d("debug", Integer.toString(skillCount));
                } else if (!skill_3.isChecked() && skillCount - 1 >= 0){
                    skillCount--;
                    switch(choice){
                        case "Cleric":
                            currentSkills.remove(characterClass.getClassSkill("DivineHandShake"));
                            break;
                        case "Mage":
                            currentSkills.remove(characterClass.getClassSkill("Meditate"));
                        case "Warrior":
                            currentSkills.remove(characterClass.getClassSkill("ShieldBreaker"));
                            break;
                        case "Rogue":
                            currentSkills.remove(characterClass.getClassSkill("RoguishStealth"));
                    }
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
                    switch(choice){
                        case "Cleric":
                            currentSkills.add(characterClass.getClassSkill("DivineWeapon"));
                            break;
                        case "Mage":
                            currentSkills.add(characterClass.getClassSkill("MagicBarrier"));
                        case "Warrior":
                            currentSkills.add(characterClass.getClassSkill("ShieldBreaker"));
                            break;
                        case "Rogue":
                            currentSkills.add(characterClass.getClassSkill("RoguishStealth"));
                    }
                    Log.d("debug", Integer.toString(skillCount));
                } else if (!skill_4.isChecked() && skillCount - 1 >= 0){
                    skillCount--;
                    switch(choice){
                        case "Cleric":
                            currentSkills.remove(characterClass.getClassSkill("DivineWeapon"));
                            break;
                        case "Mage":
                            currentSkills.remove(characterClass.getClassSkill("MagicBarrier"));
                        case "Warrior":
                            currentSkills.remove(characterClass.getClassSkill("ShieldBreaker"));
                            break;
                        case "Rogue":
                            currentSkills.remove(characterClass.getClassSkill("RoguishStealth"));
                    }
                    Log.d("debug", Integer.toString(skillCount));
                }
            }
        });

        final TextView skill_1_label = findViewById(R.id.skill_1_label);
        final TextView skill_2_label = findViewById(R.id.skill_2_label);
        final TextView skill_3_label = findViewById(R.id.skill_3_label);
        final TextView skill_4_label = findViewById(R.id.skill_4_label);

        switch (choice){
            case "Cleric":
                characterClass = new ClericClass();
                skill_1_label.setText(characterClass.getClassSkill("DivineBandAid").getDescription());
                skill_2_label.setText(characterClass.getClassSkill("DivineLight").getDescription());
                skill_3_label.setText(characterClass.getClassSkill("DivineHandShake").getDescription());
                skill_4_label.setText(characterClass.getClassSkill("DivineWeapon").getDescription());
                break;

            case "Mage":
                characterClass = new MageClass();
                skill_1_label.setText(characterClass.getClassSkill("Bolt").getDescription());
                skill_2_label.setText(characterClass.getClassSkill("Orb").getDescription());
                skill_3_label.setText(characterClass.getClassSkill("Meditate").getDescription());
                skill_4_label.setText(characterClass.getClassSkill("MagicBarrier").getDescription());
                break;

            case "Warrior":
                characterClass = new WarriorClass();
                skill_1_label.setText(characterClass.getClassSkill("BerserkerScream").getDescription());
                skill_2_label.setText(characterClass.getClassSkill("PrecisionStabby").getDescription());
                skill_3_label.setText(characterClass.getClassSkill("ShieldBreaker").getDescription());
                skill_4_label.setText(characterClass.getClassSkill("IntenseFocus").getDescription());
                break;

            case "Rogue":
                characterClass = new RogueClass();
                skill_1_label.setText(characterClass.getClassSkill("StabbyStab").getDescription());
                skill_2_label.setText(characterClass.getClassSkill("DarkSlash").getDescription());
                skill_3_label.setText(characterClass.getClassSkill("RoguishStealth").getDescription());
                skill_4_label.setText(characterClass.getClassSkill("PoisonVial").getDescription());
                break;
        }

        final ImageButton fireButton = findViewById(R.id.elementFire);
        final ImageButton earthButton = findViewById(R.id.elementEarth);
        final ImageButton iceButton = findViewById(R.id.elementIce);
        final ImageButton lightningButton = findViewById(R.id.elementLightning);
        final TextView fireLabel = findViewById(R.id.fireLabel);
        final TextView iceLabel = findViewById(R.id.iceLabel);
        final TextView earthLabel = findViewById(R.id.earthLabel);
        final TextView lightningLabel = findViewById(R.id.lightningLabel);
        final CheckBox fireCheck = findViewById(R.id.fireCheck);
        final CheckBox earthCheck = findViewById(R.id.earthCheck);
        final CheckBox iceCheck = findViewById(R.id.iceCheck);
        final CheckBox lightningCheck = findViewById(R.id.lightningCheck);

        if (getChoice().equals("Mage")){
            fireButton.setVisibility(View.VISIBLE);
            earthButton.setVisibility(View.VISIBLE);
            iceButton.setVisibility(View.VISIBLE);
            lightningButton.setVisibility(View.VISIBLE);
            fireLabel.setVisibility(View.VISIBLE);
            iceLabel.setVisibility(View.VISIBLE);
            lightningLabel.setVisibility(View.VISIBLE);
            earthLabel.setVisibility(View.VISIBLE);
        }

        fireButton.setBackground(getDrawable(R.drawable.black_border));
        earthButton.setBackground(getDrawable(R.drawable.black_border));
        lightningButton.setBackground(getDrawable(R.drawable.black_border));
        iceButton.setBackground(getDrawable(R.drawable.black_border));

        fireCheck.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (elementCount == 2 && fireCheck.isChecked()){
                    fireCheck.setChecked(false);
                    fireButton.setBackground(getDrawable(R.drawable.black_border));
                    return;
                } else if (elementCount == 2 && !fireCheck.isChecked()){
                    elementCount--;
                    fireButton.setBackground(getDrawable(R.drawable.black_border));
                    return;
                }
                if (fireCheck.isChecked() && elementCount + 1 <= 2){
                    elementCount++;
                    fireButton.setBackground(getDrawable(R.drawable.red_border));
                    Log.d("debug", Integer.toString(elementCount));
                } else if (!fireCheck.isChecked() && elementCount - 1 >= 0){
                    elementCount--;
                    fireButton.setBackground(getDrawable(R.drawable.black_border));
                    Log.d("debug", Integer.toString(elementCount));
                }
            }
        });

        //TODO: Next up, save the elements in a string or the enum or something so they can be passed in, rework layout to work better

        iceCheck.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (elementCount == 2 && iceCheck.isChecked()){
                    iceCheck.setChecked(false);
                    iceButton.setBackground(getDrawable(R.drawable.black_border));
                    return;
                } else if (elementCount == 2 && !iceCheck.isChecked()){
                    elementCount--;
                    iceButton.setBackground(getDrawable(R.drawable.black_border));
                    return;
                }
                if (iceCheck.isChecked() && elementCount + 1 <= 2){
                    elementCount++;
                    iceButton.setBackground(getDrawable(R.drawable.red_border));
                    Log.d("debug", Integer.toString(elementCount));
                } else if (!iceCheck.isChecked() && elementCount - 1 >= 0){
                    elementCount--;
                    iceButton.setBackground(getDrawable(R.drawable.black_border));
                    Log.d("debug", Integer.toString(elementCount));
                }
            }
        });

        earthCheck.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (elementCount == 2 && earthCheck.isChecked()){
                    earthCheck.setChecked(false);
                    earthButton.setBackground(getDrawable(R.drawable.black_border));
                    return;
                } else if (elementCount == 2 && !earthCheck.isChecked()){
                    elementCount--;
                    earthButton.setBackground(getDrawable(R.drawable.black_border));
                    return;
                }
                if (earthCheck.isChecked() && elementCount + 1 <= 2){
                    elementCount++;
                    earthButton.setBackground(getDrawable(R.drawable.red_border));
                    Log.d("debug", Integer.toString(elementCount));
                } else if (!earthCheck.isChecked() && elementCount - 1 >= 0){
                    elementCount--;
                    earthButton.setBackground(getDrawable(R.drawable.black_border));
                    Log.d("debug", Integer.toString(elementCount));
                }
            }
        });

        lightningCheck.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (elementCount == 2 && lightningCheck.isChecked()){
                    lightningCheck.setChecked(false);
                    lightningButton.setBackground(getDrawable(R.drawable.black_border));
                    return;
                } else if (elementCount == 2 && !lightningCheck.isChecked()){
                    lightningButton.setBackground(getDrawable(R.drawable.black_border));
                    elementCount--;
                    return;
                }
                if (lightningCheck.isChecked() && elementCount + 1 <= 2){
                    elementCount++;
                    lightningButton.setBackground(getDrawable(R.drawable.red_border));
                    Log.d("debug", Integer.toString(elementCount));
                } else if (!lightningCheck.isChecked() && elementCount - 1 >= 0){
                    elementCount--;
                    lightningButton.setBackground(getDrawable(R.drawable.black_border));
                    Log.d("debug", Integer.toString(elementCount));
                }
            }
        });
    }

    // Saves the new character into the new character object to be created and into shared prefs
    // (until we do database at least) and then redirects you to the selectCharacter activity with
    // the list of all of your saved characters where you can select one
    public void createCharacter(View view){

        Intent i = new Intent(this, combatActivity.class); //TODO: This should take you to the character select list instead, but for testing, goes straight to story

//        final CheckBox fireCheck = findViewById(R.id.fireCheck);
//        final CheckBox earthCheck = findViewById(R.id.earthCheck);
//        final CheckBox iceCheck = findViewById(R.id.iceCheck);
//        final CheckBox lightningCheck = findViewById(R.id.lightningCheck);

//        ElementalType elementEarth = ElementalType.EARTH;
//        ElementalType elementFire = ElementalType.FIRE;
//        ElementalType elementIce = ElementalType.ICE;
//        ElementalType elementLightning = ElementalType.LIGHTNING;

//        ElementalType element_1 = null;
//        ElementalType element_2 = null;

        //TODO: Figure out how to pass in these elements without any null ones

//        if (fireCheck.isChecked()){ i.putExtra("element_fire", elementFire); }
//        if (earthCheck.isChecked()){ i.putExtra("element_earth", elementEarth); }
//        if (iceCheck.isChecked()){ i.putExtra("element_ice", elementIce); }
//        if (lightningCheck.isChecked()){ i.putExtra("element_lightning", elementLightning); }

//        i.putExtra("class", choice);
        i.putExtra("name", name);
//        i.putExtra("intelligence", finalIntelligence);
//        i.putExtra("dexterity", finalDexterity);
//        i.putExtra("strength", finalStrength);
//        i.putExtra("health", finalHealth);
//        i.putExtra("mana", finalMana);
//        i.putExtra("evasion", finalEvasion);
//        i.putExtra("damage", finalDamage);
        Gson gson = new Gson();
        PlayerCharacter c = presenter.createCharacter(choice, name, finalIntelligence, finalDexterity, finalStrength, finalHealth, finalMana, finalEvasion, finalDamage, currentSkills, characterClass);
        String json = gson.toJson(c, PlayerCharacter.class);
        i.putExtra("character", json);

        startActivity(i);
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}