package chimera.epic_rpg_thing.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CharacterInventory extends Inventory {
    CharacterInventory(int capacity, int currentSlots) {
        super(capacity, currentSlots);
    }

    public Benefit getEquippedBenefit(){
        Benefit ben = new Benefit();
        for(HashMap.Entry<String, Item> e : items.entrySet()){
            if(e.getValue().getEquipped()){
                ben.addBenefit(e.getValue().getBenefit());
            }
        }
        return ben;
    }
    public ArrayList<Benefit> getAllEquippedBenefits() {
        ArrayList<Benefit> ben = new ArrayList<>();
        for(HashMap.Entry<String, Item> e : items.entrySet()){
            if(e.getValue().getEquipped()){
                ben.add(e.getValue().getBenefit());
            }
        }
        return ben;
    }
}
