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

import chimera.epic_rpg_thing.model.Classes.WarriorClass;

public class FirebaseThings {
    FirebaseDatabase database;
    DatabaseReference myRef;

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
                List<Character> characters = new ArrayList<Character>();
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

    public void readMonster(){
        setMyRef("monster");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Monster> monsters = new ArrayList<Monster>();
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
    /**
     * A simple one-liner to write a character to the Firebase database
     *
     */
    //public void writeCharacter(Character character){
    public void writeCharacter(){
        WarriorClass warrior = new WarriorClass();
        Character character = new Character(100, 100, (short)22, null, (short)20, (short)15, (short)23, 3.35, "Jim", warrior);

       myRef.child(character.getName()).setValue(character);
    }

    public void writeMonster(){
        setMyRef("monster");
        Monster monster = new Monster(50,15.25, 15, null,35,10,20,28,2,1,"Goblin", null);
        myRef.child(monster.getName()).setValue(monster);
    }
}
