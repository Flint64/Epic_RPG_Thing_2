package chimera.epic_rpg_thing.model;

public class Benefit {
    private short strengthBonus;
    private short intelligenceBonus;
    private short dexterityBonus;
    private int baseHealthBonus;
    private int baseManaBonus;
    private int currentManaBonus;
    private int currentHealthBonus;
    private int attackBonus;
    private BaseSkill baseSkill;
    private boolean expired;
    private boolean continuos;
    private int turns;

    /**
     * Default Constructor for the Benefit Class.
     */
    public Benefit(){
        strengthBonus = 0;
        intelligenceBonus = 0;
        dexterityBonus = 0;
        baseHealthBonus = 0;
        baseManaBonus = 0;
        attackBonus = 0;
        turns = 0;
        expired = true;
    }

    /**
     * Non-Default Constructor
     * @param strengthBonus
     * @param intelligenceBonus
     * @param dexterityBonus
     * @param baseHealthBonus
     * @param baseManaBonus
     * @param attackBonus
     * @param baseSkill
     */
    public Benefit(short strengthBonus, short intelligenceBonus, short dexterityBonus, int baseHealthBonus, int baseManaBonus, int currentHealthBonus, int currentManaBonus, int attackBonus, BaseSkill baseSkill, int turns, boolean continuos){
        this.strengthBonus = strengthBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.dexterityBonus = dexterityBonus;
        this.baseHealthBonus = baseHealthBonus;
        this.baseManaBonus = baseManaBonus;
        this.currentHealthBonus = currentHealthBonus;
        this.currentManaBonus = currentManaBonus;
        this.attackBonus = attackBonus;
        this.baseSkill = baseSkill;
        this.turns = turns;
        this.continuos = continuos;
    }

    /**
     * Adds the input benefit with the current benefit
     * @param ben
     */
    public void addBenefit(Benefit ben){
        this.baseManaBonus += ben.getBaseManaBonus();
        this.baseHealthBonus += ben.getBaseHealthBonus();
        this.strengthBonus += ben.getStrengthBonus();
        this.intelligenceBonus += ben.getIntelligenceBonus();
        this.dexterityBonus += ben.getDexterityBonus();
        this.attackBonus += ben.getAttackBonus();
    }

    /**
     * Subtracts the current value with a value that was passed in.
     * @param ben
     */
    public void removeBenefit(Benefit ben){
        this.baseManaBonus -= ben.getBaseManaBonus();
        this.baseHealthBonus -= ben.getBaseHealthBonus();
        this.strengthBonus -= ben.getStrengthBonus();
        this.intelligenceBonus -= ben.getIntelligenceBonus();
        this.dexterityBonus -= ben.getDexterityBonus();
        this.attackBonus -= ben.getAttackBonus();
    }
    /**
     * returns the strength bonus
     * @return strengthBonus
     */
    public short getStrengthBonus() {
        return strengthBonus;
    }
    public boolean isExpired(){
        return expired;
    }
    /**
     * sets the strength bonus
     * @param strengthBonus
     */
    public void setStrengthBonus(short strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    /**
     * gets the intelligence bonus
     * @return strengthBonus
     */
    public short getIntelligenceBonus() {
        return intelligenceBonus;
    }

    /**
     * sets the mana bonus
     * @param intelligenceBonus
     */
    public void setIntelligenceBonus(short intelligenceBonus) {
        this.intelligenceBonus = intelligenceBonus;
    }

    /**
     * gets the dexterity bonus
     * @return
     */
    public short getDexterityBonus() {
        return dexterityBonus;
    }

    /**
     * sets the dexterity bonus
     * @param dexterityBonus
     */
    public void setDexterityBonus(short dexterityBonus) {
        this.dexterityBonus = dexterityBonus;
    }

    /**
     * gets the base health bonus
     * @return
     */
    public int getBaseHealthBonus() {
        return baseHealthBonus;
    }

    /**
     * sets the base health bonus
     * @param baseHealthBonus
     */
    public void setBaseHealthBonus(int baseHealthBonus) {
        this.baseHealthBonus = baseHealthBonus;
    }

    /**
     * gets the base mana bonus
     * @return
     */
    public int getBaseManaBonus() {
        return baseManaBonus;
    }

    /**
     * sets the base mana bonus
     * @param baseManaBonus
     */
    public void setBaseManaBonus(int baseManaBonus) {
        this.baseManaBonus = baseManaBonus;
    }

    /**
     * gets the attack bonus
     * @return
     */
    public int getAttackBonus() {
        return attackBonus;
    }

    /**
     * sets the attack bonus
     * @param attackBonus
     */
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    /**
     * gets the baseSkill
     * @return
     */
    public BaseSkill getBaseSkill() {
        return baseSkill;
    }

    /**
     * sets the baseSkill
     * @param baseSkill
     */
    public void setBaseSkill(BaseSkill baseSkill) {
        this.baseSkill = baseSkill;
    }

    public void endOfTurn(){
        if(continuos){
            return;
        }else if(turns > 0){
            turns--;
        }else {
            expired = true;
        }
    }
}
