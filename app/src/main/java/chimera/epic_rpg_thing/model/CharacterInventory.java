package chimera.epic_rpg_thing.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import chimera.epic_rpg_thing.model.Items.Armor;
import chimera.epic_rpg_thing.model.Items.ArmorType;
import chimera.epic_rpg_thing.model.Items.Item;
import chimera.epic_rpg_thing.model.Items.ItemType;
import chimera.epic_rpg_thing.model.Items.Weapon;

public class CharacterInventory extends Inventory {
    private Armor lBoot;
    private Armor rBoot;
    private Armor legs;
    private Armor chest;
    private Armor head;
    private Armor lHand;
    private Armor rHand;
    private Armor accessory;
    private Weapon rWeapon;
    private Weapon lWeapon;
    private boolean twoHanded;

    public CharacterInventory(int capacity, int currentSlots) {
        super(capacity, currentSlots);
    }

    /**
     * Generates what items should be equipped on the playerCharacter
     */
    public void generateEquipped(){
        for(Map.Entry<String, Item> item : getMap().entrySet()){
            item.getValue().setEquipped(false);
            if(item.getValue().isArmor()){
                if(item.getValue().equals(lBoot)){
                    item.getValue().setEquipped(true);
                } else if(item.getValue().equals(rBoot)){
                    item.getValue().setEquipped(true);
                } else if(item.getValue().equals(legs)){
                    item.getValue().setEquipped(true);
                } else if(item.getValue().equals(chest)){
                    item.getValue().setEquipped(true);
                } else if(item.getValue().equals(head)){
                    item.getValue().setEquipped(true);
                } else if(item.getValue().equals(lHand)){
                    item.getValue().setEquipped(true);
                } else if(item.getValue().equals(rHand)){
                    item.getValue().setEquipped(true);
                } else if(item.getValue().equals(accessory))
                    item.getValue().setEquipped(true);
            } else {
                if(item.getValue().equals(rWeapon)){
                    item.getValue().setEquipped(true);
                } else if(item.getValue().equals(lWeapon)){
                    item.getValue().setEquipped(true);
                }
            }

        }
    }

    /**
     * Returns the total benefits from the equipped items.
     * @return
     */
    public Benefit getEquippedBenefit(){
        generateEquipped();
        Benefit ben = new Benefit();
        for(HashMap.Entry<String, Item> e : items.entrySet()){
            if(e.getValue().getEquipped()){
                ben.addBenefit(e.getValue().getBenefit());
            }
        }
        return ben;
    }

    /**
     *
     * @return
     */
    public ArrayList<Benefit> getAllEquippedBenefits() {
        ArrayList<Benefit> ben = new ArrayList<>();
        for(HashMap.Entry<String, Item> e : items.entrySet()){
            if(e.getValue().getEquipped()){
                ben.add(e.getValue().getBenefit());
            }
        }
        return ben;
    }

    /**
     * Equips the item
     *
     * Usage will be that you find an item in the inventory and then pass it to this function to equip it to the playerCharacter.
     * @param item
     * @param leftHand
     */
    public void equipItem(Item item, boolean leftHand){
        if(item.getType() instanceof ItemType){
            ItemType itemType = (ItemType) item.getType();
            if(itemType == ItemType.WEAPON_TWO_HANDED){
                rWeapon = (Weapon) item;
                lWeapon.setEquipped(false);
            } else if(itemType == ItemType.WEAPON_ONE_HANDED){
                if(leftHand){
                    lWeapon = (Weapon) item;
                }else {
                    rWeapon = (Weapon) item;
                }
            } else {
                return;
            }
            item.setEquipped(true);
        } else {
            ArmorType armorType = (ArmorType) item.getType();
            if(armorType == ArmorType.L_BOOT){
                lBoot = (Armor) item;
            } else if(armorType == ArmorType.R_BOOT){
                rBoot = (Armor) item;
            } else if(armorType == ArmorType.LEGS){
                legs = (Armor) item;
            } else if(armorType == ArmorType.CHEST){
                chest = (Armor) item;
            } else if(armorType == ArmorType.R_HAND){
                rHand = (Armor) item;
            } else if(armorType == ArmorType.L_HAND){
                lHand = (Armor) item;
            } else if(armorType == ArmorType.HEAD){
                head = (Armor) item;
            } else {
                accessory = (Armor) item;
            }
            item.setEquipped(true);
        }
    }
}
