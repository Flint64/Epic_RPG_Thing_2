package chimera.epic_rpg_thing.model;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class User {
    final String name;
    String password;
    List<String> names;
    Character character;
    public User(){
        this.name = "DEFAULT";
        this.password = "1234";
        this.names = null;
    }
    public User(final String name){
        names = new ArrayList<String>();
        this.name = name;
    }
    /**
     * Loads the character in from the character database.
     * uses the CharacterDirectory file to find the id's
     * for the characters.
     */
    public ArrayList<Character> loadCharacters(){
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
            f.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return tmpCharacters;
    }

    /**
     * Uploads the character to the database
     */
    public void saveCharacter(){
        Gson gson = new Gson();
        String json;
        boolean failed = false;
        boolean dir = true;
        do {
            try {
                json = gson.toJson(names, ArrayList.class);
                BufferedWriter bf = new BufferedWriter(new FileWriter("CharacterDirectory.dat", true));
                bf.newLine();
                bf.write(json);
                dir = false;
                if(failed = true){
                    failed = false;
                }
                bf.close();
                loadCharacterDirectory();
                json = gson.toJson(character, Character.class);
                bf = new BufferedWriter(new FileWriter(character.getName()));

            } catch (java.io.IOException io){
                io.printStackTrace();
                failed = true;
                if(dir){
                    try{
                        File file = new File("CharacterDirectory.dat");
                        file.createNewFile();
                    } catch (java.io.IOException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        } while(failed);
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
            BufferedReader reader = new BufferedReader(new FileReader("CharacterDirectory.dat"));
            names = gson.fromJson(reader, ArrayList.class);
            reader.close();

        } catch (java.io.IOException io){
            Log.e("CharacterDirectoryError", "Unable to get Character Directory");
        }
    }

    public String getName() {
        return name;
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
    private void loadCharacterDirectory(){
        Gson gson = new Gson();
        try{
            BufferedReader br = new BufferedReader(new FileReader("CharacterDirectory.dat"));
            names = gson.fromJson(br, ArrayList.class);
            br.close();
        }catch (java.io.IOException io){
            io.printStackTrace();
        }
    }
}
