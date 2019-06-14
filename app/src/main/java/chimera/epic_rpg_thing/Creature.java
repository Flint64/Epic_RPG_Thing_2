package chimera.epic_rpg_thing;
import java.util.List;

/**
 * Creature Class
 * Description: Parent class for living creatures.
 * @Version 1.0
 * @Author Shane Mecham
 */
public abstract class Creature {
    // Stats for hp indicator
    private int baseHp;
    private int currentHP;
    private int maxHP;
    private int hpMulti;
    // Stats for mana indicator
    private int baseMana;
    private int maxMana;
    private int currentMana;
    private int manaMulti;
    // Base attack
    int attack;
    // List for skills
    List<Skill> skills;
    // Amount of damage you can absorb.
    int defense;
    // Evasion: Chance to dodge an attack
    int evasion;
    // Character attributes
    short strength;
    short mana;
    short dexterity;
    String name;

    public Creature(int baseHp, int baseMana, int attack, List<Skill> skills, short strength, short mana, short dexterity, int hpMulti, int manaMulti, String name){
        this.baseHp = baseHp;
        this.baseMana = baseMana;
        this.attack = attack;
        this.skills = skills;
        this.strength = strength;
        this.mana = mana;
        this.dexterity = dexterity;
        this.hpMulti = hpMulti;
        this.manaMulti = manaMulti;
        this.maxHP = this.baseHp + this.strength * this.hpMulti;
        this.maxMana = this.baseMana + this.mana * this.manaMulti;
        this.name = name;
        generateDefense();
        generateEvasion();
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
    int getMaxMana(){
        return maxMana;
    }

    /**
     * Sets the maxMana;
     * @param bonus
     * @return
     */
    void setMaxMana(int bonus){
        maxMana = baseMana + mana * 5 + bonus;
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
    public int getBaseMana(){
        return baseMana;
    }

    /**
     * Setter for baseMana that will set the baseMana given an input.
     * @param
     */
    public void setBaseMana(int baseMana){
        this.baseMana = baseMana;
    }

    /**
     * Getter for currentMana
     * @return int
     */
    public int getCurrentMana() {
        return currentMana;
    }

    /**
     * Setter for currentMana
     * @param
     */
    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    /**
     * Getter for the attack damage
     * @return int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Setter for the attack damage
     * @param
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Getter for the defense stat. Defense is the amount of damage that can be absorbed by the creature
     * @return int
     */
    public abstract void generateDefense();

    /**
     * Runs the algorith to generate the Evasion Stat
     * @return int
     */
    public abstract void generateEvasion();

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
     * Getter for the mana stat.
     * @return short
     */
    public short getMana() {
        return mana;
    }

    /**
     * Setter for the mana stat
     * @param
     */
    public void setMana(short mana) {
        this.mana = mana;
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
}