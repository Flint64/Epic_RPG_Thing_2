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
    List<Character> characters = new ArrayList<>();
    List<Monster> monsters = new ArrayList<>();
    public FirebaseThings() {
        //Setting up the database references so that we can read/write to Firebase
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("characters");
    }

    public void setMyRef(String pathName) {
        myRef = database.getReference(pathName);
    }

    private static final String TAG = "MainActivity";



    /**
     * This wil read every character that is on the Firebase database and return them in
     * a list of characters.
     */
    public void readCharacter() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    Character c = ds.getValue(Character.class);
                    characters.add(c);
                }

                for(Character character : characters){
                    System.out.println(character.toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.",databaseError.toException());
            }
        });
    }

    /**
     * A simple one-liner to write a character to the Firebase database
     */

    public void writeCharacter(Character character){
        setMyRef("characters");
        myRef.child(character.getName()).setValue(character);
    }

    Character characterNew;

    public Character readOneCharacter(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Character character = dataSnapshot.child("Ron").getValue(Character.class);
            characterNew = character;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read character.",databaseError.toException());
            }
        });
        return characterNew;
    }

    public List<Character> getCharacters(){
        return characters;
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
