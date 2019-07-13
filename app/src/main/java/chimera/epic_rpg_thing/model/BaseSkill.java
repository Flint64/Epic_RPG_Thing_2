package chimera.epic_rpg_thing.model;
public abstract class BaseSkill {
    // Getter and setter for the HPcost
    abstract int getHpCost();
    abstract void setHpCost(int hpCost);
    // Getter and setter for the manaCost
    abstract int getManaCost();
    abstract void setManaCost(int manaCost);
    // Getter and setter for the elementalEffect
    abstract ElementalEffect getElementalEffect();
    abstract void setElementalEffect(ElementalEffect elementalEffect);
    // Getter and Setter for the description
    abstract String getDescription();
    abstract void setDescription(String description);
    abstract void effectTargets();
    abstract public String toString();
}
