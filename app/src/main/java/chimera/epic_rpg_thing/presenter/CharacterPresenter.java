package chimera.epic_rpg_thing.presenter;

import java.util.List;

import chimera.epic_rpg_thing.model.Character;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Classes.CharacterClass;

import chimera.epic_rpg_thing.model.FirebaseThings;
import chimera.epic_rpg_thing.model.User;

public class CharacterPresenter {
    private User user;
    public FirebaseThings fbThing = new FirebaseThings();

    public CharacterPresenter(){

    }

    public CharacterPresenter(CombatPresenter presenter){
        user = presenter.getUser();
    }

//    public void createCharacter(String choice, String classChoice, short intelligence, short dexterity, short strength, double health, float mana, double evasion, float damage) {

    public void createCharacter(String choice, String name, int intelligence, int dexterity, int strength, int health, double mana, double evasion, double damage, List<BaseSkill> list, CharacterClass characterClass){
        switch (choice){
            case "Warrior":
                Character newWarrior = new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, characterClass);
                fbThing.writeCharacter(newWarrior);
                break;
            case "Mage":
                Character newMage = new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, characterClass);
                fbThing.writeCharacter(newMage);
                break;

            case "Rogue":
                Character newRogue = new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, characterClass);
                fbThing.writeCharacter(newRogue);
                break;

            case "Cleric":
                Character newCleric = new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, characterClass);
                fbThing.writeCharacter(newCleric);
                break;
        }
    }
}
