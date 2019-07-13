package chimera.epic_rpg_thing.model;

import java.util.HashMap;

import chimera.epic_rpg_thing.model.Items.Item;

/**
 * Inventory class for all of our inventory needs.
 * Will be the parent of the different inventory types (i.e. store, playerCharacter, chest)
 * @Version 1.0
 * @Author Chimera
 */
public abstract class Inventory {
    HashMap<String, Item> items;
    int inventoryCapacity;
    int currentSlotAmount;
    Inventory(int capacity, int currentSlotAmount){
        this.currentSlotAmount = currentSlotAmount;
        this.inventoryCapacity = capacity;
    }

    public Inventory(int slots) {
    }

    /**
     * returns the inventory capacity
     * @return
     */
    public int getInventoryCapacity(){
        return inventoryCapacity;
    }

    /**
     * sets the inventory capacity
     * @param capacity
     */
    public void setInventoryCapacity(int capacity){
        inventoryCapacity = capacity;
    }

    /**
     * gets an item
     * @param key
     * @return
     */
    public Item getItem(String key){
        return items.get(key);
    }

    /**
     * adds an item to the map
     * @param key
     * @param item
     */
    public void addItem(String key, Item item){
        items.put(key, item);
    }

    /**
     * removes an item from the map
     * @param key
     */
    public void removeItem(String key){
        items.remove(key);
    }

    /**
     * gets the map
     * @return
     */
    public HashMap<String, Item> getMap(){
        return items;
    }

    /**
     * sets the map
     * @param map
     */
    public void setMap(HashMap<String, Item> map){
        items = map;
    }

    public void calculateSlotAmount(){
        for(HashMap.Entry<String, Item> e : items.entrySet()){
            if(!e.getValue().getEquipped()){
                currentSlotAmount += e.getValue().getNumSlots();
            }
        }
    }
}
