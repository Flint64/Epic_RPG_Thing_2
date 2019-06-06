package chimera.epic_rpg_thing;
import java.util.List;

public class Character {
    // Stats for hp indicator
    int maxHP;
    int currentHP;
    // Stats for mana indicator
    int maxMana;
    int currentMana;
    // Base attack
    int attack;
    // Level and experience
    int level;
    int XP;
    // ArrayLists for skills and items
    List<Skill> skills;
    List<Item> items;
    // Money!!!
    int gold;
    // Base defense
    int defense;
    // carry slot limit
    int carrySlots;

    // Character attributes
    short strength;
    short mana;
    short dexterity;
}