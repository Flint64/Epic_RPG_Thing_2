package chimera.epic_rpg_thing.presenter;

import java.util.List;
import java.util.ArrayList;

import chimera.epic_rpg_thing.model.AOE_Skills.AOEBaseSkill;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.FirebaseThings;
import chimera.epic_rpg_thing.model.Character;
import chimera.epic_rpg_thing.model.Monster;
import chimera.epic_rpg_thing.model.Single_Skills.SingleBaseSkill;
import chimera.epic_rpg_thing.model.Story;
import chimera.epic_rpg_thing.model.User;

public class CombatPresenter {
    User user = new User();
    List<Character> party = new ArrayList<Character>(4);
    FirebaseThings fbThings = new FirebaseThings();
    List<Monster> monsters = new ArrayList<Monster>(4);
    Story story;

    /**
     * Function to be called when loading in the combat.
     * @param currentName
     * @param partyNames
     */
    public void onLoad(String currentName, List<String> partyNames){
        fbThings.readCharacter();
        List<Character> characters = fbThings.getCharacters();
        for(Character c : party){
            if(c.getName().equals(currentName)){
                user.setCharacter(c);
            }
            for(String s : partyNames){
                if(c.getName().equals(s)){
                    party.add(c);
                }
            }
        }
        fbThings.readMonster();
        monsters = fbThings.getMonsters();

    }

    /**
     * Function for using a Single Skill
     * @param singleBaseSkill
     * @param target
     */
    public void useSingle(SingleBaseSkill singleBaseSkill, Creature target){
        singleBaseSkill.setTarget(target);
        singleBaseSkill.effectTargets();
    }

    /**
     * Function for using a AOE Skill
     * @param selectedSkill
     * @param targets
     */
    public void useAOE(AOEBaseSkill selectedSkill, List<Creature> targets){
        selectedSkill.setTargets(targets);
        selectedSkill.effectTargets();
    }

    /**
     * Returns a list of the character current skills
     * @return
     */
    public List<BaseSkill> getCharacterSkills(){
        return user.getCharacter().getCurrentSkills();
    }
    public List<Character> getCharacters(){
        return party;
    }
    public User getUser(){
        return user;
    }
}
