package chimera.epic_rpg_thing.model;
import java.util.ArrayList;
import java.util.List;

public class Monster extends Creature {
    int currentHP;
    int XPvalue;
    int goldValue;
    ArrayList<BaseSkill> baseSkills;
    boolean canRun;
    boolean isAlive;

    public Monster(){
        super(0, 0,0,null, 0, 0,  0, 0,0,0,null, null);
    }
    public Monster(int baseHp, double baseMana, double attack, List<BaseSkill> baseSkills, int strength, int mana, int dexterity, double evasion, int hpMulti, int manaMulti, String name, List<ElementalEffect> weakness) {
        super(baseHp, baseMana, attack, baseSkills, strength, mana, dexterity, evasion, hpMulti, manaMulti, name, weakness);
    }

    @Override
    public int getCurrentHP() {
        return currentHP;
    }

    @Override
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
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

    public ArrayList<BaseSkill> getBaseSkills() {
        return baseSkills;
    }

    public void setBaseSkills(ArrayList<BaseSkill> baseSkills) {
        this.baseSkills = baseSkills;
    }

    public boolean isCanRun() {
        return canRun;
    }

    public void setCanRun(boolean canRun) {
        this.canRun = canRun;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
