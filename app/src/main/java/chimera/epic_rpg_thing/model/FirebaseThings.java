package chimera.epic_rpg_thing.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseThings {
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<PlayerCharacter> playerCharacters = new ArrayList<>();
    List<Monster> monsters = new ArrayList<>();
    public FirebaseThings() {
        //Setting up the database references so that we can read/write to Firebase
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("playerCharacters");
    }

    public void setMyRef(String pathName) {
        myRef = database.getReference(pathName);
    }

    private static final String TAG = "MainActivity";



    /**
     * This wil read every playerCharacter that is on the Firebase database and return them in
     * a list of playerCharacters.
     */
    public void readCharacter() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    PlayerCharacter c = ds.getValue(PlayerCharacter.class);
                    playerCharacters.add(c);
                }

                for(PlayerCharacter playerCharacter : playerCharacters){
                    System.out.println(playerCharacter.toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.",databaseError.toException());
            }
        });
    }

    /**
     * A simple one-liner to write a playerCharacter to the Firebase database
     */

    public void writeCharacter(PlayerCharacter playerCharacter){
        setMyRef("playerCharacters");
        myRef.child(playerCharacter.getName()).setValue(playerCharacter);
    }

    PlayerCharacter playerCharacterNew;

    public PlayerCharacter readOneCharacter(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            PlayerCharacter playerCharacter = dataSnapshot.getValue(PlayerCharacter.class);
            playerCharacterNew = playerCharacter;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read playerCharacter.",databaseError.toException());
            }
        });
        return playerCharacterNew;
    }

    public List<PlayerCharacter> getPlayerCharacters(){
        return playerCharacters;
    }

    public List<Monster> getMonsters(){
        return monsters;
    }

    /**
     * reads a list of monsters from the database
     */
    public void readMonster(){
        setMyRef("monster");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    Monster m = ds.getValue(Monster.class);
                    monsters.add(m);
                }

                for(Monster monster : monsters){
                    System.out.println(monster.toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.",databaseError.toException());
            }
        });
    }

    public void writeMonster(Monster monster){
        setMyRef("monster");
        myRef.child(monster.getName()).setValue(monster);
    }
}
