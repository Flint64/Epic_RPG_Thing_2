package chimera.epic_rpg_thing.model;
import java.util.List;

public class Character extends Creature{
    int level;
    int XP;
    boolean charactersLoaded;
    // ArrayLists for skills and items
    CharacterClass cClass;
    Inventory inventory;
    // carry slot limit
    int carrySlots;

    public Character(int baseHp, int baseMana, int attack, List<Skill> skills, short strength, short mana, short dexterity, int hpMulti, int manaMulti, String name) {
        super(baseHp, baseMana, attack, skills, strength, mana, dexterity, hpMulti, manaMulti, name);
        inventory = new CharacterInventory(strength * 5);
    }

    @Override
    public void generateDefense() {
        defense = 10 + strength * cClass.getClassMod("defense");
    }

    @Override
    public void generateEvasion() {
        evasion = 10 + dexterity * cClass.getClassMod("evasion");
    }
}