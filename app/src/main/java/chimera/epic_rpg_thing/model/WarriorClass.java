package chimera.epic_rpg_thing.model;

public class WarriorClass extends CharacterClass {
    public WarriorClass(){
        this.classLevel = 0;
        this.setName("Warrior");
        this.addClassMod("hpMulti", 10);
        this.addClassMod("manaMulti", 3);
        this.addWeaknesses(new ElementalEffect(ElementalType.POISON, (short)1));
    }

    private void initializeSkills(){
        this.classSkills.put("BerserkerRage1", new AOEDamage(0,0,0, null, 0, null));
    }
}
