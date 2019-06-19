package chimera.epic_rpg_thing.model;
import java.util.List;

public class Character extends Creature{
    int level;
    int XP;
    // ArrayLists for skills and items
    CharacterClass cClass;
    Inventory inventory;
    int baseSlots = 20;
    int baseSlotMod = 5;

    /**
     * Creates a character by passing values to the super constructor and by initializing the CharacterInventory
     * @param currentSkills
     * @param strength
     * @param mana
     * @param dexterity
     * @param name
     * @param cClass
     */
    public Character(List<Skill> currentSkills, short strength, short mana, short dexterity, String name, CharacterClass cClass) {
        super(cClass.getClassMod("baseHp"), cClass.getClassMod("baseMana"), cClass.getClassMod("attack"), currentSkills, strength, mana, dexterity, cClass.getClassMod("hpMulti"), cClass.getClassMod("manaMulti"), name);
        inventory = new CharacterInventory(baseSlots + strength * baseSlotMod);
        level = 0;
        XP = 0;
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