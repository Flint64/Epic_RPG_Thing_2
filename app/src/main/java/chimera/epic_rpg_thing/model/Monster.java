package chimera.epic_rpg_thing.model;
import java.util.ArrayList;
import java.util.List;

public class Monster extends Creature {
    int currentHP;
    int XPvalue;
    int goldValue;
    ArrayList<Skill> skills;
    boolean canRun;
    boolean isAlive;

    @Override
    public void generateEvasion() {

    }
    public Monster(){
        super(0, 0,0,null,(short) 0, (short)0, (short) 0, 0,0,null);
    }
    public Monster(int baseHp, int baseMana, int attack, List<Skill> skills, short strength, short mana, short dexterity, int hpMulti, int manaMulti, String name) {
        super(baseHp, baseMana, attack, skills, strength, mana, dexterity, hpMulti, manaMulti, name);
    }

    @Override
    public void generateDefense() {

    }
}
