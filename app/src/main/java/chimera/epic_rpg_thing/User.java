package chimera.epic_rpg_thing;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String password;
    List<Character> characters;
    public User(String name, String password){
        this.name = name;
        this.password = password;
        new Thread(new Runnable() {
            @Override
            public void run() {
                loadCharacters();
            }
        });
    }
    public List<Character> getCharacters(){
        return characters;
    }

    /**
     * Loads the characters in from the character files.
     * uses the CharacterDirectory file to find the different
     * files for the characters.
     */


    private void loadCharacters(){
        ArrayList<Character> tmpCharacters = new ArrayList<>();
        ArrayList<String> fileNames;
        Gson gson = new Gson();
        try {
            fileNames = getCharacterDirectory();
            for(String s : fileNames){
                BufferedReader reader = new BufferedReader(new FileReader(s));
                tmpCharacters.add(gson.fromJson(reader, Character.class));
                reader.close();
            }
        }catch (FileNotFoundException f){
            return;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Saves the character and saves a directory of file names
     * to CharacterDirectory which we will use to find the names
     * of the character files
     */
    public void saveCharacters(){
        Gson gson = new Gson();
        String json;
        updateCharacterDirectory();
        ArrayList<String> fileNames = getCharacterDirectory();
        try {
            json = gson.toJson(fileNames, ArrayList.class);
            FileWriter file = new FileWriter("CharacterDirectory");
            file.write(json);
            file.close();
        } catch (java.io.IOException io){
            io.printStackTrace();
        }
    }

    public void addCharacter(Character c){
        characters.add(c);
    }
    public void deleteCharacter(String name){
        File file = new File(name);
        file.delete();
        saveCharacters();
    }

    private ArrayList<String> getCharacterDirectory(){
        try {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader("CharacterDirectory"));
            ArrayList<String> fileNames = gson.fromJson(reader, ArrayList.class);
            reader.close();
            return fileNames;
        } catch (java.io.IOException io){
            return null;
        }
    }

    private void updateCharacterDirectory(){
        Gson gson = new Gson();
        String json;
        ArrayList<String> fileNames = new ArrayList<>(4);
        for(Character c : characters){
            json = gson.toJson(c, Character.class);
            try{
                fileNames.add(c.getName());
                FileWriter file = new FileWriter(c.getName());
                file.write(json);
                file.close();
            } catch(java.io.IOException io){
                io.printStackTrace();
                Log.e("CharacterDirectory", "No Character Directory found");
            }
        }
    }
}
