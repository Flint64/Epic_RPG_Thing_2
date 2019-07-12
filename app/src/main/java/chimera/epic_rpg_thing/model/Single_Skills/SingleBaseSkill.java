package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public abstract class SingleBaseSkill implements BaseSkill {
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

    @Override
    public ElementalEffect getElementalEffect() {
        return elementalEffect;
    }

    @Override
    public void setElementalEffect(ElementalEffect elementalEffect) {
        this.elementalEffect = elementalEffect;
    }

    @Override
    public int getHpCost() {
        return hpCost;
    }

    @Override
    public void setHpCost(int hpCost) {
        this.hpCost = hpCost;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    @Override
    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
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
