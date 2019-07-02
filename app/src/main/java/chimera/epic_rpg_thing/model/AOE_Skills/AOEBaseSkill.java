package chimera.epic_rpg_thing.model.AOE_Skills;

import java.util.List;

import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public abstract class AOEBaseSkill implements BaseSkill {
    private ElementalEffect elementalEffect;
    private int hpCost;
    private int manaCost;
    private int maxTargets;
    private String description;
    private List<Creature> targets;

    @Override
    public ElementalEffect getElementalEffect() {
        return elementalEffect;
    }

    @Override
    public void setElementalEffect(ElementalEffect elementalEffect) {
        this.elementalEffect = elementalEffect;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    public int getMaxTargets(){
        return maxTargets;
    }
    public void setMaxTargets(int maxTargets){
        this.maxTargets = maxTargets;
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

    /**
     * Effects the targets.
     */
    public abstract void effectTargets();
}
