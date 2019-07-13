package chimera.epic_rpg_thing.presenter;

import java.util.List;

import chimera.epic_rpg_thing.model.Character;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Classes.CharacterClass;
import chimera.epic_rpg_thing.model.User;

public class CharacterPresenter {
    private User user;

//    public void createCharacter(String choice, String classChoice, short intelligence, short dexterity, short strength, double health, float mana, double evasion, float damage) {

    public Character createCharacter(String choice, String name, int intelligence, int dexterity, int strength, int health, double mana, double evasion, double damage, List<BaseSkill> list, CharacterClass characterClass){
        switch (choice){
            case "Warrior":
                return new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, characterClass);
            case "Mage":
                return new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, characterClass);
            case "Rogue":
                return new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, characterClass);
            case "Cleric":
                return new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, characterClass);
        }
        return null;
    }
}
