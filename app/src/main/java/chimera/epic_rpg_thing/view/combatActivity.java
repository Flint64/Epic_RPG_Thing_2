package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.presenter.CombatPresenter;

public class combatActivity extends AppCompatActivity {

    boolean itemBtn = false;
    boolean magicBtn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        CombatPresenter cp = new CombatPresenter();

        final Button attackButton = findViewById(R.id.attack);
        final Button itemButton = findViewById(R.id.item);
        final Button magicButton = findViewById(R.id.magic);
        final Button voteButton = findViewById(R.id.voteButton);
        final Button fleeButton = findViewById(R.id.fleeButton);
        final Button potionButton = findViewById(R.id.potionButton);
        final Button reviveButton = findViewById(R.id.reviveButton);
        final Button backButton = findViewById(R.id.backButton);
        final TextView playerInfo = findViewById(R.id.playerInfo);
        final LinearLayout itemLayout = findViewById(R.id.itemLayout);
        final LinearLayout playerRadio = findViewById(R.id.playerLayout);
        final CheckBox player_2 = findViewById(R.id.selectPlayer_2);
        final CheckBox player_3 = findViewById(R.id.selectPlayer_3);
        final CheckBox player_4 = findViewById(R.id.selectPlayer_4);

        //TODO: The basic attack to simply smack your enemy into next week
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
//                itemLayout.setX(120); //TODO: These need to be the same coords, but the itemLayout should be swapped with your listView
//                itemLayout.setY(600);
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