package chimera.epic_rpg_thing.model;

import java.util.ArrayList;
import java.util.List;

import chimera.epic_rpg_thing.model.Classes.CharacterClass;

public class PlayerCharacter extends Creature{
    private int level;
    private int XP;
    // ArrayLists for baseSkills and items
    private CharacterClass cClass;
    private CharacterInventory inventory;
    private int baseSlots = 20;
    private int baseSlotMod = 5;

    public String toString(){
        return getName() + " " + getClass() + " " + level;
    }

    public PlayerCharacter() {
        super(0, 0, 0, null,  0,  0,  0, 0, 0, 0, "BOB", new ArrayList<ElementalEffect>());
        inventory = null;
        level = 0;
        XP = 0;
    }
    /**
     * Creates a playerCharacter by passing values to the super constructor and by initializing the CharacterInventory
     * @param currentBaseSkills
     * @param strength
     * @param intelligence
     * @param dexterity
     * @param name
     * @param cClass
     */
    public PlayerCharacter(int baseHp, double mana, double attack, List<BaseSkill> currentBaseSkills, int strength, int intelligence, int dexterity, double evasion, String name, CharacterClass cClass) {
        super(baseHp, mana, attack, currentBaseSkills, strength, intelligence, dexterity, evasion, cClass.getClassMod("hpMulti"), cClass.getClassMod("manaMulti"), name, cClass.getWeaknesses());
        inventory = new CharacterInventory(baseSlots + strength * baseSlotMod, 0);
        level = 0;
        XP = 0;
    }

    /**
     * Methods to be run at the beginning of Combat
     */
    public void combatStart(){
        generateBenefit();
    }

    /**
     * Method to be called to flush all temporary effects.
     */
    public void combatEnd(){
        setTotalBenefit(new Benefit());
        setListBenefits(null);
        setCurrentHP(getMaxHP());
        setCurrentMana(getMaxMana());
    }
    public void generateBenefit(){
        setTotalBenefit(inventory.getEquippedBenefit());
        setListBenefits(inventory.getAllEquippedBenefits());
    }
    public void endTurn(){
        for(Benefit ben : getListBenefits()){
            if(ben.isExpired()){
                removeBenefitFromList(ben);
                removeBenefitFromTotal(ben);
            }
            else {
                ben.endOfTurn();
            }
        }
    }
}