package chimera.epic_rpg_thing;

public class Benefit {
    short strengthBonus;
    short manaBonus;
    short dexterityBonus;
    int baseHealthBonus;
    int baseManaBonus;
    int attackBonus;
    Skill skill;

    Benefit(short strengthBonus, short manaBonus, short dexterityBonus, int baseHealthBonus, int baseManaBonus, int attackBonus, Skill skill){
        this.strengthBonus = strengthBonus;
        this.manaBonus = manaBonus;
        this.dexterityBonus = dexterityBonus;
        this.baseHealthBonus = baseHealthBonus;
        this.baseManaBonus = baseManaBonus;
        this.attackBonus = attackBonus;
        this.skill = skill;
    }
}
