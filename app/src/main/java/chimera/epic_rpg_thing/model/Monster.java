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
    Benefit benefit;

    public Monster(){

        super(0, 0,0,null,(short) 0, (short)0, (short) 0, 0,0,0,null, null);
    }
    public Monster(int baseHp, double baseMana, double attack, List<BaseSkill> baseSkills, short strength, short mana, short dexterity, double evasion, int hpMulti, int manaMulti, String name, List<ElementalEffect> weakness) {
        super(baseHp, baseMana, attack, baseSkills, strength, mana, dexterity, evasion, hpMulti, manaMulti, name, weakness);
    }

    @Override
    public void generateDefense() {

    }

    @Override
    public void effectBuff(Benefit buff) {

    }
}
