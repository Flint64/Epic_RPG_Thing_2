package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Classes.WarriorClass;
import chimera.epic_rpg_thing.presenter.CombatPresenter;
import chimera.epic_rpg_thing.model.Character;

public class combatActivity extends AppCompatActivity {

    boolean itemBtn = false;
    boolean magicBtn = false;

    WarriorClass wc = new WarriorClass();
    List<BaseSkill> currentSkills = new ArrayList<>();

    Character steve = new Character(1000, 100, 1000, currentSkills, 100,100,100, 100, "Steven", wc);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);
        steve.addCurrentSkill(wc.getClassSkill("BerserkerScream"));
        steve.addCurrentSkill(wc.getClassSkill("PrecisionStabby"));
        steve.addCurrentSkill(wc.getClassSkill("ShieldBreaker"));
        steve.addCurrentSkill(wc.getClassSkill("IntenseFocus"));
        final CombatPresenter cp = new CombatPresenter();
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
        final ListView list = findViewById(R.id.SkillsList);
        ArrayAdapter<BaseSkill> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, steve.getCurrentSkills());
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BaseSkill selected = (BaseSkill) list.getItemAtPosition(position);
                cp.setSelectedSkill(selected);
                list.setVisibility(View.INVISIBLE);
            }
        });
        //TODO: Add bool checks to each of the item/magic/attack buttons to see if the new view is visible so that the back button can "close" them out by hiding stuff right
        //TODO: Also figure out how to set a layout dynamically to prevent me having to stack all of these menus on top of each other


        attackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "I don't do anything yet!", Toast.LENGTH_SHORT).show();
        }});

        itemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                itemBtn = true;

                potionButton.setVisibility(View.VISIBLE);
                reviveButton.setVisibility(View.VISIBLE);
                itemLayout.setVisibility(View.VISIBLE);


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
//                itemLayout.setX(120); //TODO: These need to be the same coords, but the itemLayout should be swapped with your listView
//                itemLayout.setY(600);, "I don't do anything yet!", Toast.LENGTH_SHORT).show();
            }});

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
                    potionButton.setVisibility(View.INVISIBLE);
                    reviveButton.setVisibility(View.INVISIBLE);
                    itemBtn = false;
                }

                if (magicBtn){
//                    potionButton.setVisibility(View.INVISIBLE); //TODO: Again, set these to the listVIew so that it goes invis again
//                    reviveButton.setVisibility(View.INVISIBLE);
                    magicBtn = false;
                }

                itemLayout.setVisibility(View.INVISIBLE);
                backButton.setVisibility(View.INVISIBLE);
                playerInfo.setVisibility(View.VISIBLE);
                attackButton.setVisibility(View.VISIBLE);
                magicButton.setVisibility(View.VISIBLE);
                itemButton.setVisibility(View.VISIBLE);

            }});

    }
}
