package chimera.epic_rpg_thing.model;

public class ElementalEffect {
    ElementalType type;
    short level;

    public ElementalEffect(){
        this.type = ElementalType.PHYSICAL;
        this.level = 0;
    }
    /**
     * Creates an elemental effect
     * @param type
     * @param level
     */
    public ElementalEffect(ElementalType type, short level){
        this.type = type;
        this.level = level;
    }

    public ElementalType getType() {
        return type;
    }

    public void setType(ElementalType type) {
        this.type = type;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }
}
