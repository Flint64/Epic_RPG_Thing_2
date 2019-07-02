package chimera.epic_rpg_thing.presenter;

import java.util.ArrayList;
import java.util.List;

import chimera.epic_rpg_thing.model.Character;
import chimera.epic_rpg_thing.model.CharacterClass;
import chimera.epic_rpg_thing.model.Skill;
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

    public void createCharacter(String choice, String name, short intelligence, short dexterity, short strength, double health, double mana, double evasion, double damage){
        List<Skill> list = new ArrayList<>();
        WarriorClass warriorClass = new WarriorClass();

        Character character = new Character(list, strength, (short)mana, dexterity, name, warriorClass);
    }
}
