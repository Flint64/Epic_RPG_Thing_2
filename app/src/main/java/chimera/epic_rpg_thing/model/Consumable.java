package chimera.epic_rpg_thing.model;

public class Consumable implements Item {
    private String name;
    private int value;
    private int slots;
    private ItemType itemType;
    private boolean equippable;
    private boolean equipped;
    private Benefit benefit;
    Consumable(String name, int value, int slots, ItemType itemType, boolean equippable, boolean equipped, Benefit benefit){
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



    @Override
    public Type getType() {
        return itemType;
    }

    @Override
    public void setType(Type type) {
        if(type instanceof ItemType) this.itemType = (ItemType) type;
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
        return false;
    }

    @Override
    public Benefit getBenefit() {
        return benefit;
    }

    @Override
    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }
}