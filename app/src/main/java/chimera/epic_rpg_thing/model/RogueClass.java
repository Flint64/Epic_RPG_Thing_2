package chimera.epic_rpg_thing.model;

import java.util.HashMap;

public class RogueClass extends CharacterClass {
    public RogueClass(){
        this.classMods = new HashMap<>();
        this.classSkills = new HashMap<>();
        this.classLevel = 0;
        this.setName("Warrior");
        this.setName("Warrior");
        this.addClassMod("baseHp", 5);
        this.addClassMod("baseMana", 60);
        this.addClassMod("attack", 10);
        this.addClassMod("hpMulti", 4);
        this.addClassMod("manaMulti", 6);
    }
}
