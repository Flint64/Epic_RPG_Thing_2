package chimera.epic_rpg_thing.model;

public class Benefit {
    private short strengthBonus;
    private short manaBonus;
    private short dexterityBonus;
    private int baseHealthBonus;
    private int baseManaBonus;
    private int attackBonus;
    private Skill skill;

    Benefit(short strengthBonus, short manaBonus, short dexterityBonus, int baseHealthBonus, int baseManaBonus, int attackBonus, Skill skill){
        this.strengthBonus = strengthBonus;
        this.manaBonus = manaBonus;
        this.dexterityBonus = dexterityBonus;
        this.baseHealthBonus = baseHealthBonus;
        this.baseManaBonus = baseManaBonus;
        this.attackBonus = attackBonus;
        this.skill = skill;
    }

    /**
     * returns the strength bonus
     * @return strengthBonus
     */
    public short getStrengthBonus() {
        return strengthBonus;
    }

    /**
     * sets the strength bonus
     * @param strengthBonus
     */
    public void setStrengthBonus(short strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    /**
     * gets the mana bonus
     * @return strengthBonus
     */
    public short getManaBonus() {
        return manaBonus;
    }

    /**
     * sets the mana bonus
     * @param manaBonus
     */
    public void setManaBonus(short manaBonus) {
        this.manaBonus = manaBonus;
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
     * gets the skill
     * @return
     */
    public Skill getSkill() {
        return skill;
    }

    /**
     * sets the skill
     * @param skill
     */
    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
