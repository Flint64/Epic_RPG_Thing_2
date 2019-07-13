package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public abstract class SingleBaseSkill extends BaseSkill {
    private ElementalEffect elementalEffect;
    private int hpCost;
    private int manaCost;
    private String name;
    private String description;
    private Creature target;

    /**
     * Gets the target of the SingleSkill
     * @return
     */
    public Creature getTarget() {
        return target;
    }

    /**
     * Sets the target of the SingleSkill
     * @param target
     */
    public void setTarget(Creature target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ElementalEffect getElementalEffect() {
        return elementalEffect;
    }

    public void setElementalEffect(ElementalEffect elementalEffect) {
        this.elementalEffect = elementalEffect;
    }

    public int getHpCost() {
        return hpCost;
    }

    public void setHpCost(int hpCost) {
        this.hpCost = hpCost;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Will be used to call the effects
     */
    public final void effectTargets(){
        effectBuff();
        effectHP();
    }
    public abstract void effectBuff();
    public abstract void effectHP();
    public String toString(){
        return name + " " + hpCost + " " + manaCost;
    }
}
