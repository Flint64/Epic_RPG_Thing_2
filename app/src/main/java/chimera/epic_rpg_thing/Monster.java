package chimera.epic_rpg_thing;
import java.util.ArrayList;
import java.util.List;

public class Monster extends Creature {
    String name;
    int maxHP;
    int currentHP;
    int attack;
    int XPvalue;
    int goldValue;
    ArrayList<Skill> skills;
    boolean canRun;
    boolean isAlive;

    @Override
    public void generateEvasion() {

    }

    public Monster(int baseHp, int baseMana, int attack, List<Skill> skills, short strength, short mana, short dexterity, int hpMulti, int manaMulti, String name) {
        super(baseHp, baseMana, attack, skills, strength, mana, dexterity, hpMulti, manaMulti, name);
    }

    @Override
    public void generateDefense() {

    }
}
