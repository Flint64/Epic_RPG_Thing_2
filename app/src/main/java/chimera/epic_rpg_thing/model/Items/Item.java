package chimera.epic_rpg_thing.model.Items;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.Type;

public interface Item {
    /**
     * returns the item's name
     * @return name
     */
    String getName();

    /**
     * sets the item's name
     * @param name
     */
    void setName(String name);

    /**
     * returns the value
     * @return value
     */
    int getValue();

    /**
     * sets the value
     * @param value
     */
    void setValue(int value);

    /**
     * gets the slots
     * @return slots
     */
    int getNumSlots();

    /**
     * sets the number of slots
     * @param slots
     */
    void setNumSlots(int slots);

    /**
     * gets the type of the item
     * @return armorType
     */
    Type getType();

    /**
     * sets the type of the item
     * @param type
     */
    void setType(Type type);

    /**
     * gets the equipable status of the item
     * @return equipable
     */
    boolean getEquippable();

    /**
     * sets the equipable status of the item
     * @param equippable
     */
    void setEquippable(boolean equippable);

    /**
     * gets whether the item is equipped
     * @return equipped
     */
    boolean getEquipped();

    /**
     * sets the item to be equipped or not.
     * @param equipped
     */
    void setEquipped(boolean equipped);

    /**
     * Returns if item is armor
     * @return boolean
     */
    boolean isArmor();

    /**
     * gets the benefit of the item
     * @return
     */
    Benefit getBenefit();

    /**
     * sets the benefit of the item
     * @param benefit
     */
    void setBenefit(Benefit benefit);
}
