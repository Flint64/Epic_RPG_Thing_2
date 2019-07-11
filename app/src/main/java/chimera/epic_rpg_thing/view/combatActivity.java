package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.presenter.CombatPresenter;

public class combatActivity extends AppCompatActivity {

    boolean attackBtn = false;
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
        final LinearLayout btnLayout = findViewById(R.id.btnLayout);

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

                btnLayout.addView(potionButton);

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
                Toast.makeText(getApplicationContext(), "I don't do anything yet!", Toast.LENGTH_SHORT).show();
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
                }

                if (attackBtn){

                }

                if (magicBtn){

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
