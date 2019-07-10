package chimera.epic_rpg_thing.model;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String password;
    List<String> names;
    Character character;
    public User(){
        this.name = "DEFAULT";
        this.password = "1234";
        this.names = null;
    }
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
    /**
     * Loads the character in from the character database.
     * uses the CharacterDirectory file to find the id's
     * for the characters.
     */
    private void loadCharacters(){
        ArrayList<Character> tmpCharacters = new ArrayList<>();
        Gson gson = new Gson();
        try {
            getCharacterDirectory();
            for(String s : names){
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
     * Uploads the character to the database
     */
    public void saveCharacters(){
        Gson gson = new Gson();
        String json;
        updateCharacterDirectory();
        try {
            json = gson.toJson(names, ArrayList.class);
            FileWriter file = new FileWriter("CharacterDirectory");
            file.write(json);
            file.close();
        } catch (java.io.IOException io){
            io.printStackTrace();
        }
    }

    /**
     * Will delete a character from the database and update the characterDirectory
     * @param name
     */
    public void deleteCharacter(String name){
    }

    /**
     * Gets the directory of character names
     */
    private void getCharacterDirectory(){
        try {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader("CharacterDirectory"));
            names = gson.fromJson(reader, ArrayList.class);
            reader.close();

        } catch (java.io.IOException io){
            Log.e("CharacterDirectoryError", "Unable to get Character Directory");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * Will update the characterDirectory from the database online when called
     */
    private void updateCharacterDirectory(){

    }
}
