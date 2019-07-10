package chimera.epic_rpg_thing.presenter;

import java.util.List;
import java.util.ArrayList;

import chimera.epic_rpg_thing.model.AOE_Skills.AOEBaseSkill;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.Monster;
import chimera.epic_rpg_thing.model.Single_Skills.SingleBaseSkill;
import chimera.epic_rpg_thing.model.Story;
import chimera.epic_rpg_thing.model.User;

public class CombatPresenter {
    User user = new User();
    List<Character> party = new ArrayList<Character>(3);
    Monster monster[] = new Monster[4];
    Story story;
    public void onLoad(){

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
    public User getUser(){
        return user;
    }
}
