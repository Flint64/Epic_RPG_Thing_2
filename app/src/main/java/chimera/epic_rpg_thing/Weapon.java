package chimera.epic_rpg_thing;

public class Weapon implements Item {
    String name;
    int value;
    int slots;
    ItemType itemType;
    boolean equippable;
    boolean equipped;
    Benefit benefit;
    /**
     * Weapon Constructor.
     * @param name
     * @param value
     * @param slots
     * @param itemType
     * @param equippable
     * @param equipped
     */
    Weapon(String name, int value, int slots, ItemType itemType, boolean equippable, boolean equipped, Benefit benefit){
        this.name = name;
        this.value = value;
        this.slots = slots;
        this.itemType = itemType;
        this.equippable = equippable;
        this.equipped = equipped;
        this.benefit = benefit;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getNumSlots() {
        return slots;
    }

    @Override
    public void setNumSlots(int slots) {
        this.slots = slots;
    }

    /**
     * Don't use this function it is not intended for weapons.
     * @return
     */
    @Override
    public ArmorType getArmorType() {
        return null;
    }

    /**
     * Don't use this function it is not intended for weapons
     * @param type
     */
    @Override
    public void setArmorType(ArmorType type) {
        return;
    }

    @Override
    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public void setItemType(ItemType type) {
        this.itemType = type;
    }

    @Override
    public boolean getEquippable() {
        return equippable;
    }

    @Override
    public void setEquippable(boolean equippable) {
        this.equippable = equippable;
    }

    @Override
    public boolean getEquipped() {
        return equipped;
    }

    @Override
    public Benefit getBenefit() {
        return benefit;
    }

    @Override
    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    @Override
    public boolean isArmor() {
        return false;
    }
}
