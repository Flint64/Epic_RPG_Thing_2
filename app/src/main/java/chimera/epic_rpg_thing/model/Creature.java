package chimera.epic_rpg_thing.model;
import java.util.List;

/**
 * Creature Class
 * Description: Parent class for living creatures.
 * @Version 1.0
 * @Author Shane Mecham
 */
public abstract class Creature {
    // Stats for hp indicator
    protected int baseHp;
    protected int currentHP;
    protected int maxHP;
    protected int hpMulti;
    // Stats for mana indicator
    protected double baseMana;
    protected double maxMana;
    protected double currentMana;
    protected double manaMulti;
    // Base attack
    protected double attack;
    // List for baseSkills
    protected List<BaseSkill> baseSkills;
    // Amount of damage you can absorb.
    protected double defense;
    // Evasion: Chance to dodge an attack
    protected double evasion;
    // Character attributes
    protected short strength;
    protected short intelligence;
    protected short dexterity;
    protected String name;
    protected List<ElementalEffect> weakeness;

    /**
     * Base Creature class constructor
     * @param baseHp
     * @param baseMana
     * @param attack
     * @param baseSkills
     * @param strength
     * @param intelligence
     * @param dexterity
     * @param evasion
     * @param hpMulti
     * @param manaMulti
     * @param name
     * @param weaknesses
     */
    public Creature(int baseHp, double baseMana, double attack, List<BaseSkill> baseSkills, short strength, short intelligence, short dexterity, double evasion, int hpMulti, int manaMulti, String name, List<ElementalEffect> weaknesses){
        this.baseHp = baseHp;
        this.baseMana = baseMana;
        this.attack = attack;
        this.baseSkills = baseSkills;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.hpMulti = hpMulti;
        this.manaMulti = manaMulti;
        this.attack = attack;
        this.evasion = evasion;
        this.maxHP = this.baseHp + this.strength * this.hpMulti;
        this.maxMana = this.baseMana + this.intelligence * this.manaMulti;
        this.name = name;
        this.weakeness = weaknesses;
        generateDefense();
    }
    /**
     * Getter for the maxHP
     * @return int
     */
    int getMaxHP(){
        return maxHP = this.baseHp + this.strength * this.hpMulti;
    }

    /**
     * Setter for the maxHP
     * @param bonus
     * @return void
     */
    void setMaxHP(int bonus){
        maxHP = this.baseHp + this.strength * this.hpMulti + bonus;
    }

    /**
     * Getter for the maxMana
     * @return int
     */
    double getMaxMana(){
        return maxMana;
    }

    /**
     * Sets the maxMana;
     * @param maxMana
     * @return
     */
    void setMaxMana(double maxMana){
        this.maxMana = maxMana;
    }
    /**
     * Getter for baseHP
     * @return int
     */
    public int getBaseHp(){
        return baseHp;
    }

    /**
     * Setter for baseHP
     * @param baseHp
     */
    public void setBaseHp(int baseHp){
        this.baseHp = baseHp;
    }

    /**
     * Getter for currentHP that returns the currentHP
     * @return int
     */
    public int getCurrentHP() {
        return currentHP;
    }

    /**
     * Setter for currentHP
     * @param
     */
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    /**
     * Getter for baseMana that returns the baseMana
     * @return int
     */
    public double getBaseMana(){
        return baseMana;
    }

    /**
     * Setter for baseMana that will set the baseMana given an input.
     * @param
     */
    public void setBaseMana(double baseMana){
        this.baseMana = baseMana;
    }

    /**
     * Getter for currentMana
     * @return int
     */
    public double getCurrentMana() {
        return currentMana;
    }

    /**
     * Setter for currentMana
     * @param
     */
    public void setCurrentMana(double currentMana) {
        this.currentMana = currentMana;
    }

    /**
     * Getter for the attack damage
     * @return int
     */
    public double getAttack() {
        return attack;
    }

    /**
     * Setter for the attack damage
     * @param
     */
    public void setAttack(double attack) {
        this.attack = attack;
    }

    /**
     * Getter for the defense stat. Defense is the amount of damage that can be absorbed by the creature
     * @return int
     */
    public abstract void generateDefense();

    /**
     * Effect hp
     */
    public void effectHp(int amount, ElementalEffect effect){
        if(weakeness.contains(effect)){
            this.currentHP += 2* effect.getLevel() + amount;
        } else {
            this.currentHP += amount;
        }
    }

    public abstract void effectBuff(Benefit buff);
    /**
     * Getter for the Strength stat.
     * @return short
     */
    public short getStrength() {
        return strength;
    }

    /**
     * Setter for the Strength stat.
     * @param
     */
    public void setStrength(short strength) {
        this.strength = strength;
    }

    /**
     * Getter for the intelligence stat.
     * @return short
     */
    public short getIntelligence() {
        return intelligence;
    }

    /**
     * Setter for the intelligence stat
     * @param
     */
    public void setIntelligence(short intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Getter for the dexterity stat
     * @return short
     */
    public short getDexterity() {
        return dexterity;
    }

    /**
     * Setter for the dexterity stat
     * @param
     */
    public void setDexterity(short dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Returns the name of the character
     * @return string
     */
    public String getName() {return name;}

    /**
     * Sets the character name
     * @param name
     */
    public void setName(String name){this.name = name;}

    public List<ElementalEffect> getWeakeness(){
        return weakeness;
    }
    public void setWeakeness(ElementalEffect weakeness){
        this.weakeness.add(weakeness);
    }
    public void removeWeakness(ElementalEffect weakeness){
        if(this.weakeness.contains(weakeness)){
            this.weakeness.remove(weakeness);
        }
    }
}