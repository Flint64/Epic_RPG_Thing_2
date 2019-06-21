package chimera.epic_rpg_thing.model;

import java.util.HashMap;

public class WarriorClass extends CharacterClass {
    public WarriorClass(){
        this.classMods = new HashMap<>();
        this.classSkills = new HashMap<>();
        this.classLevel = 0;
        this.setName("Warrior");
        this.addClassMod("baseHp", 10);
        this.addClassMod("baseMana", 50);
        this.addClassMod("attack", 10);
        this.addClassMod("hpMulti", 10);
        this.addClassMod("manaMulti", 3);
    }
}
