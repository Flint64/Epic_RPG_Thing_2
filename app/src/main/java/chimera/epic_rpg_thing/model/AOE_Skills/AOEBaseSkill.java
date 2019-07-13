package chimera.epic_rpg_thing.model.AOE_Skills;

import java.util.List;

import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public abstract class AOEBaseSkill implements BaseSkill {
    private ElementalEffect elementalEffect;
    private String name;
    private int hpCost;
    private int manaCost;
    private int maxTargets;
    private String description;
    private List<Creature> targets;

    public ElementalEffect getElementalEffect() {
        return elementalEffect;
    }

    public void setElementalEffect(ElementalEffect elementalEffect) {
        this.elementalEffect = elementalEffect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getMaxTargets(){
        return maxTargets;
    }
    public void setMaxTargets(int maxTargets){
        this.maxTargets = maxTargets;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the targets from a given input. Will be used to pass in the targets for the effect
     * (i.e using fireball the presenter will get the targets and then pass them into the skill which
     * will then be used to apply damage to all of the targets.)
     * @param targets
     */
    public void setTargets(List<Creature> targets){
        this.targets = targets;
    }

    public List<Creature> getTargets(){
        return targets;
    }

    public void addTarget(Creature c) {
        this.targets.add(c);
    }

    /**
     * Effects the targets.
     */
    public final void effectTargets(){
        effectBuff();
        effectHP();
    }
    public abstract void effectHP();
    public abstract void effectBuff();
    public String toString(){
        return name + " " + hpCost + " " + manaCost;
    }
}
