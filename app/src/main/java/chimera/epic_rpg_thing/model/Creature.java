package chimera.epic_rpg_thing.model;
import java.util.List;
import java.util.ArrayList;
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
    private double baseMana;
    private double maxMana;
    private double currentMana;
    private double manaMulti;
    // Base attack
    private double attack;
    // List for baseSkills
    private List<BaseSkill> baseSkills;
    // Amount of damage you can absorb.
    private double defense;
    // Evasion: Chance to dodge an attack
    private double evasion;
    // Character attributes
    private int strength;
    private int intelligence;
    private int dexterity;
    // Character name
    private String name;
    // List of weaknesses
    private List<ElementalEffect> weakeness;
    // Benefits handling
    private Benefit totalBenefit;
    private List<Benefit> listBenefits;

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
    public Creature(int baseHp, double baseMana, double attack, List<BaseSkill> baseSkills, int strength, int intelligence, int dexterity, double evasion, int hpMulti, int manaMulti, String name, List<ElementalEffect> weaknesses){
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
        listBenefits = new ArrayList<Benefit>();
        totalBenefit = new Benefit();
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
     * Effect hp
     */
    public void effectHp(int amount, ElementalEffect effect){
        if(weakeness.contains(effect)){
            this.currentHP += 2* effect.getLevel() + amount;
        } else {
            this.currentHP += amount;
        }
    }

    public void effectBuff(Benefit buff, boolean positive){
        if(positive){
            totalBenefit.addBenefit(buff);
            listBenefits.add(buff);
        }else {
            totalBenefit.removeBenefit(buff);
        }
    }
    public Benefit getTotalBenefit(){
        return totalBenefit;
    }
    public void setTotalBenefit(Benefit benefit){
        totalBenefit = benefit;
    }
    public List<Benefit> getListBenefits(){
        return listBenefits;
    }
    public void setListBenefits(List<Benefit> listBenefits){
        this.listBenefits = listBenefits;
    }
    /**
     * Getter for the Strength stat.
     * @return int
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Setter for the Strength stat.
     * @param
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Getter for the intelligence stat.
     * @return int
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Setter for the intelligence stat
     * @param
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Getter for the dexterity stat
     * @return int
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Setter for the dexterity stat
     * @param
     */
    public void setDexterity(int dexterity) {
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