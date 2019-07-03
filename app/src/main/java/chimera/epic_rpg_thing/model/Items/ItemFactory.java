package chimera.epic_rpg_thing.model.Items;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class ItemFactory {
    public static Item create(String name, int value, int slots, boolean equippable, boolean equipped, Benefit benefit, Type type, ElementalEffect effect){
        if(type instanceof ItemType){
            ItemType itemType = (ItemType) type;
            if(itemType == ItemType.CONSUMABLE){
                return new Consumable(name, value, slots, itemType, equippable, equipped, benefit, effect);
            }else if(itemType == ItemType.WEAPON_ONE_HANDED){
                return new Weapon(name, value, slots, itemType, equippable, equipped, benefit, effect);
            }else if(itemType == ItemType.WEAPON_TWO_HANDED){
                return new Weapon(name, value, slots, itemType, equippable, equipped, benefit, effect);
            }else if(itemType == ItemType.QUEST_ITEM){
                return new Quest_Item(name, value, slots, itemType, equippable, equipped, benefit, effect);
            }
        }else if (type instanceof ArmorType){
            ArmorType armorType = (ArmorType) type;
            return new Armor(name, value, slots, armorType, equippable, equipped, benefit);
        }
        return null;
    }
}
