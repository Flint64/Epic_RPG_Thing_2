package chimera.epic_rpg_thing.model;

import android.os.Parcelable;

public interface BaseSkill {
    // Getter and setter for the HPcost
    int getHpCost();
    void setHpCost(int hpCost);
    // Getter and setter for the manaCost
    int getManaCost();
    void setManaCost(int manaCost);
    // Getter and setter for the elementalEffect
    ElementalEffect getElementalEffect();
    void setElementalEffect(ElementalEffect elementalEffect);
    // Getter and Setter for the description
    String getDescription();
    void setDescription(String description);
    void effectTargets();
    String toString();
    String getCLASSNAME();
}
