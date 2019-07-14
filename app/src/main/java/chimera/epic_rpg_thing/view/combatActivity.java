package chimera.epic_rpg_thing.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Classes.CharacterClass;
import chimera.epic_rpg_thing.model.Classes.ClericClass;
import chimera.epic_rpg_thing.model.Classes.MageClass;
import chimera.epic_rpg_thing.model.Classes.RogueClass;
import chimera.epic_rpg_thing.model.Classes.WarriorClass;
import chimera.epic_rpg_thing.model.Monster;
import chimera.epic_rpg_thing.model.PlayerCharacter;
import chimera.epic_rpg_thing.presenter.CombatPresenter;
import chimera.epic_rpg_thing.presenter.musicPresenter;


public class combatActivity extends AppCompatActivity {

    boolean itemBtn = false;
    boolean magicBtn = false;
    private musicPresenter mp = MainActivity.mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_combat);

        mp.stopBackgroundMusic();

        Context context = getApplicationContext();
        mp.combatPlayer(context);

        Intent i = getIntent();
        String choice = i.getStringExtra("class");
        String name = i.getStringExtra("name");
        int choice1 = i.getIntExtra("choice1", 1);
        int choice2 = i.getIntExtra("choice2", 1);
        int finalIntelligence = i.getIntExtra("intelligence", 0);
        int finalDexterity = i.getIntExtra("dexterity", 0);
        int finalStrength = i.getIntExtra("strength", 0);
        int finalHealth = i.getIntExtra("health", 0);
        double finalDamage = i.getIntExtra("damage", 0);
        double finalMana = i.getDoubleExtra("mana", 0);
        double finalEvasion = i.getDoubleExtra("evasion", 0);
        CharacterClass characterClass = new WarriorClass();
        ArrayList<BaseSkill> currentSkills = new ArrayList<>();
        if (choice.equals("Cleric")) {
            characterClass = new ClericClass();
            switch (choice1) {
                case 1:
                    currentSkills.add(characterClass.getClassSkill("DivineBandAid"));
                    break;
                case 2:
                    currentSkills.add(characterClass.getClassSkill("DivineLight"));
                    break;
                case 3:
                    currentSkills.add(characterClass.getClassSkill("DivineHandShake"));
                    break;
                case 4:
                    currentSkills.add(characterClass.getClassSkill("DivineWeapon"));
                    break;
            }
            switch (choice2) {
                case 1:
                    currentSkills.add(characterClass.getClassSkill("DivineBandAid"));
                    break;
                case 2:
                    currentSkills.add(characterClass.getClassSkill("DivineLight"));
                    break;
                case 3:
                    currentSkills.add(characterClass.getClassSkill("DivineHandShake"));
                    break;
                case 4:
                    currentSkills.add(characterClass.getClassSkill("DivineWeapon"));
                    break;
            }
        } else if (choice.equals("Mage")) {
            characterClass = new MageClass();
            switch (choice1) {
                case 1:
                    currentSkills.add(characterClass.getClassSkill("Bolt"));
                    break;
                case 2:
                    currentSkills.add(characterClass.getClassSkill("Orb"));
                    break;
                case 3:
                    currentSkills.add(characterClass.getClassSkill("Meditate"));
                    break;
                case 4:
                    currentSkills.add(characterClass.getClassSkill("MagicBarrier"));
                    break;
            }
            switch (choice2) {
                case 1:
                    currentSkills.add(characterClass.getClassSkill("Bolt"));
                    break;
                case 2:
                    currentSkills.add(characterClass.getClassSkill("Orb"));
                    break;
                case 3:
                    currentSkills.add(characterClass.getClassSkill("Meditate"));
                    break;
                case 4:
                    currentSkills.add(characterClass.getClassSkill("MagicBarrier"));
                    break;
            }
        } else if(choice.equals("Warrior")) {
            characterClass = new WarriorClass();
            switch (choice1) {
                case 1:
                    currentSkills.add(characterClass.getClassSkill("BerserkerScream"));
                    break;
                case 2:
                    currentSkills.add(characterClass.getClassSkill("PrecisionStabby"));
                    break;
                case 3:
                    currentSkills.add(characterClass.getClassSkill("ShieldBreaker"));
                    break;
                case 4:
                    currentSkills.add(characterClass.getClassSkill("IntenseFocus"));
                    break;
            }
            switch (choice2) {
                case 1:
                    currentSkills.add(characterClass.getClassSkill("BerserkerScream"));
                    break;
                case 2:
                    currentSkills.add(characterClass.getClassSkill("PrecisionStabby"));
                    break;
                case 3:
                    currentSkills.add(characterClass.getClassSkill("ShieldBreaker"));
                    break;
                case 4:
                    currentSkills.add(characterClass.getClassSkill("IntenseFocus"));
                    break;
            }
        } else if(choice.equals("Rogue")) {
            characterClass = new RogueClass();
            switch (choice1) {
                case 1:
                    currentSkills.add(characterClass.getClassSkill("StabbyStab"));
                    break;
                case 2:
                    currentSkills.add(characterClass.getClassSkill("DarkSlash"));
                    break;
                case 3:
                    currentSkills.add(characterClass.getClassSkill("RoguishStealth"));
                    break;
                case 4:
                    currentSkills.add(characterClass.getClassSkill("PoisonVial"));
                    break;
            }
            switch (choice2) {
                case 1:
                    currentSkills.add(characterClass.getClassSkill("StabbyStab"));
                    break;
                case 2:
                    currentSkills.add(characterClass.getClassSkill("DarkSlash"));
                    break;
                case 3:
                    currentSkills.add(characterClass.getClassSkill("RoguishStealth"));
                    break;
                case 4:
                    currentSkills.add(characterClass.getClassSkill("PoisonVial"));
                    break;
            }
        }
        Log.d("Health", "Start Health: " + finalHealth);
        PlayerCharacter c = new PlayerCharacter(100, finalMana, (double)3, currentSkills, finalStrength, finalIntelligence, finalDexterity, finalEvasion, name, characterClass);
        final CombatPresenter cp = new CombatPresenter(c);
        final Button attackButton = findViewById(R.id.attack);
        final Button itemButton = findViewById(R.id.item);
        final Button magicButton = findViewById(R.id.magic);
        final Button voteButton = findViewById(R.id.voteButton);
        final Button fleeButton = findViewById(R.id.fleeButton);
        final Button potionButton = findViewById(R.id.potionButton);
        final Button reviveButton = findViewById(R.id.reviveButton);
        final Button backButton = findViewById(R.id.backButton);
        final ImageButton monster1 = findViewById(R.id.monster_1);
        final ImageButton monster2 = findViewById(R.id.monster_2);
        final ImageButton monster3 = findViewById(R.id.monster_3);
        final ImageButton monster4 = findViewById(R.id.monster_4);
        final TextView playerInfo = findViewById(R.id.playerInfo);
        final LinearLayout itemLayout = findViewById(R.id.itemLayout);
        final LinearLayout playerRadio = findViewById(R.id.playerLayout);
        final CheckBox player_2 = findViewById(R.id.selectPlayer_2);
        final CheckBox player_3 = findViewById(R.id.selectPlayer_3);
        final CheckBox player_4 = findViewById(R.id.selectPlayer_4);
        final ListView list = findViewById(R.id.SkillsList);
        final CheckBox enemy_1 = findViewById(R.id.selectEnemy_1);
        final CheckBox enemy_2 = findViewById(R.id.selectEnemy_2);
        final CheckBox enemy_3 = findViewById(R.id.selectEnemy_3);
        final CheckBox enemy_4 = findViewById(R.id.selectEnemy_4);
        cp.addMonsters();
        ArrayAdapter<BaseSkill> arrayAdapter = new ArrayAdapter<BaseSkill>(this, android.R.layout.simple_list_item_1, cp.getCharacterSkills()){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                textView.setTextColor(Color.WHITE);

                return view;
            }
        };
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BaseSkill selected = (BaseSkill) list.getItemAtPosition(position);
                cp.setSelectedSkill(selected);
                list.setVisibility(View.INVISIBLE);
                itemLayout.setVisibility(View.INVISIBLE);
                backButton.setVisibility(View.INVISIBLE);
                playerInfo.setVisibility(View.VISIBLE);
                attackButton.setVisibility(View.VISIBLE);
                magicButton.setVisibility(View.VISIBLE);
                itemButton.setVisibility(View.VISIBLE);
            }
        });
        //TODO: Add bool checks to each of the item/magic/attack buttons to see if the new view is visible so that the back button can "close" them out by hiding stuff right
        //TODO: Also figure out how to set a layout dynamically to prevent me having to stack all of these menus on top of each other

        //TODO: The basic attack to simply smack your enemy into next week
        attackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(cp.getSelectedSkill() == null){
                    Toast.makeText(getApplicationContext(), "You must select a skill before you can attack", Toast.LENGTH_SHORT).show();
                } else {
                    cp.useSelectedSkill();
                    //Makes the phone vibrate when the continue button is pressed
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    // Vibrate for 500 milliseconds
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        v.vibrate(500);
                    }
                    cp.endTurn();
                    int index = 1;
                    for(Monster m : cp.getMonsters()){
                        if(m.isAlive()){
                            Log.d("MonsterHealth", "Monster" + index + " HP:" + m.getCurrentHP());
                            Log.d("Health", "Character Health: " + cp.getPlayerCharacter().getCurrentHP());
                        } else {
                            switch(index){
                                case 1:
                                    monster1.setVisibility(View.INVISIBLE);
                                    break;
                                case 2:
                                    monster2.setVisibility(View.INVISIBLE);
                                    break;
                                case 3:
                                    monster3.setVisibility(View.INVISIBLE);
                                    break;
                                case 4:
                                    monster4.setVisibility(View.INVISIBLE);
                                    break;
                                default:
                                    break;
                            }
                        }
                        index++;
                    }
                    if(cp.isGameDone()){
                        Toast.makeText(getApplicationContext(), "The game is done.", Toast.LENGTH_LONG).show();
                    }
                }
        }});

        itemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                itemBtn = true;

                potionButton.setVisibility(View.VISIBLE);
                reviveButton.setVisibility(View.VISIBLE);
                itemLayout.setVisibility(View.VISIBLE);
                playerRadio.setVisibility(View.VISIBLE);

                backButton.setVisibility(View.VISIBLE);
                playerInfo.setVisibility(View.INVISIBLE);
                attackButton.setVisibility(View.INVISIBLE);
                magicButton.setVisibility(View.INVISIBLE);
                itemButton.setVisibility(View.INVISIBLE);
                itemLayout.setX(120);
                itemLayout.setY(600);
            }});

        magicButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                magicBtn = true;
                backButton.setVisibility(View.VISIBLE);
                playerInfo.setVisibility(View.INVISIBLE);
                attackButton.setVisibility(View.INVISIBLE);
                magicButton.setVisibility(View.INVISIBLE);
                itemButton.setVisibility(View.INVISIBLE);
                list.setVisibility(View.VISIBLE);
                list.setX(100); //TODO: These need to be the same coords, but the itemLayout should be swapped with your listView
                list.setY(550);
            }});

        //TODO: Both the vote & flee buttons should require confirmation from all the other players when pressed, to either vote to quit or flee a battle
        voteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "I don't do anything yet!", Toast.LENGTH_SHORT).show();
            }});

        fleeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "I don't do anything yet!", Toast.LENGTH_SHORT).show();
            }});


        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (itemBtn){
                    player_2.setSelected(false);
                    player_3.setSelected(false);
                    player_4.setSelected(false);
                    potionButton.setVisibility(View.INVISIBLE);
                    reviveButton.setVisibility(View.INVISIBLE);
                    playerRadio.setVisibility(View.INVISIBLE);
                    itemBtn = false;
                }

                if (magicBtn){
                    list.setVisibility(View.INVISIBLE); //TODO: Again, set these to the listVIew so that it goes invis again
                    magicBtn = false;
                }

                itemLayout.setVisibility(View.INVISIBLE);
                backButton.setVisibility(View.INVISIBLE);
                playerInfo.setVisibility(View.VISIBLE);
                attackButton.setVisibility(View.VISIBLE);
                magicButton.setVisibility(View.VISIBLE);
                itemButton.setVisibility(View.VISIBLE);
            }});

        enemy_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(cp.getSelectedSkill() != null){
                    cp.addSelectedTargetToSkill(0, false);
                } else {
                    Toast.makeText(getApplicationContext(), "You must select a skill before you can attack", Toast.LENGTH_SHORT).show();
                }
            }
        });

        enemy_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cp.getSelectedSkill() != null){
                    cp.addSelectedTargetToSkill(1, false);
                } else {
                    Toast.makeText(getApplicationContext(), "You must select a skill before you can attack", Toast.LENGTH_SHORT).show();
                }
            }
        });

        enemy_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cp.getSelectedSkill() != null){
                    cp.addSelectedTargetToSkill(2, false);
                } else {
                    Toast.makeText(getApplicationContext(), "You must select a skill before you can attack", Toast.LENGTH_SHORT).show();
                }
            }
        });

        enemy_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cp.getSelectedSkill() != null){
                    cp.addSelectedTargetToSkill(3,false);
                } else {
                    Toast.makeText(getApplicationContext(), "You must select a skill before you can attack", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}