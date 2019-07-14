package chimera.epic_rpg_thing.model;
import java.util.ArrayList;
import java.util.List;

public class Monster extends Creature {
    int XPvalue;
    int goldValue;
    int level;
    boolean canRun;

    public Monster() {
        super(0, 0, 0, new ArrayList<BaseSkill>(), 0, 0, 0, 0, 0, 0, "", new ArrayList<ElementalEffect>());
        initializeLevel();
    }

    public Monster(int baseHp, double baseMana, double attack, List<BaseSkill> currentSkills, int strength, int mana, int dexterity, double evasion, int hpMulti, int manaMulti, String name, List<ElementalEffect> weakness, int XPvalue, int goldValue, boolean canRun) {
        super(baseHp, baseMana, attack, currentSkills, strength, mana, dexterity, evasion, hpMulti, manaMulti, name, weakness);
        //initializeLevel();
        setXPvalue(XPvalue);
        setGoldValue(goldValue);
        setCanRun(canRun);
    }

    public int getXPvalue() {
        return XPvalue;
    }

    public void setXPvalue(int XPvalue) {
        this.XPvalue = XPvalue;
    }

    public int getGoldValue() {
        return goldValue;
    }

    public void setGoldValue(int goldValue) {
        this.goldValue = goldValue;
    }

    public boolean isCanRun() {
        return canRun;
    }

    public void setCanRun(boolean canRun) {
        this.canRun = canRun;
    }

    public boolean isAlive() {
        return getCurrentHP() > 0;
    }


    /**
     * Returns the monsters level created from the algorithm.
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Level shouldn't be changed after initialization
     */
    public void initializeLevel() {
        level = (getMaxHP() / 10) + ((int) getMaxMana() / 10) + getCurrentSkills().size();
    }
}