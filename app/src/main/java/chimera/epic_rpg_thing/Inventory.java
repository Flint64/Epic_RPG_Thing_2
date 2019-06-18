package chimera.epic_rpg_thing;

import java.util.List;

/**
 * Inventory class for all of our inventory needs.
 * Will be the parent of the different inventory types (i.e. store, character, chest)
 * @Version 1.0
 * @Author Chimera
 */
public abstract class Inventory {
    List<Item> items;
    int slots;
    Inventory(int slots){
        this.slots = slots;
    }

}
