package chimera.epic_rpg_thing;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Character extends Creature{
    int level;
    int XP;
    boolean charactersLoaded;
    // ArrayLists for skills and items
    List<Item> items;

    // carry slot limit
    int carrySlots;

    public Character(int baseHp, int baseMana, int attack, List<Skill> skills, short strength, short mana, short dexterity, int hpMulti, int manaMulti) {
        super(baseHp, baseMana, attack, skills, strength, mana, dexterity, hpMulti, manaMulti);

    }

    @Override
    public void generateDefense() {

    }

    @Override
    public void generateEvasion() {

    }
}