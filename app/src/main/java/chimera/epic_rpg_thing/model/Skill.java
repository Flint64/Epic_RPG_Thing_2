package chimera.epic_rpg_thing.model;
public interface Skill {
    // Getter and setter for the HPcost
    int getHpCost();
    void setHpCost(int hpCost);
    // Getter and setter for the manaCost
    int getManaCost();
    void setManaCost(int manaCost);
    // Getter and setter for the elementalEffect
    ElementalEffect getElementalEffect();
    void setElementalEffect(ElementalEffect elementalEffect);
    // Getter and setter for the effectType
    EffectType getEffectType();
    void setEffectType(EffectType effectType);
    // Getter and setter for the currentDuration
    int getCurrentDuration();
    void setCurrentDuration(int currentDuration);
    // Getter and setter for the maxDuration
    int getMaxDuration();
    void setMaxDuration(int maxDuration);

    // Function that will decrement the duration at the end of a turn.
    void endOfTurn();
}
