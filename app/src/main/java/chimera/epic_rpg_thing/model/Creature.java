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
    private List<BaseSkill> currentSkills;
    // Amount of damage you can absorb.
    private double defense;
    // Evasion: Chance to dodge an attack
    private double evasion;
    // PlayerCharacter attributes
    private int strength;
    private int intelligence;
    private int dexterity;
    // PlayerCharacter name
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
     * @param currentSkills
     * @param strength
     * @param intelligence
     * @param dexterity
     * @param evasion
     * @param hpMulti
     * @param manaMulti
     * @param name
     * @param weaknesses
     */
    public Creature(int baseHp, double baseMana, double attack, List<BaseSkill> currentSkills, int strength, int intelligence, int dexterity, double evasion, int hpMulti, int manaMulti, String name, List<ElementalEffect> weaknesses){
        this.baseHp = baseHp;
        this.baseMana = baseMana;
        this.attack = attack;
        this.currentSkills = currentSkills;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.hpMulti = hpMulti;
        this.manaMulti = manaMulti;
        this.attack = attack;
        this.evasion = evasion;
        this.maxHP = this.baseHp + this.strength * this.hpMulti;
        currentHP = this.maxHP;
        this.maxMana = this.baseMana + this.intelligence * this.manaMulti;
        currentMana = this.maxMana;
        this.defense = this.strength * 5;
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
     * Effect's the creaturs hp
     */
    public void effectHp(int amount, ElementalEffect effect, boolean attack){
        if(weakeness.contains(effect)){
            if(attack){
                this.currentHP += this.defense + 2 * effect.getLevel() * amount;
            } else {
                this.currentHP += amount;
            }
        } else {
            if(attack){
                this.currentHP += this.defense + amount;
            } else {
                this.currentHP += amount;
            }
        }
    }

    /**
     * applies a benefit to the playerCharacter
     * @param buff
     */
    public void effectBuff(Benefit buff){
        totalBenefit.addBenefit(buff);
        listBenefits.add(buff);
    }

    /**
     * Gets the total benefit
     * @return
     */
    public Benefit getTotalBenefit(){
        return totalBenefit;
    }

    /**
     * Sets the total benefit
     * @param benefit
     */
    public void setTotalBenefit(Benefit benefit){
        totalBenefit = benefit;
    }
    public void removeBenefitFromTotal(Benefit benefit){
        totalBenefit.addBenefit(benefit.inverse());
    }
    public List<Benefit> getListBenefits(){
        return listBenefits;
    }
    public void setListBenefits(List<Benefit> listBenefits){
        this.listBenefits = listBenefits;
    }
    public void removeBenefitFromList(Benefit ben){
        this.listBenefits.remove(ben);
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
    public boolean isAlive(){
        return currentHP > 0;
    }
    /**
     * Setter for the dexterity stat
     * @param
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Returns the name of the playerCharacter
     * @return string
     */
    public String getName() {return name;}

    /**
     * Sets the playerCharacter name
     * @param name
     */
    public void setName(String name){this.name = name;}

    public int getHpMulti() {
        return hpMulti;
    }

    public void setHpMulti(int hpMulti) {
        this.hpMulti = hpMulti;
    }

    public double getManaMulti() {
        return manaMulti;
    }

    public void setManaMulti(double manaMulti) {
        this.manaMulti = manaMulti;
    }

    /**
     * Returns the skills of the creature
     * @return
     */
    public List<BaseSkill> getCurrentSkills() {
        return currentSkills;
    }

    /**
     * Sets the skills of the creature
     * @param currentSkills
     */
    public void setCurrentSkills(List<BaseSkill> currentSkills) {
        this.currentSkills = currentSkills;
    }

    public void addCurrentSkill(BaseSkill skill){
        this.currentSkills.add(skill);
    }

    public void removeCurrentSkill(BaseSkill skill){
        this.currentSkills.remove(skill);
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getEvasion() {
        return evasion;
    }

    public void setEvasion(double evasion) {
        this.evasion = evasion;
    }

    /**
     * Returns the list of Elemental Effects the creature is weak too.
     * @return
     */
    public List<ElementalEffect> getWeakeness(){
        return weakeness;
    }

    /**
     * Sets the list of Elemental Effects the creature is weak too.
     * @param weakeness
     */
    public void setWeakeness(List<ElementalEffect> weakeness){
        this.weakeness = weakeness;
    }

    /**
     * Adds a weakness to the List of Elemental Effects.
     * @param weakness
     */
    public void addWeakness(ElementalEffect weakness){
        this.weakeness.add(weakness);
    }

    /**
     * Removes a weakness from the List of Elemental Effects.
     * @param weakeness
     */
    public void removeWeakness(ElementalEffect weakeness){
        this.weakeness.remove(weakeness);
    }
}