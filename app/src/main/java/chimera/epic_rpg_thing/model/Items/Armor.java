package chimera.epic_rpg_thing.model.Items;

import androidx.annotation.Nullable;

import chimera.epic_rpg_thing.model.Benefit;

/**
 * The class for Armor pieces
 */
public class Armor implements Item {
    String name;
    int value;
    int slots;
    ArmorType armorType;
    boolean equippable;
    boolean equipped;
    Benefit benefit;

    public Armor(){
        this.name = "DEFAULT";
        this.value = 0;
        this.slots = 0;
        this.armorType = ArmorType.DEFAULT;
        this.equippable = false;
        this.equipped = false;
        this.benefit = new Benefit();
    }
    /**
     * Creates armor
     * @param name
     * @param value
     * @param slots
     * @param armorType
     * @param equippable
     * @param equipped
     * @param benefit
     */
    public Armor(String name, int value, int slots, ArmorType armorType, boolean equippable, boolean equipped, Benefit benefit){
        this.name = name;
        this.value = value;
        this.slots = slots;
        this.armorType = armorType;
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

    @Override
    public Type getType() {
        return armorType;
    }

    @Override
    public void setType(Type type) {
        if(type instanceof ArmorType) {
            this.armorType = (ArmorType) type;
        }
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
    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    @Override
    public boolean isArmor() {
        return true;
    }

    @Override
    public Benefit getBenefit() {
        return benefit;
    }

    @Override
    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj == null)
            return false;
        if(obj instanceof Armor){
            Armor armor = (Armor) obj;
            return (this.name.equals(armor.getName()) && this.value == armor.getValue() && this.slots == armor.getNumSlots() && this.armorType == (ArmorType) armor.getType() && this.equippable == armor.getEquippable() && this.benefit.equals(armor.getBenefit()));
        } else {
            return false;
        }
    }
}
