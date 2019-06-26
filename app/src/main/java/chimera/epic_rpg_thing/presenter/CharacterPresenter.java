package chimera.epic_rpg_thing.presenter;

import java.util.ArrayList;
import java.util.List;

import chimera.epic_rpg_thing.model.Character;
import chimera.epic_rpg_thing.model.CharacterClass;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.User;
import chimera.epic_rpg_thing.model.WarriorClass;

public class CharacterPresenter {
    private User user;

    public CharacterPresenter(){

    }

    public CharacterPresenter(GamePresenter presenter){
        user = presenter.getUser();
    }

    public List<Character> getCharacters(){
        return user.getCharacters();
    }

    public void addCharacter(Character c) { user.addCharacter(c);}

//    public void createCharacter(String choice, String classChoice, short intelligence, short dexterity, short strength, double health, float mana, double evasion, float damage) {

    public void createCharacter(String choice, String name, short intelligence, short dexterity, short strength, int health, double mana, double evasion, double damage){
        List<BaseSkill> list = new ArrayList<>();
        WarriorClass warriorClass = new WarriorClass();

        Character character = new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, warriorClass);

//        Character character = new Character(list, (short) 10, (short) 5, (short) 0, "Kal-El", warriorClass);
    }
}
