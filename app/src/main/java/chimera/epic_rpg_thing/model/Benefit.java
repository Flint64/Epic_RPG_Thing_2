package chimera.epic_rpg_thing.model;

public class Benefit {
    private int strengthBonus;
    private int intelligenceBonus;
    private int dexterityBonus;
    private int baseHealthBonus;
    private int baseManaBonus;
    private int currentManaBonus;
    private int currentHealthBonus;
    private int attackBonus;
    private BaseSkill baseSkill;
    private boolean expired;
    private boolean continuous;
    private boolean isBuff;
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
    public Benefit(int strengthBonus, int intelligenceBonus, int dexterityBonus, int baseHealthBonus, int baseManaBonus, int currentHealthBonus, int currentManaBonus, int attackBonus, BaseSkill baseSkill, int turns, boolean continuous, boolean isBuff){
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
        this.continuous = continuous;
        this.isBuff = isBuff;
    }

    public int getCurrentManaBonus() {
        return currentManaBonus;
    }

    public void setCurrentManaBonus(int currentManaBonus) {
        this.currentManaBonus = currentManaBonus;
    }

    public int getCurrentHealthBonus() {
        return currentHealthBonus;
    }

    public void setCurrentHealthBonus(int currentHealthBonus) {
        this.currentHealthBonus = currentHealthBonus;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isBuff() {
        return isBuff;
    }

    public void setBuff(boolean buff) {
        isBuff = buff;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public boolean isContinuous() {
        return continuous;
    }

    public void setContinuous(boolean continuous) {
        this.continuous = continuous;
    }
    public Benefit inverse(){
        if(isBuff){
            this.baseHealthBonus = -baseHealthBonus;
            this.baseManaBonus = -baseManaBonus;
            this.strengthBonus = -strengthBonus;
            this.intelligenceBonus = -intelligenceBonus;
            this.dexterityBonus = -dexterityBonus;
            this.attackBonus = -attackBonus;
        }
        this.isBuff = true;
        return this;
    }
    /**
     * Checks if the input benefit is a buff or not and adds or removes based on that.
     * @param ben
     */
    public void addBenefit(Benefit ben){
        if(ben.isBuff()){
            this.baseManaBonus += ben.getBaseManaBonus();
            this.baseHealthBonus += ben.getBaseHealthBonus();
            this.strengthBonus += ben.getStrengthBonus();
            this.intelligenceBonus += ben.getIntelligenceBonus();
            this.dexterityBonus += ben.getDexterityBonus();
            this.attackBonus += ben.getAttackBonus();
        } else {
            this.baseManaBonus -= ben.getBaseManaBonus();
            this.baseHealthBonus -= ben.getBaseHealthBonus();
            this.strengthBonus -= ben.getStrengthBonus();
            this.intelligenceBonus -= ben.getIntelligenceBonus();
            this.dexterityBonus -= ben.getDexterityBonus();
            this.attackBonus -= ben.getAttackBonus();
        }
    }

    /**
     * returns the strength bonus
     * @return strengthBonus
     */
    public int getStrengthBonus() {
        return strengthBonus;
    }
    public boolean isExpired(){
        return expired;
    }
    /**
     * sets the strength bonus
     * @param strengthBonus
     */
    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    /**
     * gets the intelligence bonus
     * @return strengthBonus
     */
    public int getIntelligenceBonus() {
        return intelligenceBonus;
    }

    /**
     * sets the mana bonus
     * @param intelligenceBonus
     */
    public void setIntelligenceBonus(int intelligenceBonus) {
        this.intelligenceBonus = intelligenceBonus;
    }

    /**
     * gets the dexterity bonus
     * @return
     */
    public int getDexterityBonus() {
        return dexterityBonus;
    }

    /**
     * sets the dexterity bonus
     * @param dexterityBonus
     */
    public void setDexterityBonus(int dexterityBonus) {
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
        if(continuous){
            return;
        }else if(turns > 0){
            turns--;
        }else {
            expired = true;
        }
    }
}
