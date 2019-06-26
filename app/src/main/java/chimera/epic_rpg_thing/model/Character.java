package chimera.epic_rpg_thing.model;

import java.util.List;

public class Character extends Creature{
    private int level;
    private int XP;
    // ArrayLists for baseSkills and items
    private CharacterClass cClass;
    private CharacterInventory inventory;
    private int baseSlots = 20;
    private int baseSlotMod = 5;
    private Benefit totalBenefit;
    private List<Benefit> listBenefits;


    public Character() {
        super(0, 0, 0, null, (short) 0, (short) 0, (short) 0, 0, 0, 0, null, null);
        inventory = null;
        level = 0;
        XP = 0;
        totalBenefit = new Benefit();
    }
    /**
     * Creates a character by passing values to the super constructor and by initializing the CharacterInventory
     * @param currentBaseSkills
     * @param strength
     * @param intelligence
     * @param dexterity
     * @param name
     * @param cClass
     */
    public Character(int baseHp, double mana, double attack, List<BaseSkill> currentBaseSkills, short strength, short intelligence, short dexterity, double evasion, String name, CharacterClass cClass) {
        super(baseHp, mana, attack, currentBaseSkills, strength, intelligence, dexterity, evasion, cClass.getClassMod("hpMulti"), cClass.getClassMod("manaMulti"), name, cClass.getWeaknesses());
        inventory = new CharacterInventory(baseSlots + strength * baseSlotMod, 0);
        level = 0;
        XP = 0;
    }
    public void combatStart(){
        generateBenefit();
    }
    public void generateBenefit(){
        totalBenefit = inventory.getEquippedBenefit();
        listBenefits = inventory.getAllEquippedBenefits();
    }
    @Override
    public void generateDefense() {
        defense = 10 + strength * cClass.getClassMod("defense");
    }
    public void endTurn(){
        for(Benefit ben : listBenefits){
            if(ben.isExpired()){
                ben.removeBenefit(ben);
            }
            else {
                ben.endOfTurn();
            }
        }
    }
    @Override
    public void effectHp(int amount, ElementalEffect effect) {
        this.currentHP += amount;
    }

    @Override
    public void effectBuff(Benefit buff) {
        totalBenefit.addBenefit(buff);
        listBenefits.add(buff);
    }
}