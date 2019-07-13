package chimera.epic_rpg_thing.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import chimera.epic_rpg_thing.R;
import chimera.epic_rpg_thing.model.PlayerCharacter;
import chimera.epic_rpg_thing.model.CharacterStorage;

public class selectCharacterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_character);
        ListView list = findViewById(R.id.list);
        ArrayAdapter<PlayerCharacter> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, loadCharacters());
    }

    public ArrayList<PlayerCharacter> loadCharacters(){
        ArrayList<PlayerCharacter> tmpPlayerCharacters = new ArrayList<>();
        Gson gson = new Gson();
        try {
            CharacterStorage names = getCharacterDirectory();
            for(String s : names.getNames()){
                BufferedReader reader = new BufferedReader(new FileReader(s));
                tmpPlayerCharacters.add(gson.fromJson(reader, PlayerCharacter.class));
                reader.close();
            }
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return tmpPlayerCharacters;
    }
    public CharacterStorage getCharacterDirectory(){
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader("CharacterDirectory.dat"));
            CharacterStorage names = gson.fromJson(br, CharacterStorage.class);
            br.close();
            return names;
        } catch(java.io.IOException io){
            io.printStackTrace();
        }
        return new CharacterStorage();
    }

}
