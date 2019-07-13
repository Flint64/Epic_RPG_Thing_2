package chimera.epic_rpg_thing.presenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import chimera.epic_rpg_thing.model.AOE_Skills.AOEBaseSkill;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.PlayerCharacter;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.FirebaseThings;
import chimera.epic_rpg_thing.model.Monster;
import chimera.epic_rpg_thing.model.Single_Skills.SingleBaseSkill;
import chimera.epic_rpg_thing.model.Story;

public class CombatPresenter {
    PlayerCharacter playerCharacter;
    BaseSkill selectedSkill = null;
    public CombatPresenter(PlayerCharacter playerCharacter){
         this.playerCharacter = playerCharacter;
    }

    public BaseSkill getSelectedSkill() {
        return selectedSkill;
    }

    public void setSelectedSkill(BaseSkill selectedSkill) {
        this.selectedSkill = selectedSkill;
    }

    public void useSelectedSkill(){
        if(selectedSkill == null){
            return;
        } else {
            selectedSkill.effectTargets();
        }
    }
    public boolean addSelectedTarget(int position, boolean self){
        if(self){
            if(selectedSkill instanceof AOEBaseSkill){
                if(((AOEBaseSkill) selectedSkill).getMaxTargets() < ((AOEBaseSkill) selectedSkill).getTargets().size()){
                    ((AOEBaseSkill) selectedSkill).addTarget(playerCharacter);
                    return true;
                }
                return false;
            }else if (selectedSkill instanceof SingleBaseSkill){
                if(((SingleBaseSkill)selectedSkill).getTarget() == null){
                    ((SingleBaseSkill)selectedSkill).setTarget(playerCharacter);
                    return true;
                }
                return false;
            } else {
                return false;
            }
        } else {
            if(selectedSkill instanceof AOEBaseSkill){
                if(((AOEBaseSkill) selectedSkill).getMaxTargets() < ((AOEBaseSkill) selectedSkill).getTargets().size()){
                    ((AOEBaseSkill) selectedSkill).addTarget(monsters.get(position));
                    return true;
                }
                return false;
            }else if (selectedSkill instanceof SingleBaseSkill){
                if(((SingleBaseSkill)selectedSkill).getTarget() == null){
                    ((SingleBaseSkill)selectedSkill).setTarget(monsters.get(position));
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    FirebaseThings fbThings = new FirebaseThings();
    List<Monster> monsters = new ArrayList<Monster>(4);
    Story story;

    /**
     * Function to be called when loading in the combat.
     * @param currentName
     * @param partyNames
     */
    public void onLoad(String currentName, List<String> partyNames){

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
     * Returns a list of the playerCharacter current skills
     * @return
     */
    public List<BaseSkill> getCharacterSkills(){
        return playerCharacter.getCurrentSkills();
    }
    public PlayerCharacter getUser(){
        return playerCharacter;
    }
    public void endTurn(){
        Random rand = new Random();
        playerCharacter.endTurn();
        List<BaseSkill> monster0 = monsters.get(0).getCurrentSkills();
        BaseSkill monster0skill = monster0.get(rand.nextInt(monster0.size()));
    }
}
