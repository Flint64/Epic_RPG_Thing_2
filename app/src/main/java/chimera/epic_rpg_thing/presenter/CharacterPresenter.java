package chimera.epic_rpg_thing.presenter;

import java.util.ArrayList;
import java.util.List;

import chimera.epic_rpg_thing.model.Character;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Classes.ClericClass;
import chimera.epic_rpg_thing.model.Classes.RogueClass;
import chimera.epic_rpg_thing.model.Classes.WizardClass;
import chimera.epic_rpg_thing.model.FirebaseThings;
import chimera.epic_rpg_thing.model.User;
import chimera.epic_rpg_thing.model.Classes.WarriorClass;

public class CharacterPresenter {
    private User user;
    public FirebaseThings fbThing = new FirebaseThings();

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

        switch (choice){
            case "Warrior":
                WarriorClass warriorClass = new WarriorClass();
                Character newWarrior= new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, warriorClass);
                fbThing.writeCharacter(newWarrior);
                break;

            case "Mage":
                WizardClass mageClass = new WizardClass();
                Character newMage = new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, mageClass);
                fbThing.writeCharacter(newMage);
                break;

            case "Rogue":
                RogueClass rogueClass = new RogueClass();
                Character newRogue = new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, rogueClass);
                fbThing.writeCharacter(newRogue);
                break;

            case "Cleric":
                ClericClass clericClass = new ClericClass();
                Character newCleric = new Character(health, mana, damage, list, strength, intelligence, dexterity, evasion, name, clericClass);
                fbThing.writeCharacter(newCleric);
                break;
        }
    }
}
