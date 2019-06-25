package chimera.epic_rpg_thing.model;

public class RogueClass extends CharacterClass {
    public RogueClass(){
        this.classLevel = 0;
        this.setName("Rogue");
        this.addClassMod("baseHp", 5);
        this.addClassMod("baseMana", 60);
        this.addClassMod("attack", 10);
        this.addClassMod("hpMulti", 4);
        this.addClassMod("manaMulti", 6);
    }
}
