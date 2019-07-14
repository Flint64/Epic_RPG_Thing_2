package chimera.epic_rpg_thing.presenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import chimera.epic_rpg_thing.model.AOE_Skills.AOEBaseSkill;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.ElementalEffect;
import chimera.epic_rpg_thing.model.ElementalType;
import chimera.epic_rpg_thing.model.PlayerCharacter;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.FirebaseThings;
import chimera.epic_rpg_thing.model.Monster;
import chimera.epic_rpg_thing.model.Single_Skills.SingleBaseSkill;
import chimera.epic_rpg_thing.model.Single_Skills.SingleDamage;
import chimera.epic_rpg_thing.model.Single_Skills.SingleSkillFactory;
import chimera.epic_rpg_thing.model.Single_Skills.SingleType;
import chimera.epic_rpg_thing.model.Story;

public class CombatPresenter {
    PlayerCharacter playerCharacter;
    BaseSkill selectedSkill = null;
    boolean gameDone = false;
    List<Creature> selectedTargets = new ArrayList<>();
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
        selectedSkill.effectTargets();
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public boolean addSelectedTargetToSkill(int position, boolean self){
        if(self){
            if(selectedSkill instanceof AOEBaseSkill){
                if(((AOEBaseSkill) selectedSkill).getTargets() != null &&((AOEBaseSkill) selectedSkill).getMaxTargets() < ((AOEBaseSkill) selectedSkill).getTargets().size()){
                    ((AOEBaseSkill) selectedSkill).addTarget(playerCharacter);
                    return true;
                }
                return false;
            }else if (selectedSkill instanceof SingleBaseSkill){
                ((SingleBaseSkill)selectedSkill).setTarget(playerCharacter);
                return true;
            } else {
                return false;
            }
        } else {
            if(selectedSkill instanceof AOEBaseSkill){
                if(((AOEBaseSkill) selectedSkill).getTargets() != null &&((AOEBaseSkill) selectedSkill).getMaxTargets() < ((AOEBaseSkill) selectedSkill).getTargets().size()){
                    ((AOEBaseSkill) selectedSkill).addTarget(monsters.get(position));
                    return true;
                }
                return false;
            }else if (selectedSkill instanceof SingleBaseSkill){
                ((SingleBaseSkill)selectedSkill).setTarget(monsters.get(position));
                return true;
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

    //FirebaseThings fbThings = new FirebaseThings();
    List<Monster> monsters = new ArrayList<Monster>(4);

    public void addMonsters() {
        Monster goblin1 = new Monster(30, 0, 5, null, 2, 0, 1, 1, 0, 0, "Goblin", new ArrayList<ElementalEffect>(), 50, 5, true);
        Monster goblin2 = new Monster(30, 0, 5, null, 2, 0, 1, 1, 0, 0, "Goblin", new ArrayList<ElementalEffect>(), 50, 5, true);
        Monster goblin3 = new Monster(30, 0, 5, null, 2, 0, 1, 1, 0, 0, "Goblin", new ArrayList<ElementalEffect>(), 50, 5, true);
        Monster goblin4 = new Monster(30, 0, 5, null, 2, 0, 1, 1, 0, 0, "Goblin", new ArrayList<ElementalEffect>(), 50, 5, true);

        monsters.add(goblin1);
        monsters.add(goblin2);
        monsters.add(goblin3);
        monsters.add(goblin4);
    }

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

    public boolean isGameDone() {
        return gameDone;
    }

    public void setGameDone(boolean gameDone) {
        this.gameDone = gameDone;
    }

    public void stopRun(){
        gameDone = true;
    }
    public void endTurn(){
        playerCharacter.endTurn();
        SingleDamage damage = (SingleDamage) SingleSkillFactory.create(SingleType.DAMAGE, "Tackle", 0, 0, 5, null, new ElementalEffect(ElementalType.PHYSICAL, 1), "The goblin charges you with his head down");
        damage.setTarget(playerCharacter);
        int numDeadMonsters = 0;
        for(Monster m : monsters){
            if(m.isAlive()){
                damage.effectHP();
            } else {
                numDeadMonsters++;
            }
        }
        if(numDeadMonsters > 3){
            stopRun();
        }
        if(!playerCharacter.isAlive()){
            stopRun();
        }
   }
}
