package chimera.epic_rpg_thing.model;

import java.util.List;

public class AOESkill implements Skill {
    ElementalEffect elementalEffect;
    EffectType effectType;
    int currentDuration;

    @Override
    public ElementalEffect getElementalEffect() {
        return elementalEffect;
    }

    @Override
    public void setElementalEffect(ElementalEffect elementalEffect) {
        this.elementalEffect = elementalEffect;
    }

    @Override
    public EffectType getEffectType() {
        return effectType;
    }

    @Override
    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    @Override
    public int getCurrentDuration() {
        return currentDuration;
    }

    @Override
    public void setCurrentDuration(int currentDuration) {
        this.currentDuration = currentDuration;
    }

    @Override
    public int getMaxDuration() {
        return maxDuration;
    }

    @Override
    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    @Override
    public void endOfTurn() {
        currentDuration--;
    }

    int maxDuration;
    int hpCost;
    int manaCost;
    List<Creature> targets;
    public AOESkill(int hpCost, int manaCost){
        this.hpCost = hpCost;
        this.manaCost = manaCost;
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

}
